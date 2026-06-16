package com.solucao.hipatec.repository;

import com.solucao.hipatec.model.Perfil;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.query.Procedure;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.Query;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
     @Query("SELECT p FROM Perfil p WHERE p.id_estudante = :id")
    Perfil buscarPorEstudante(Integer id);

    @Query("SELECT p FROM Perfil p WHERE p.id_mentora = :id")
    Perfil buscarPorMentora(Integer id);
}