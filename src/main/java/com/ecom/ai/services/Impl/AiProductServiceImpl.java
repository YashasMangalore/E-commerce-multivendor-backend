package com.ecom.ai.services.Impl;


import com.ecom.ai.services.AiProductService;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

@Service
public class AiProductServiceImpl implements AiProductService {

    @Value("${gemini.api.key}")
    private static String API_KEY;


    @Override
    public String simpleChat(String prompt) {
        return "";
    }
}