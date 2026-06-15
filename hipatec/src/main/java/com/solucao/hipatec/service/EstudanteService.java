package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Estudante;
import com.solucao.hipatec.repository.EstudanteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public List<Estudante> listar() {
        return repository.findAll();
    }

    public Estudante buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Estudante salvar(Estudante estudante) {
        return repository.save(estudante);
    }
    @PersistenceContext
    private EntityManager entityManager;

    public Integer login(String email, String senha) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("login_estudante");

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