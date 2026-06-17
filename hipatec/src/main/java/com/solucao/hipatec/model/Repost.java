package com.solucao.hipatec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repost {

    private Integer usuarioId;

    private Long dataCriacao;
}
