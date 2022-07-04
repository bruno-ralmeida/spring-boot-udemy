package com.xxnbr.cursomc;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.domain.City;
import com.xxnbr.cursomc.domain.Product;
import com.xxnbr.cursomc.domain.State;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import com.xxnbr.cursomc.repositories.CityRepository;
import com.xxnbr.cursomc.repositories.ProductRepository;
import com.xxnbr.cursomc.repositories.StateRepository;
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

	private final StateRepository stateRepository;

	private final CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) {

		createProductsAndCategories();

		createStatesAndCities();

	}

	private void createProductsAndCategories() {
		Product mouse = Product
				.builder()
				.id(null)
				.name("Mouse")
				.price(BigDecimal.valueOf(69.90))
				.build();

		Product teclado = Product
				.builder()
				.id(null)
				.name("Teclado")
				.price(BigDecimal.valueOf(80.0))
				.build();

		Product impressora = Product
				.builder()
				.id(null)
				.name("Impressora")
				.price(BigDecimal.valueOf(600.00))
				.build();

		Category informatica = Category
				.builder()
				.id(null)
				.name("Informática")
				.products(Arrays.asList(mouse, teclado, impressora))
				.build();

		Category escritorio = Category
				.builder()
				.id(null)
				.name("Escritório")
				.products(Arrays.asList(mouse, teclado))
				.build();

		mouse.getCategories().addAll(Arrays.asList(informatica, escritorio));
		teclado.getCategories().addAll(Arrays.asList(informatica, escritorio));
		impressora.getCategories().addAll(Arrays.asList(informatica));

		categoryRepository.saveAll(Arrays.asList(informatica, escritorio));
		productRepository.saveAll(Arrays.asList(mouse, teclado, impressora));
	}

	private void createStatesAndCities() {
		State saoPaulo = State
				.builder()
				.name("São Paulo")
				.build();

		State minasGerais = State
				.builder()
				.name("Minas Gerais")
				.build();

		City santoAndre = City
				.builder()
				.name("Santo André")
				.state(saoPaulo)
				.build();

		City campinas = City
				.builder()
				.name("Campinas")
				.state(saoPaulo)
				.build();

		City uberlandia = City
				.builder()
				.name("Uberlândia")
				.state(minasGerais)
				.build();

		saoPaulo.getCities().addAll(Arrays.asList(santoAndre, campinas));
		minasGerais.getCities().addAll(Arrays.asList(uberlandia));

		stateRepository.saveAll(Arrays.asList(saoPaulo, minasGerais));
		cityRepository.saveAll(Arrays.asList(santoAndre, campinas, uberlandia));
	}
}
