package com.solucao.hipatec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private String id;
    private Integer autorId;
    private String conteudo;
    private String imagemUrl;
    private String autorFoto;


    private Long dataCriacao;

    private Integer likesCount;
    private Integer commentsCount;
    private Integer repostsCount;

}