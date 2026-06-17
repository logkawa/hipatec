package com.solucao.hipatec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solucao.hipatec.service.PostService;
import com.solucao.hipatec.model.Post;
import com.solucao.hipatec.dto.ComentarioDTO;
import com.solucao.hipatec.model.Comentario;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<Void> criar(
            @RequestBody Post post) {

        System.out.println(post);

        service.criar(post);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Post>> listarTodos() throws Exception {

        return ResponseEntity.ok(
                service.listarTodos());
    }

    @GetMapping("/autor/{autorId}")
    public ResponseEntity<List<Post>> listarPorAutor(
            @PathVariable Integer autorId)
            throws Exception {

        return ResponseEntity.ok(
                service.listarPorAutor(
                        autorId));
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Void> curtir(
            @PathVariable String id,
            @RequestParam Integer usuarioId) {

        service.curtir(id, usuarioId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/like")
    public ResponseEntity<Void> descurtir(
            @PathVariable String id,
            @RequestParam Integer usuarioId) {

        service.descurtir(id, usuarioId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<Void> comentar(
            @PathVariable String id,
            @RequestBody ComentarioDTO dto) {

        Comentario comentario = new Comentario();

        comentario.setAutorId(dto.getUsuarioId());
        comentario.setAutorNome(dto.getAutorNome());
        comentario.setAutorFoto(dto.getAutorFoto());
        comentario.setTexto(dto.getTexto());

        service.comentar(id, comentario);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/repost")
    public ResponseEntity<Void> repostar(
            @PathVariable String id,
            @RequestParam Integer usuarioId) {

        service.repostar(id, usuarioId);

        return ResponseEntity.ok().build();
    }
}