package com.project.openfeign.openfeign.service;

import com.project.openfeign.openfeign.AbstractTest;
import com.project.openfeign.openfeign.model.Cep;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

class CepServiceTest extends AbstractTest {

    @Mock
    private CepService cepService;


    @Test
    void should_returnCep_when_find_given_CepExists() {
        String cepRequest = "28915230";
        var cepResponse = Cep.builder()
                .cep(cepRequest)
                .city("Cidade")
                .state("RJ")
                .neighborhood("bairro")
                .street("Rua")
                .build();

        when(cepService.getCep(anyString())).thenReturn(cepResponse);

        var cep = cepService.getCep(cepRequest);

        assertNotNull(cep);
        assertEquals(cepResponse.getCep(), cepRequest);
    }
}