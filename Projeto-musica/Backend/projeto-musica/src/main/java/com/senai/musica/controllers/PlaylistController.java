package com.senai.musica.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.musica.entities.Playlist;
import com.senai.musica.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> listarTodos() {
        return ResponseEntity.ok(playlistService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                playlistService.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Playlist playlist) {
        try {
            return ResponseEntity.ok(
                    playlistService.salvar(playlist)
            );
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Playlist playlist) {

        try {
            return ResponseEntity.ok(
                    playlistService.atualizar(id, playlist)
            );
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        playlistService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}