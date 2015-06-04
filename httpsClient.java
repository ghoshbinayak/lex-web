import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;

class httpsClient {
	private static final String url_s = " https://binghoshwin7:4000/fincrp/soap/wsdl/CreatePayablesInvoice?wsdl";
	
	public static void main(String[] args){
		new httpsClient().get();
	}
	
	private void get(){
		try {
			// Configure HttpsURLConnection so that it doesn't check certificates.
			// SSLContext ssl_ctx = SSLContext.getInstance("SSL");
			// TrustManager[] trust_mgr = get_trust_mgr();
			// ssl_ctx.init(
			// 		null, 		// key manager
			// 		trust_mgr,	// trust manager
			// 		new SecureRandom()	// random number generator
			// 	);

			// HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
			// HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
		 //        public boolean verify(String hostname, SSLSession sslSession) {
		 //            if (hostname.equals("localhost")) {
		 //                return true;
		 //            }
		 //            return false;
		 //        }
		 //    });
			URL url = new URL(url_s);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			dump_features(conn);
		}
		catch(MalformedURLException e){ System.out.println(e); }
		catch(IOException e){ 
			System.out.println(e);
		}
		catch(Exception e){
			System.err.println(e);
		}
	}

	private void dump_features(HttpsURLConnection conn){
		BufferedReader br = null;
		try {
			print("Status code: " + conn.getResponseCode());
			print("Cipher suite: " + conn.getCipherSuite());
			Certificate[] certs = conn.getServerCertificates();
			for (Certificate cert : certs){
				print("\tCert. type: " + cert.getType());
				print("\tHash code: " + cert.hashCode());
				print("\tAlgorithm: " + cert.getPublicKey().getAlgorithm());
				print("\tFormat: " + cert.getPublicKey().getFormat());
			}

			InputStream response = conn.getInputStream();
			StringBuilder sb = new StringBuilder();
			String line;
			br = new BufferedReader(new InputStreamReader(response));
			while((line = br.readLine()) != null){
				sb.append(line);
			}
			print("Response Message: " + sb.toString());
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch(Exception e){	
			System.out.println(e);
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	private void print(String s){
		System.out.println(s);
	}

	private TrustManager[] get_trust_mgr() {
		TrustManager[] certs = new TrustManager[] {	new X509TrustManager(){
				public X509Certificate[] getAcceptedIssuers(){ return null; }
				public void checkClientTrusted(X509Certificate[] c, String t) { }
				public void checkServerTrusted(X509Certificate[] c, String t) { }
			}
		};
		return certs;
	}
}

