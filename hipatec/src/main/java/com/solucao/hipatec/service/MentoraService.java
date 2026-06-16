package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Mentora;
import com.solucao.hipatec.model.Mentora;
import com.solucao.hipatec.model.Perfil;
import com.solucao.hipatec.repository.MentoraRepository;
import com.solucao.hipatec.repository.MentoraRepository;
import com.solucao.hipatec.repository.PerfilRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

    
    public Mentora buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
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

    @Autowired
    private MentoraRepository MentoraRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    public Mentora salvar(Mentora mentora) {

        System.out.println("Entrou no save");

        Mentora mentoraSalvo = MentoraRepository.save(mentora);

        System.out.println("Mentora salvo: " + mentoraSalvo.getId());

        Perfil perfil = new Perfil();

        perfil.setUsuario(mentora.getUsuario());

        System.out.println("Usuario: " + mentora.getUsuario());

        perfil.setBiografia("");
        perfil.setNum_seguidores(0);
        perfil.setNum_seguindo(0);

        perfil.setId_mentora(mentoraSalvo.getId());

        perfilRepository.save(perfil);

        System.out.println("Perfil salvo");

        return mentoraSalvo;
    }
}