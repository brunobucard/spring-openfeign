package com.project.openfeign.openfeign.controller;

import com.project.openfeign.openfeign.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity getUsuario() {
        var usuario = usuarioService.getUsuario();

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
