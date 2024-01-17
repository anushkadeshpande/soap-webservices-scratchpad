package com.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ShopInfo {
	
	@WebMethod
	public String getShopInfo(String property) {
		String response = "Error!!!!!";
		
		if("shopName".equals(property)) {
			response = "Test Mart";
		} else if("category".equals(property)) {
			response = "Chocolates";
		}
		
		return response;
	}
}
