package com.zabadaj.marcin.zabadaj.marcin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public static void main(){
		org.springframework.security.crypto.password.PasswordEncoder encoder
		   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		String passwd = encoder.encode("123456");

	      // passwd - password from database
	      System.out.println(passwd); // print hash
	}
}
