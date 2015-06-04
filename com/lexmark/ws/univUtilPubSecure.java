package com.lexmark.ws; 
import javax.xml.ws.Endpoint; 

import java.net.InetSocketAddress;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import javax.xml.ws.http.HTTPException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsParameters;


public class univUtilPubSecure { 
	private static Endpoint endpoint;
	
	public static void main(String[ ] args) {
	 	String ip = "https://localhost:";
		int port = 4567;
		String path = "/un";
		String url_endpoint = ip + port + path;

		HttpsServer server = get_https_server(ip, port, path);
		HttpContext http_ctx = server.createContext(path);

		if (server != null) {
			System.out.println("Publishing at " + url_endpoint);
			server.start();
		}
		else {
			System.err.println("Failed to start server. Exiting.");
		}

	 	endpoint = Endpoint.create(new univUtilImpl());
	 	endpoint.publish(http_ctx);
	}

	private static HttpsServer get_https_server(String ip, int port, String path){
		HttpsServer server = null;
		try {
			InetSocketAddress inet = new InetSocketAddress(ip, port);
			server = HttpsServer.create(inet, 5);

			SSLContext ssl_ctx = SSLContext.getInstance("TLS");
			char[] password = "changeit".toCharArray();
			KeyStore ks = KeyStore.getInstance("JKS");
			FileInputStream fis = new FileInputStream("rc.keystore");
			ks.load(fis, password);

			password = "helloworld".toCharArray();
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(ks, password);
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(ks);
			ssl_ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

			final SSLEngine eng = ssl_ctx.createSSLEngine();
			server.setHttpsConfigurator(new HttpsConfigurator(ssl_ctx){
				public void configure(HttpsParameters parms){
					parms.setCipherSuites(eng.getEnabledCipherSuites());
					parms.setProtocols(eng.getEnabledProtocols());
				}
			});

			server.setExecutor(null); // use default
		}
		catch(Exception e){
			System.err.println(e);
		}
		return server;
	}
}