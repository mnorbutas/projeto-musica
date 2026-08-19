# Projeto Estilos de Música – Cadastro de Playlists

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge\&logo=springboot\&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge\&logo=mysql\&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge\&logo=javascript\&logoColor=%23F7DF1E)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge\&logo=html5\&logoColor=white)
![CSS3](https://img.shields.io/badge/css-%23663399.svg?style=for-the-badge\&logo=css3\&logoColor=white)

## Sobre o projeto

O **Cadastro de Estilos Musicais – Playlists** é uma aplicação Full Stack desenvolvida para realizar o cadastro e gerenciamento de playlists musicais.

O sistema permite cadastrar, consultar, atualizar e excluir playlists, armazenando informações como nome da playlist, gênero predominante, quantidade de músicas e plataforma utilizada.

Este projeto foi desenvolvido **individualmente por Maria Eduarda Norbutas**, com o objetivo de aplicar conhecimentos de desenvolvimento de APIs REST, programação em Java, Spring Boot, persistência de dados em banco de dados e integração com uma interface web.

O projeto foi desenvolvido no **Curso Técnico de Desenvolvimento de Sistemas do SENAI Sorocaba - Gaspar Ricardo Júnior**.



## Objetivo do sistema

O sistema tem como objetivo possibilitar o gerenciamento de playlists musicais, garantindo que os dados cadastrados respeitem as regras de negócio definidas para a aplicação.

### Dados da Playlist

Cada playlist possui os seguintes campos:

* **ID:** gerado automaticamente pelo sistema.
* **Nome da Playlist:** nome utilizado para identificar a playlist.
* **Gênero Predominante:** K-Pop, Trap, Rock ou MPB.
* **Quantidade de Músicas:** quantidade de faixas presentes na playlist.
* **Plataforma:** Spotify, Deezer ou Apple Music.



## Regras de negócio

O sistema implementa obrigatoriamente as seguintes regras:

* Não é permitido cadastrar duas playlists com o mesmo nome.
* A quantidade de músicas não pode ser igual a zero.
* A quantidade de músicas não pode ser negativa.
* Playlists do gênero **K-Pop** devem possuir no mínimo **10 músicas**.
* O ID da playlist é gerado automaticamente pelo sistema.
* O gênero predominante deve ser uma das opções permitidas: **K-Pop, Trap, Rock ou MPB**.
* A plataforma deve ser uma das opções permitidas: **Spotify, Deezer ou Apple Music**.

## Tecnologias utilizadas

### Backend

**Java:** linguagem utilizada para o desenvolvimento da aplicação.

**Spring Boot:** framework utilizado para construção da API REST e organização do backend.

**Spring Data JPA:** utilizado para realizar a comunicação entre a aplicação e o banco de dados.

### Banco de Dados

**MySQL:** banco de dados utilizado para armazenamento e persistência das playlists.

### Frontend

**HTML5:** estrutura das páginas da aplicação.

**CSS3:** estilização e organização visual da interface.

**JavaScript:** responsável pela interatividade da aplicação e pelo consumo da API REST.

---

## Estrutura da entidade

A aplicação possui uma única entidade principal:

### Playlist

| Campo              | Tipo    | Descrição                            |
| :----------------- | :------ | :----------------------------------- |
| id                 | Long    | Identificador gerado automaticamente |
| nomePlaylist       | String  | Nome da playlist                     |
| generoPredominante | String  | Gênero musical predominante          |
| quantidadeMusicas  | Integer | Quantidade de músicas                |
| plataforma         | String  | Plataforma da playlist               |

### Gêneros permitidos

* K-Pop
* Trap
* Rock
* MPB

### Plataformas permitidas

* Spotify
* Deezer
* Apple Music

---

## Endpoints

| Método | Endpoint          | Descrição                       |
| :----- | :---------------- | :------------------------------ |
| GET    | `/playlists`      | Lista todas as playlists        |
| GET    | `/playlists/{id}` | Busca uma playlist pelo ID      |
| POST   | `/playlists`      | Cadastra uma nova playlist      |
| PUT    | `/playlists/{id}` | Atualiza uma playlist existente |
| DELETE | `/playlists/{id}` | Exclui uma playlist             |


## Organização do projeto

```text
Projeto-Playlists
│
├── Backend
│   └── Spring Boot
│
├── Frontend
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── README.md
```

## Desenvolvedora

**Maria Eduarda Norbutas**

Projeto desenvolvido individualmente para o **Curso Técnico de Desenvolvimento de Sistemas – SENAI Sorocaba - Gaspar Ricardo Júnior**.
