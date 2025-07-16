package com.kubocode.ParkingClubEscritura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ParkingClubEscrituraApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(ParkingClubEscrituraApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingClubEscrituraApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

}
