package com.example.cdc.consumer.service;

import com.example.cdc.consumer.dto.GreetingDTO;

public interface GreetingService {
    public String greetPerson(GreetingDTO greeting);
}
