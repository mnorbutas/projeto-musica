package com.senai.musica.repositories;

import com.senai.musica.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    boolean existsByNomePlaylistIgnoreCase(String nomePlaylist);
}