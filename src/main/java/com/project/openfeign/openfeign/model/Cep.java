package com.project.openfeign.openfeign.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Cep {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private Location location;
}
