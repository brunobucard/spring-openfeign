package com.project.openfeign.openfeign.service;

import com.project.openfeign.openfeign.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "usuario", url = "http://localhost:8090/usuario")
public interface UsuarioService {

    @RequestMapping(method = RequestMethod.GET, value = "")
    Usuario getUsuario();
}
