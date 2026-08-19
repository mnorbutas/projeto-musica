package com.senai.musica.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.musica.entities.Playlist;
import com.senai.musica.enums.Genero;
import com.senai.musica.repositories.PlaylistRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> listarTodos() {
        return playlistRepository.findAll();
    }

    public Playlist buscarPorId(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Playlist não encontrada."
                ));
    }

    public Playlist salvar(Playlist playlist) {

        if (playlistRepository.existsByNomePlaylistIgnoreCase(
                playlist.getNomePlaylist())) {

            throw new RuntimeException(
                    "Já existe uma playlist com esse nome."
            );
        }

        if (playlist.getQuantidadeMusicas() == null ||
                playlist.getQuantidadeMusicas() <= 0) {

            throw new RuntimeException(
                    "A quantidade de músicas deve ser maior que zero."
            );
        }

        if (playlist.getGeneroPredominante() == Genero.K_POP &&
                playlist.getQuantidadeMusicas() < 10) {

            throw new RuntimeException(
                    "Playlists de K-Pop devem possuir no mínimo 10 músicas."
            );
        }

        return playlistRepository.save(playlist);
    }

    public Playlist atualizar(Long id, Playlist dados) {

        Playlist playlist = buscarPorId(id);

        if (!playlist.getNomePlaylist()
                .equalsIgnoreCase(dados.getNomePlaylist())) {

            if (playlistRepository.existsByNomePlaylistIgnoreCase(
                    dados.getNomePlaylist())) {

                throw new RuntimeException(
                        "Já existe uma playlist com esse nome."
                );
            }
        }

        if (dados.getQuantidadeMusicas() == null ||
                dados.getQuantidadeMusicas() <= 0) {

            throw new RuntimeException(
                    "A quantidade de músicas deve ser maior que zero."
            );
        }

        if (dados.getGeneroPredominante() == Genero.K_POP &&
                dados.getQuantidadeMusicas() < 10) {

            throw new RuntimeException(
                    "Playlists de K-Pop devem possuir no mínimo 10 músicas."
            );
        }

        playlist.setNomePlaylist(dados.getNomePlaylist());
        playlist.setGeneroPredominante(dados.getGeneroPredominante());
        playlist.setQuantidadeMusicas(dados.getQuantidadeMusicas());
        playlist.setPlataforma(dados.getPlataforma());

        return playlistRepository.save(playlist);
    }

    public void deletar(Long id) {
        Playlist playlist = buscarPorId(id);
        playlistRepository.delete(playlist);
    }
}