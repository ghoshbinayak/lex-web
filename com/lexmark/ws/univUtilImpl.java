package com.lexmark.ws;

import java.util.Date;
import javax.jws.WebService;

/**
* The @WebService property endpointInterface links the 
* SIB (this class) to the SEI (ch01.ts.TimeServer). 
* Note that the method implementations are not annotated 
* as @WebMethods. 
*/

@WebService(endpointInterface = "com.lexmark.ws.univUtil") 
public class univUtilImpl implements univUtil { 
	public Student getStudentInfo() {
		Student s1 = new Student();
		s1.setFname("Binayak");
		s1.setLname("Ghosh");
		s1.setAge(12); // at heart :P
		return s1;
	}

	public void setStudentInfo(String fname, String lname, int age) {
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(age);
	}
}