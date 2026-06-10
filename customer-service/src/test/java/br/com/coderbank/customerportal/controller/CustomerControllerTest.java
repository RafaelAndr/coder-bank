package br.com.coderbank.customerportal.controller;

import br.com.coderbank.customerportal.dto.request.CustomerRequestDto;
import br.com.coderbank.customerportal.dto.response.CustomerResponseDto;
import br.com.coderbank.customerportal.enuns.Status;
import br.com.coderbank.customerportal.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveSalvarCliente() throws Exception {

        CustomerRequestDto request = new CustomerRequestDto(
                "Rafael",
                "12345678900",
                "rafael@email.com",
                "Rua A",
                25
        );

        CustomerResponseDto response = new CustomerResponseDto(
                UUID.randomUUID(),
                Status.ACTIVE,
                "admin",
                "2026-03-21T10:00:00",
                null,
                null
        );

        Mockito.when(service.save(Mockito.any()))
                .thenReturn(response);

        mockMvc.perform(post("/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.createdByUser").value("admin"));
    }
}