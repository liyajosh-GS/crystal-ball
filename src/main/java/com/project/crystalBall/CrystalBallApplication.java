package com.project.crystalBall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.project.*")
public class CrystalBallApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrystalBallApplication.class, args);
	}

}
