package com.ecom.service;

import com.ecom.exception.ProductException;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.model.Product;
import com.ecom.model.User;

public interface CartService {
	
	public CartItem addCartItem(User user,
								Product product,
								String size,
								int quantity) throws ProductException;
	
	public Cart findUserCart(User user);

}
