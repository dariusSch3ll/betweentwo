package application;

import java.util.ArrayList;

public class Step {
	private String name;
	private ArrayList<Product> products;

	public Step(String name) {

		this.name = name;
		products = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void add (Product product) {
		products.add(product);
	}

}
