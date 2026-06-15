package com.solucao.hipatec.controller;

import com.solucao.hipatec.model.Estudante;
import com.solucao.hipatec.service.EstudanteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteService service;

    public EstudanteController(
            EstudanteService service
    ) {
        this.service = service;
    }

    // LISTAR ESTUDANTES
    @GetMapping
    public List<Estudante> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable Integer id) {    
        return service.buscarPorId(id);
    }

    // SALVAR ESTUDANTE
    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante) {
        return service.salvar(estudante);
    }

    @PostMapping("/login")
    public Integer login(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        return service.login(email, senha);
    }
}