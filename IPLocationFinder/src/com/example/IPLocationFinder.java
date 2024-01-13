package com.example;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class IPLocationFinder {

	public static void main(String[] args) {
		// take ip address as arg
//		if(args.length != 1) 
//			System.out.println("Enter IP Address!!!!");
//		else {
//			String ipAddress = args[0];
			String ipAddress = "142.251.42.78";

			// get service endpoint interface from wsdl
			GeoIPService ipService = new GeoIPService();
			
			// stub
			GeoIPServiceSoap ipServiceSoap = ipService.getGeoIPServiceSoap();
			
			String ipLocation = ipServiceSoap.getIpLocation(ipAddress);
			
			System.out.println(ipLocation);
//		}
	}

}
