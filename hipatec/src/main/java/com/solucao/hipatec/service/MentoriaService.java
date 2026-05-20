package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Mentoria;
import com.solucao.hipatec.repository.MentoriaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentoriaService {

    private final MentoriaRepository repository;

    public MentoriaService(MentoriaRepository repository) {
        this.repository = repository;
    }

    public List<Mentoria> listar() {
        return repository.findAll();
    }

    public Mentoria salvar(Mentoria mentoria) {
        return repository.save(mentoria);
    }

     @PersistenceContext
    private EntityManager entityManager;

}