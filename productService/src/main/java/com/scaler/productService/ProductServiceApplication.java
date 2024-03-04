package com.scaler.productService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaler.productService.exceptions.joinnedTable.MentorRepository;
import com.scaler.productService.exceptions.joinnedTable.StudentRepository;

import com.scaler.productService.exceptions.joinnedTable.Mentor;
import com.scaler.productService.exceptions.joinnedTable.Student;

import com.scaler.productService.models.Product;
import com.scaler.productService.repositories.CategoryRepository;
import com.scaler.productService.repositories.PriceRepository;
import com.scaler.productService.repositories.ProductRepository;
import com.scaler.productService.models.Category;
import com.scaler.productService.models.Price;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner{
	
	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;
	
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	private PriceRepository priceRepository;
	
	
	public ProductServiceApplication(MentorRepository mentorRepository, StudentRepository studentRepository, CategoryRepository categoryRepository, ProductRepository productRepository, PriceRepository priceRepository) {
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * User user = new User(); user.setId(1L); user.setEmail("Kishan@email.com");
		 * user.setName("Kishan");
		 * 
		 * userRepository.save(user);
		 * 
		 * Student student = new Student(); student.setId(2L); student.setName("Meera");
		 * student.setEmail("meera@email.com"); student.setBatch("Batch 1");
		 * student.setPsp(99.0);
		 * 
		 * studentRepository.save(student);
		 */
		
		/*
		 * List<User> users = userRepository.findAll(); users.forEach(user2 ->
		 * System.out.println(user2.getName()));
		 */
		/*
		 * Mentor mentor = new Mentor(); mentor.setName("Anshu");
		 * mentor.setEmail("anshu@email.com"); mentor.setAvgRating(100.0);
		 * mentorRepository.save(mentor);
		 */
		
		/*
		 * Student student = new Student(); student.setName("Devesh");
		 * student.setEmail("devesh@email.com"); student.setBatch("Batch1");
		 * student.setPsp(99.0);
		 * 
		 * studentRepository.save(student);
		 */
		
		
		
		/*
		 * Category category = new Category(); category.setName("Home Appliances");
		 * 
		 * Category savedCategory = categoryRepository.save(category);
		 * 
		 * Price price = new Price(); price.setCurrency("Rupee"); price.setPrice(100);
		 * 
		 * //Price savedPrice = priceRepository.save(price);
		 * 
		 * Product product = new Product(); product.setTitle("Mixer Grinder");
		 * product.setImage("ImageUrlGrinder");
		 * product.setDescription("Bajaj Mixer Grinder");
		 * product.setCategory(savedCategory); product.setPrice(price);
		 * 
		 * productRepository.save(product);
		 */
		 
		Product product1 = productRepository.findByTitleAndPrice_currency("iPhone14", "Rupee");
		System.out.println(product1);
		
		Product product2 = productRepository.findProductByTitle("iPhone14");
		System.out.println(product2);
		 
	//	productRepository.deleteById(UUID.fromString("7c8d6e86-0f6a-4b9d-92cb-c20f13a64c50"));
		
		//Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString("ae2dd9dc-2c1e-4a55-bdd2-c923dbd24922"));
		
		/*
		 * if(!categoryOptional.isEmpty()) { Category category = categoryOptional.get();
		 * System.out.println(category.getProducts()); }
		 */
		
	}

}
