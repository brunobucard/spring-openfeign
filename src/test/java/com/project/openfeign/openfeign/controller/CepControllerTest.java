package com.project.openfeign.openfeign.controller;

import com.project.openfeign.openfeign.AbstractTest;
import com.project.openfeign.openfeign.model.Cep;
import com.project.openfeign.openfeign.service.CepService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CepControllerTest extends AbstractTest {

    @InjectMocks
    private CepController cepController;

    @Mock
    private CepService cepService;

    @ParameterizedTest
    @MethodSource("provideCepRequests")
    void Should_returnCep_when_findCep_given_cepExists(String cepRequest) {
        var cepResponse = Cep.builder()
                .cep(cepRequest)
                .city("Cidade")
                .state("RJ")
                .neighborhood("bairro")
                .street("Rua")
                .build();

        when(cepService.getCep(cepRequest)).thenReturn(cepResponse);

        var responseEntity = cepController.findCep(cepRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");
        assertEquals(cepResponse, responseEntity.getBody(), "Returned CEP should match");
    }

    private static Stream<String> provideCepRequests() {
        return Stream.of("28915230", "28470000", "28654000");
    }
}