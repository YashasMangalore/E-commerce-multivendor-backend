package com.ecom.service;

import com.ecom.exception.SellerException;
import com.ecom.exception.UserException;
import com.ecom.request.LoginRequest;
import com.ecom.request.SignupRequest;
import com.ecom.response.AuthResponse;
import jakarta.mail.MessagingException;

public interface AuthService {

    void sentLoginOtp(String email) throws UserException, MessagingException;
    String createUser(SignupRequest req) throws SellerException;
    AuthResponse signin(LoginRequest req) throws SellerException;

}
