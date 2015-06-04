package com.lexmark.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class TimeClient {
	public static void main(String args[ ]) throws Exception {
		URL url = new URL("http://localhost:5000/un?wsdl");
		
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL 
		QName qname = new QName("http://ws.lexmark.com/", "univUtilImplService");

		// Create, in effect, a factory for the service. 
		Service service = Service.create(url, qname); 

		// Extract the endpoint interface, the service "port".
		univUtil eif = service.getPort(univUtil.class);
		System.out.println(eif.getStudentInfo().getFname());
		eif.setStudentInfo("Debasmita", "Ghosh", 12);
	}
}