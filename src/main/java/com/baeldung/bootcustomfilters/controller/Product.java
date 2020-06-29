package com.baeldung.bootcustomfilters.controller;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Product {

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;

	Product() {}

	Product(String name, String role) {

		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getRole() {
		return this.role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Product))
			return false;
		Product inventory = (Product) o;
		return Objects.equals(this.id, inventory.id) && Objects.equals(this.name, inventory.name)
				&& Objects.equals(this.role, inventory.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.role);
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
	}
}
