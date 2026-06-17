package com.solucao.hipatec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedItem {

    private String tipo;

    private String postOriginalId;

    private Long dataCriacao;
}