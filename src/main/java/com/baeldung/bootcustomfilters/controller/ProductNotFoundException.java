package com.baeldung.bootcustomfilters.controller;

class ProductNotFoundException extends RuntimeException {

	ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}
}
