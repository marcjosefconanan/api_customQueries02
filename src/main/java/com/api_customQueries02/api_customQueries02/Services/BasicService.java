package com.api_customQueries02.api_customQueries02.Services;

import org.springframework.stereotype.Service;

@Service
public class BasicService {
    public String hello() {
        String saluto = "Benvenuti";
        return saluto;
    }
}