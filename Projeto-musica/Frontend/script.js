const API_URL = "http://localhost:8080/playlists";

const formulario = document.getElementById("formulario-playlist");
const lista = document.getElementById("lista-playlists");
const erro = document.getElementById("mensagem-erro");

let idEditando = null;

async function listar() {
    try {
        const resposta = await fetch(API_URL);
        const playlists = await resposta.json();

        lista.innerHTML = "";

        if (playlists.length === 0) {
            lista.innerHTML = `<p class="mensagem-vazia">Nenhuma playlist cadastrada</p>`;
            return;
        }

        playlists.forEach(p => {
            lista.innerHTML += `
                <div class="cartao-playlist">
                    <div class="info-principal">
                        <h3>${p.nomePlaylist}</h3>
                        <span class="tag-plataforma">${formatarPlataforma(p.plataforma)}</span>
                    </div>

                    <div class="info-detalhes">
                        <p><strong>Gênero:</strong> ${formatarGenero(p.generoPredominante)}</p>
                        <p><strong>Músicas:</strong> ${p.quantidadeMusicas}</p>
                    </div>

                    <div class="acoes">
                        <button onclick="editar(${p.id})">Editar</button>
                        <button onclick="excluir(${p.id})">Excluir</button>
                    </div>
                </div>
            `;
        });

    } catch (e) {
        erro.textContent = "Não foi possível carregar as playlists.";
    }
}

formulario.addEventListener("submit", async (e) => {
    e.preventDefault();

    const playlist = {
        nomePlaylist: document.getElementById("nome-playlist").value.trim(),
        generoPredominante: document.getElementById("genero").value,
        quantidadeMusicas: Number(document.getElementById("quantidade-musicas").value),
        plataforma: document.getElementById("plataforma").value
    };

    erro.textContent = "";

    if (playlist.quantidadeMusicas <= 0) {
        erro.textContent = "A quantidade de músicas deve ser maior que zero.";
        return;
    }

    if (
        playlist.generoPredominante === "K_POP" &&
        playlist.quantidadeMusicas < 10
    ) {
        erro.textContent = "Playlists de K-Pop devem possuir no mínimo 10 músicas.";
        return;
    }

    try {
        const url = idEditando
            ? `${API_URL}/${idEditando}`
            : API_URL;

        const metodo = idEditando ? "PUT" : "POST";

        const resposta = await fetch(url, {
            method: metodo,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(playlist)
        });

        if (!resposta.ok) {
            const mensagem = await resposta.text();
            erro.textContent = mensagem;
            return;
        }

        formulario.reset();
        idEditando = null;
        formulario.querySelector("button").textContent = "Cadastrar Playlist";

        await listar();

    } catch (e) {
        erro.textContent = "Não foi possível conectar ao servidor.";
    }
});

async function editar(id) {
    try {
        const resposta = await fetch(`${API_URL}/${id}`);
        const p = await resposta.json();

        document.getElementById("nome-playlist").value = p.nomePlaylist;
        document.getElementById("genero").value = p.generoPredominante;
        document.getElementById("quantidade-musicas").value = p.quantidadeMusicas;
        document.getElementById("plataforma").value = p.plataforma;

        idEditando = id;
        formulario.querySelector("button").textContent = "Salvar Alterações";

        erro.textContent = "";

    } catch (e) {
        erro.textContent = "Não foi possível carregar a playlist.";
    }
}

async function excluir(id) {
    if (!confirm("Deseja realmente excluir esta playlist?")) {
        return;
    }

    try {
        const resposta = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (!resposta.ok) {
            erro.textContent = "Não foi possível excluir a playlist.";
            return;
        }

        await listar();

    } catch (e) {
        erro.textContent = "Não foi possível conectar ao servidor.";
    }
}

function formatarGenero(genero) {
    return {
        K_POP: "K-Pop",
        TRAP: "Trap",
        ROCK: "Rock",
        MPB: "MPB"
    }[genero] || genero;
}

function formatarPlataforma(plataforma) {
    return {
        SPOTIFY: "Spotify",
        DEEZER: "Deezer",
        APPLE_MUSIC: "Apple Music"
    }[plataforma] || plataforma;
}

listar();