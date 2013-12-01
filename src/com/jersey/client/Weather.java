package com.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.log4j.Logger;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/24/13
 * Time: 12:50 AM
 */
public class Weather {
   Client wheatherClient = null;
    String uri="http://api.worldweatheronline.com/free/v1/weather.ashx";
    MultivaluedMap queryParams = null;
    WebResource resource = null;
   Logger logger = Logger.getLogger(Weather.class);

   public Weather(){
     wheatherClient = Client.create();
   }

   public void getWeatherData(String city, String format, String num_of_days){
     queryParams = new MultivaluedMapImpl() {};
       queryParams.add("q",city);
       queryParams.add("format",format);
       queryParams.add("num_of_days",num_of_days);
       queryParams.add("key","tmw67exren6t2mxxmsvgsvye");
       resource = wheatherClient.resource(uri);
       String s =  resource.queryParams(queryParams).get(String.class);
       logger.debug(s);
   }
}