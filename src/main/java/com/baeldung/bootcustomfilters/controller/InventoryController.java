package com.baeldung.bootcustomfilters.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
class InventoryController {

	private final ProductRepository repository;

	InventoryController(ProductRepository repository) {
		this.repository = repository;
	}

	// Aggregate root


	@GetMapping("")
	List<Product> all() {
		return repository.findAll();
	}

	@PostMapping("/api/inventory")
	Product newProduct(@RequestBody Product newProduct) {
		return repository.save(newProduct);
	}

	// Single item
	@GetMapping("/api/inventory/{id}")
	Product one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new ProductNotFoundException(id));
	}

	@PutMapping("/api/inventory/{id}")
	Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(product -> {
				product.setName(newProduct.getName());
				product.setRole(newProduct.getRole());
				return repository.save(product);
			})
			.orElseGet(() -> {
				newProduct.setId(id);
				return repository.save(newProduct);
			});
	}

	@DeleteMapping("/api/inventory/{id}")
	void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
