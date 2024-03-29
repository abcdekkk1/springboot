package com.dns.springboot3.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
	 public static String encrytePassword(String password) {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder.encode(password);
	    }
	 
	    public static void main(String[] args) {
	        String password = "111";
	        String encrytedPassword = encrytePassword(password);
	 
	        System.out.println("Encryted Password: " + encrytedPassword);
	    }
}
