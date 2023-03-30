package application.betweentwo;

import java.util.ArrayList;
import java.util.List;

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

	public ArrayList<Product> getProducts1() {
		return products;
	}
	
	public void add (Product product) {
		products.add(product);
	}

	
	   public void removeProduct(Product product) {
	        products.remove(product);
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	  
  
}
	
	
	
	
	
