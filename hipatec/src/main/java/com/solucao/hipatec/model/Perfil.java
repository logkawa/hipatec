package com.solucao.hipatec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String biografia;

    private Integer num_seguidores = 0;

    private Integer num_seguindo = 0;

    private Integer num_publicacoes = 0;

    private String usuario;

    private String pfp;

    private String background;

    private Integer id_estudante;
    
    private Integer id_mentora;
}