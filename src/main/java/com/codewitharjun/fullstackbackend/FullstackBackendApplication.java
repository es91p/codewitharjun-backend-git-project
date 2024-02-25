package com.codewitharjun.fullstackbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackBackendApplication {

	public static void main(String[] args) {
		System.out.println("Entry into FullstackBackendApplication - main()");
		SpringApplication.run(FullstackBackendApplication.class, args);
		System.out.println("Exit from FullstackBackendApplication - main()");
	}

}
