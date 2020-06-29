package org.onebeartoe.boot.inventory;

class ProductNotFoundException extends RuntimeException {

	ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}
}
