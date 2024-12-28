package com.ecom.config;

import io.github.cdimascio.dotenv.Dotenv;

public class JwtConstant {

	private static final Dotenv dotenv =Dotenv.load();

	public static final String SECRET_KEY=dotenv.get("JWT_CONSTANTS_SECRET_KEY");
	public static final String JWT_HEADER=dotenv.get("JWT_CONSTANTS_JWT_HEADER");
	
}
