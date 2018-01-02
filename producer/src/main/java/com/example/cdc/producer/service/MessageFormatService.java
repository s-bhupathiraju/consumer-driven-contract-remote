package com.example.cdc.producer.service;

import com.example.cdc.producer.model.FormattedGreetingDTO;
import com.example.cdc.producer.model.GreetingDTO;

public interface MessageFormatService {
    public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting);
}
