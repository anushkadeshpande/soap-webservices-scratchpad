package com.example;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.service.ProductServiceImpl;

@WebService
public class ProductCatalog {
	
	ProductServiceImpl service = new ProductServiceImpl();
	
	@WebMethod
	public List<String> getProductCategories() {
		return service.getProductCategories();
	}
	
//	@WebMethod(exclude=true)  -------- we can use the exclude property to not expose the method
	@WebMethod
	public List<String> getProducts(String category) {
		return service.getProducts(category);
	}
	
}
