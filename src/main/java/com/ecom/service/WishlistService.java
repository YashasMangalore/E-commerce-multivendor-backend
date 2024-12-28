package com.ecom.service;


import com.ecom.exception.WishlistNotFoundException;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.model.Wishlist;

public interface WishlistService {

    Wishlist createWishlist(User user);

    Wishlist getWishlistByUserId(User user);

    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}

