package com.project.openfeign.openfeign.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {

    private String nome;
    private String email;
    private int idade;
}
