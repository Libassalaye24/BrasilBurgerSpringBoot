package com.brasil.burger.brasilburger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brasil.burger.brasilburger.fixtures.BurgerFixture;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class BrasilburgerApplication{
	
	
	public static void main(String[] args) {
		/* BurgerFixture.run(); */
		SpringApplication.run(BrasilburgerApplication.class, args);
		//SpringApplication.run(BurgerFixture.class, args);
		
	}

	/* @Autowired
	private BurgerFixture burgerFixture;


	@Override
	public void run(String... args) throws Exception {
		burgerFixture.run();
		
	} */
	

	
	
	
}
