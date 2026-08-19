package com.senai.musica.entities;

import com.senai.musica.enums.Genero;
import com.senai.musica.enums.Plataforma;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomePlaylist;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero generoPredominante;

    @Column(nullable = false)
    private Integer quantidadeMusicas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Plataforma plataforma;

    public Playlist() {
    }

    public Playlist(Long id, String nomePlaylist, Genero generoPredominante,
                    Integer quantidadeMusicas, Plataforma plataforma) {
        this.id = id;
        this.nomePlaylist = nomePlaylist;
        this.generoPredominante = generoPredominante;
        this.quantidadeMusicas = quantidadeMusicas;
        this.plataforma = plataforma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public Genero getGeneroPredominante() {
        return generoPredominante;
    }

    public void setGeneroPredominante(Genero generoPredominante) {
        this.generoPredominante = generoPredominante;
    }

    public Integer getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public void setQuantidadeMusicas(Integer quantidadeMusicas) {
        this.quantidadeMusicas = quantidadeMusicas;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
}