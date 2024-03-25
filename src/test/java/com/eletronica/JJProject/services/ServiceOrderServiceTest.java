package com.eletronica.JJProject.services;

import com.eletronica.JJProject.mapper.ServiceOrderMapper;
import com.eletronica.JJProject.repositories.ServiceOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class ServiceOrderServiceTest {

    @Mock
    private ServiceOrderRepository repository;

    @Mock
    private ServiceOrderMapper mapper;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create(){
    }
}