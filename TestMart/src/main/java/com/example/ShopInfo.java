package com.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
// To change the binding style Document (Default) || RPC
@SOAPBinding(style=Style.RPC)
public class ShopInfo {
	
	// @WebParam -- used to change the name of inputVariable in wsdl
	
	@WebMethod
	@WebResult(partName="lookupOutput")	// to change the name of output variable in wsdl
	public String getShopInfo(@WebParam(partName="lookupInput") String property) {
		String response = "Error!!!!!";
		
		if("shopName".equals(property)) {
			response = "Test Mart";
		} else if("category".equals(property)) {
			response = "Chocolates";
		}
		
		return response;
	}
}
