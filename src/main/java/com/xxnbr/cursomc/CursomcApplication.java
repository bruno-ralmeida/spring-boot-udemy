package com.xxnbr.cursomc;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.domain.Product;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import com.xxnbr.cursomc.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;
import java.util.Arrays;

@EnableWebMvc
@SpringBootApplication
@RequiredArgsConstructor
public class CursomcApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product mouse = Product
				.builder()
				.id(null)
				.name("Mouse")
				.price(new BigDecimal(69.90))
				.build();

		Product teclado = Product
				.builder()
				.id(null)
				.name("Teclado")
				.price(new BigDecimal(80.0))
				.build();

		Product impressora = Product
				.builder()
				.id(null)
				.name("Impressora")
				.price(new BigDecimal(600.00))
				.build();


		Category informatica = Category
				.builder()
				.id(null)
				.name("Informática")
				.products(Arrays.asList(mouse,teclado,impressora))
				.build();

		Category escritorio = Category
				.builder()
				.id(null)
				.name("Escritório")
				.products(Arrays.asList(mouse,teclado))
				.build();


		mouse.getCategories().addAll(Arrays.asList(informatica,escritorio));
		teclado.getCategories().addAll(Arrays.asList(informatica,escritorio));
		impressora.getCategories().addAll(Arrays.asList(informatica));


		categoryRepository.saveAll(Arrays.asList(informatica, escritorio));
		productRepository.saveAll(Arrays.asList(mouse, teclado, impressora));
	}
}
