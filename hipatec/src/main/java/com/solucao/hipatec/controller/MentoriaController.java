package com.solucao.hipatec.controller;

import com.solucao.hipatec.model.Mentoria;
import com.solucao.hipatec.service.MentoriaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/mentorias")
public class MentoriaController {

    private final MentoriaService service;

    public MentoriaController(MentoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mentoria> listar() {
        return service.listar();
    }

    @PostMapping
    public Mentoria salvar(@RequestBody Mentoria mentoria) {
        return service.salvar(mentoria);
    }
}