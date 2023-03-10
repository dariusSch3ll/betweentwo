package application;

import java.util.ArrayList;

public class Model {

	private ArrayList<Step> steps;

	public Model() {
		steps = new ArrayList<>();
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void generateData() {
		Product s = new Product("Sesam", 2.20);
		Product v = new Product("Vollkorn", 2.00);
		Product w = new Product("Weissbrot", 1.90);

		Product f1 = new Product("Hähnchen", 3.00);
		Product f2 = new Product("Tunfisch", 2.00);
		Product f3 = new Product("Fajita", 3.50);
		Product f4 = new Product("Cheddar", 2.00);
		Product f5 = new Product("Mozarella", 1.30);
		Product f6 = new Product("Schmelzkäse", 1.00);

		Product f7  = new Product("Salat", 1.00);
		Product f8  = new Product("Tomaten", 1.00);
		Product f9  = new Product("Gewürzgurken", 1.00);
		Product f10 = new Product("Paprika", 1.00);
		Product f11 = new Product("Rote Zwiebeln ", 1.00);
		Product f12 = new Product("Jalapenos", 1.00);
		Product f13 = new Product("Majo light", 0.50);
		Product f14 = new Product("Senf ", 0.50);
		Product f15 = new Product("Ketchup", 0.50);
		Product f16 = new Product("Knoblauch Soße", 0.50);
		Product f17 = new Product("Sweet Onion  ", 0.50);

		Product f18 = new Product("Cookie ", 3.00);
		Product f19 = new Product("Cola", 2.50);
		Product f20 = new Product("Cola Zero", 2.50);
		Product f21 = new Product("Fanta ", 2.00);
		Product f22 = new Product("Sprite", 2.00);
		Product f23 = new Product("Kafee", 1.50);

		Step s1 = new Step("Brot");
		s1.add(s);
		s1.add(v);
		s1.add(w);

		Step s2 = new Step("Fleisch + Käse");
		s2.add(f1);
		s2.add(f2);
		s2.add(f3);
		s2.add(f4);
		s2.add(f5);
		s2.add(f6);

		Step s3 = new Step("Belag + Soße");
		s3.add(f7);
		s3.add(f8);
		s3.add(f9);
		s3.add(f10);
		s3.add(f11);
		s3.add(f12);
		s3.add(f13);
		s3.add(f14);
		s3.add(f15);
		s3.add(f16);
		s3.add(f17);

		Step s4 = new Step("Optionale Beilagen");
		s4.add(f18);
		s4.add(f19);
		s4.add(f20);
		s4.add(f21);
		s4.add(f22);
		s4.add(f23);

		steps.add(s1);
		steps.add(s2);
		steps.add(s3);
		steps.add(s4);
	}

	public Step getStepByNum(int num) {
		return steps.get(num);

	}
	
	public int getStepCount() {
		return steps.size();
	}
	
	
	

}
