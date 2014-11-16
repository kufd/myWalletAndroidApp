package com.app;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.auth.AuthScope;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.auth.Credentials;
import org.apache.http.client.ClientProtocolException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.InputStream;
import org.apache.http.util.EntityUtils;
import android.util.Base64;



public class Spendings 
{
	private String apiDomain = "http://my-wallet.com.ua/v1/";
	private String username = "kufd";
	private String password = "paralelepiped";
	
	public String getSpendings(String dateBegin, String dateEnd) 
	{
		String result = "ok";
		String url = apiDomain + "spendings/?dateBegin="+dateBegin+"&dateEnd="+dateEnd;
		
		InputStream inputStream = null;

        try 
        {
 
            // create HttpClient
        	DefaultHttpClient httpclient = new DefaultHttpClient();
             
            HttpGet get = new HttpGet(url);
            
            String credentials = username + ":" + password;  
            String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);  
            get.addHeader("Authorization", "Basic " + base64EncodedCredentials);
                        
            HttpResponse httpResponse = httpclient.execute(get);
   
            result = EntityUtils.toString(httpResponse.getEntity());
            
        } 
        catch (Exception e) 
        {
        	result = "ERROR: " + e.toString();
        }
 
        return result;

        
	}

}

