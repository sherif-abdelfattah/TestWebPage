import java.net.*;
import java.io.*;
import java.util.*;
 
public class TestWebPage {
 
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: TestWebPage <url> ");
            return;
        }
 
        String url = args[0];
 
        try {
	    Authenticator authenticator;
            Properties systemProperties = System.getProperties();
	    String proxyUser = systemProperties.getProperty("https.proxyUser");
	    String proxyPass = systemProperties.getProperty("https.proxyPassword");
	    URL urlObj = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

	    if (proxyUser != null && proxyPass != null)
	    {
	    	System.out.println("Proxy Settings:"+proxyUser+":"+proxyPass);
		String userPass = proxyUser+":"+proxyPass;
		authenticator = new Authenticator() {

        	public PasswordAuthentication getPasswordAuthentication() {
            		return (new PasswordAuthentication(proxyUser,
                    		proxyPass.toCharArray()));
        		}
    		};
    		Authenticator.setDefault(authenticator);
	    }    
            httpCon.setRequestProperty("Accept-Encoding","gzip, deflate");
            httpCon.setFollowRedirects(true);
	    httpCon.setRequestMethod("GET");
	    httpCon.setUseCaches(false);
	 
            int responseCode = httpCon.getResponseCode();
 
            
            System.out.println("Request Method:"+httpCon.getRequestMethod()+ " "+url);
            Map<String, List<String>> map = httpCon.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		System.out.println(entry.getKey() 
                           + " : " + entry.getValue());
	    }
	    System.out.println("Response:"+httpCon.getResponseMessage());
	    System.out.println("Is using proxy:" + httpCon.usingProxy());
	    System.out.println(httpCon.toString());

            System.out.println("Done Ok");
 
        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
        }
    }
}
