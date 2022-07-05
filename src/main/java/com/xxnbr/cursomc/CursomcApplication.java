package com.xxnbr.cursomc;

import com.xxnbr.cursomc.domain.*;
import com.xxnbr.cursomc.domain.enums.CustomerType;
import com.xxnbr.cursomc.domain.enums.PaymentStatus;
import com.xxnbr.cursomc.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

@EnableWebMvc
@SpringBootApplication
@RequiredArgsConstructor
public class CursomcApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	private final ProductRepository productRepository;

	private final StateRepository stateRepository;

	private final CityRepository cityRepository;

	private final CustomerRepository customerRepository;

	private final AddressRepository addressRepository;

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@SneakyThrows
	@Override
	public void run(String... args) {

		createProductsAndCategories();

		createStatesAndCitiesAndCustomersAndPurchaseOrder();

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

	private void createStatesAndCitiesAndCustomersAndPurchaseOrder() throws ParseException {
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

		Customer joao = Customer
				.builder()
				.name("João")
				.email("joao@gmail.com")
				.cpfCnpj("191.090.630-13")
				.phones(new HashSet<>(Arrays.asList("(11) 98765-4321", "(11) 96875-4321")))
				.typeCode(CustomerType.PHYSICAL.getCode())
				.build();

		Address santoAndreJoao = Address
				.builder()
				.city(santoAndre)
				.neighborhood("Vila Alto Santo Andre")
				.street("Rua dos eucaliptos")
				.number("576A")
				.postalCode("09240-465")
				.complement("-")
				.customer(joao)
				.build();

		Address campinasJoao = Address
				.builder()
				.city(campinas)
				.neighborhood("Batatinha")
				.street("Rua das flores")
				.number("51")
				.postalCode("09800-465")
				.complement("-")
				.customer(joao)
				.build();

		joao.getAddresses().addAll(Arrays.asList(santoAndreJoao,campinasJoao));

		customerRepository.saveAll(Arrays.asList(joao));
		addressRepository.saveAll(Arrays.asList(santoAndreJoao, campinasJoao));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


		PurchaseOrder order1 = PurchaseOrder
				.builder()
				.orderTime(dateFormat.parse("05/07/2022 16:02:58"))
				.customer(joao)
				.shippingAddress(joao.getAddresses().get(0))
				.build();

		PurchaseOrder order2 = PurchaseOrder
				.builder()
				.orderTime(dateFormat.parse("04/07/2022 06:22:08"))
				.customer(joao)
				.shippingAddress(joao.getAddresses().get(1))
				.build();

		Payment payment1 = CreditCardPayment
				.builder()
				.status(PaymentStatus.CONFIRMED.getCode())
				.purchaseOrder(order1)
				.installments(6)
				.build();

		order1.setPayment(payment1);

		Payment payment2 = InvoicePayment
				.builder()
				.status(PaymentStatus.PENDING.getCode())
				.purchaseOrder(order2)
				.dueDate(dateFormat.parse("15/07/2022 23:59:59"))
				.build();

		order2.setPayment(payment2);


		joao.getPurchaseOrderList().addAll(Arrays.asList(order1, order2));

		purchaseOrderRepository.saveAll(Arrays.asList(order1, order2));

		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
	}


}
