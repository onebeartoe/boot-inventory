package org.onebeartoe.boot.inventory;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Product {

	private @Id @GeneratedValue Long id;
	private String name;
	private String quantity;

	Product() {}

	Product(String name, String quantity) {

		this.name = name;
		this.quantity = quantity;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Product))
			return false;
		Product inventory = (Product) o;
		return Objects.equals(this.id, inventory.id) && Objects.equals(this.name, inventory.name)
				&& Objects.equals(this.quantity, inventory.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.quantity);
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", quantity='" + this.quantity + '\'' + '}';
	}
}
