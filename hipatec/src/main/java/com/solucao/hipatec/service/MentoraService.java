package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Mentora;
import com.solucao.hipatec.repository.MentoraRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentoraService {

    private final MentoraRepository repository;

    public MentoraService(MentoraRepository repository) {
        this.repository = repository;
    }

    public List<Mentora> listar() {
        return repository.findAll();
    }

    public Mentora salvar(Mentora mentora) {
        return repository.save(mentora);
    }

     @PersistenceContext
    private EntityManager entityManager;

    public Integer login(String email, String senha) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("login_mentora");

        query.registerStoredProcedureParameter(
                "email",
                String.class,
                jakarta.persistence.ParameterMode.IN
        );

        query.registerStoredProcedureParameter(
                "senha",
                String.class,
                jakarta.persistence.ParameterMode.IN
        );

        query.setParameter("email", email);
        query.setParameter("senha", senha);

        Object resultado = query.getSingleResult();

        return ((Number) resultado).intValue();
    }
}