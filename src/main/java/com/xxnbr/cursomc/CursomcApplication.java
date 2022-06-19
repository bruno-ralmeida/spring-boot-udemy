package com.xxnbr.cursomc;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@EnableWebMvc
@SpringBootApplication
@RequiredArgsConstructor
public class CursomcApplication implements CommandLineRunner {

	private final CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category informatica = Category
				.builder()
				.name("Informática")
				.build();
		Category escritorio = Category
				.builder()
				.name("Escritório")
				.build();

		repository.saveAll(Arrays.asList(informatica, escritorio));


	}
}
