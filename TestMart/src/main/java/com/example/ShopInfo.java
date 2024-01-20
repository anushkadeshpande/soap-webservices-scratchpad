package com.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
// To change the binding style Document (Default) || RPC
@SOAPBinding(style=Style.RPC)
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
