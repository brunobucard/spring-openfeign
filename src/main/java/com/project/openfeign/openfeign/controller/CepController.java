package com.project.openfeign.openfeign.controller;

import com.project.openfeign.openfeign.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("{cepRequest}")
    public ResponseEntity findCep(@PathVariable String cepRequest) {
        var cepResponse = cepService.getCep(cepRequest);

        return ResponseEntity.status(HttpStatus.OK).body(cepResponse);
    }
}
