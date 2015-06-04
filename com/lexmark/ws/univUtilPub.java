package com.lexmark.ws; 
import javax.xml.ws.Endpoint; 

public class univUtilPub { 
	private static Endpoint endpoint;
	
	public static void main(String[ ] args) {
	 	Endpoint.publish("http://localhost:4567/un", new univUtilImpl());
	}

}