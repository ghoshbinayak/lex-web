package com.lexmark.ws;

import stub.Student;
import stub.UnivUtil;
import stub.UnivUtilImplService;


class univUtilClient {
	public static void main(String args[ ]) throws Exception {
		// URL url = new URL("http://localhost:5000/un?wsdl");
		
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL 
		// QName qname = new QName("http://ws.lexmark.com/", "univUtilImplService");

		// Create, in effect, a factory for the service. 
		UnivUtilImplService service = new UnivUtilImplService(); 

		// Extract the endpoint interface, the service "port".
		UnivUtil eif = service.getUnivUtilImplPort();
		System.out.println(eif.getStudentInfo().getFname());
		eif.setStudentInfo("Debasmita", "Ghosh", 12);
	}
}