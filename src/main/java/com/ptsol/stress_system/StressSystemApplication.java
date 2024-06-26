package com.ptsol.stress_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.mybatis.spring.annotation.MapperScan;

@RestController
@SpringBootApplication
@MapperScan("com.ptsol.stress_system.mapper")
public class StressSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StressSystemApplication.class, args);
	}
}
