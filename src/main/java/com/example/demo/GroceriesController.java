package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class GroceriesController {
	
	
	@GetMapping("/")
	public String categories(Model model) {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
		Mono<Category[]> result = webClient.get().uri("/categories").retrieve().bodyToMono(Category[].class);
		model.addAttribute("Categories", result.block());
		return ("categories");
	}
	
	@GetMapping("groceries/{id}")
	public String category(@PathVariable Long id, Model model) {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
		Mono<Grocery[]> result = webClient.get().uri("/categories/" + id + "/groceries").retrieve().bodyToMono(Grocery[].class);
		model.addAttribute("Groceries", result.block());
		return ("groceries");
	}
}
