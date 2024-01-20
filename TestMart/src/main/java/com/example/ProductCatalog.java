package com.example;

import java.util.List;

import javax.jws.WebService;

import com.example.service.ProductServiceImpl;

@WebService(endpointInterface = "com.example.ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl service = new ProductServiceImpl();
	
	@Override
	public List<String> getProductCategories() {
		return service.getProductCategories();
	}
	
//	@WebMethod(exclude=true)  -------- we can use the exclude property to not expose the method
	@Override
	public List<String> getProducts(String category) {
		return service.getProducts(category);
	}
	
}
