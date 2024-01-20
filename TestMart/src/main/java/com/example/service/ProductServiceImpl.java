package com.example.service;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {
	
	List<String> chocolatesList = new ArrayList<>();
	List<String> laptopsList = new ArrayList<>();
	List<String> phonesList = new ArrayList<>();
	
	public ProductServiceImpl() {
		chocolatesList.add("Dark Chocolate");
		chocolatesList.add("M & M");
		chocolatesList.add("Ferrero Rocher");
		
		laptopsList.add("Lenovo");
		laptopsList.add("Apple");
		laptopsList.add("Dell");
		
		phonesList.add("Apple iPhone");
		phonesList.add("Samsung");
	}
	
	public List<String> getProductCategories() {

		List<String> categories = new ArrayList<>();
		
		categories.add("Chocolates");
		categories.add("Laptops");
		categories.add("Phones");
		
		return categories;
	}
	
	public List<String> getProducts(String category) {
		switch(category.toLowerCase()) {
		case "chocolates":
			return chocolatesList;
		case "laptops":
			return laptopsList;
		case "phones":
			return phonesList;
		}
		return null;
	}
}
