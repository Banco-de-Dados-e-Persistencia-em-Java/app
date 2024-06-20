package br.edu.infnet.elberthAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ElberthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElberthApiApplication.class, args);
	}

}
