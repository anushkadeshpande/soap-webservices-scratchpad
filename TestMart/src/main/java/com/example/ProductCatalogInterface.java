package com.example;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="TestMartCatalog", portName="TestMartCatalogPort", serviceName="TestCatalogService")
public interface ProductCatalogInterface {

	@WebMethod
	List<String> getProductCategories();

	//	@WebMethod(exclude=true)  -------- we can use the exclude property to not expose the method
	@WebMethod
	List<String> getProducts(String category);

}