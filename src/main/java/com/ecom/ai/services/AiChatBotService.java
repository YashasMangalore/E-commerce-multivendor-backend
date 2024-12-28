package com.ecom.ai.services;

import com.ecom.exception.ProductException;
import com.ecom.response.ApiResponse;

public interface AiChatBotService {

    ApiResponse aiChatBot(String prompt,Long productId,Long userId) throws ProductException;
}
