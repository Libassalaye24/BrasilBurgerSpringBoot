package com.brasil.burger.brasilburger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brasil.burger.brasilburger.fixtures.FriteFixture;
import com.brasil.burger.brasilburger.fixtures.TailleFixture;
import com.brasil.burger.brasilburger.fixtures.UserFixture;

@SpringBootApplication
public class BrasilburgerApplication implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		/* BurgerFixture.run(); */
		SpringApplication.run(BrasilburgerApplication.class, args);
		//SpringApplication.run(BurgerFixture.class, args);
		
	}

	@Autowired
	private UserFixture userFixture;
	
	@Override
	public void run(String... args) throws Exception {
		//userFixture.loadDefaultAdmin();
	}
	

	
	
	
}
