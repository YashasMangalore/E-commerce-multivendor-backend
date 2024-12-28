package com.ecom.repository;

import com.ecom.model.Cart;
import com.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);


}
