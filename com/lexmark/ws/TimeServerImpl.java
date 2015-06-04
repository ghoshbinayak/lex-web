package com.lexmark.ws;

import java.util.Date;
import javax.jws.WebService;

/**
* The @WebService property endpointInterface links the 
* SIB (this class) to the SEI (ch01.ts.TimeServer). 
* Note that the method implementations are not annotated 
* as @WebMethods. 
*/

@WebService(endpointInterface = "com.lexmark.ws.TimeServer") 
public class TimeServerImpl implements TimeServer { 
	public String getTimeAsString(String msg) { 
		return new Date().toString(); 
	} 
	public long getTimeAsElapsed() {
		return new Date().getTime(); 
	} 
}