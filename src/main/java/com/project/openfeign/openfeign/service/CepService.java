package com.project.openfeign.openfeign.service;

import com.project.openfeign.openfeign.model.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "cep", url = "${feign.url.cep}")
public interface CepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{cepRequest}")
    Cep getCep(@PathVariable("cepRequest") String cepRequest);
}
