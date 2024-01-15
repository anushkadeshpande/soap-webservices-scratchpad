package com.example;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	
	public List<String> getProductCategories() {

		List<String> categories = new ArrayList<>();
		
		categories.add("Chocolates");
		categories.add("Laptops");
		categories.add("Phones");
		
		return categories;
	}
}
