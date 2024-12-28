package com.ecom.response;

import com.ecom.dto.OrderHistory;
import com.ecom.model.Cart;
import com.ecom.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}
