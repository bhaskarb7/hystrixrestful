package poc.restclient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.client.RestTemplate;

//import org.springframework.web.client.RestTemplate;

public class ApacheHttpClient {


    public static void main(String args[]) {
        //RestTemplate restTemplate = new RestTemplate();
        //Shop shop = restTemplate.getForObject("http://localhost:8080/SpringMVC/rest/kfc/brands/kfc-kampar", Shop.class);
        //System.out.println(shop.toString());
    	System.out.println(""+new CommandSampleHystrix("World").execute());
    	System.out.println(""+new CommandSampleHystrix("World").execute());
    	System.out.println(
    			new CommandSampleHystrix("World"){
    				@Override
    			    protected String run(){
    					
    					RestTemplate restTemplate = new RestTemplate();
    					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    					Calendar cal = Calendar.getInstance();
    				    System.out.println("start"+dateFormat.format(cal.getTime()));

    			    	  Shop shop = restTemplate
    			    	    .getForObject("http://localhost:8083/SpringMVC/rest/kfc/brands/kfc-benguluru", Shop.class);
    			    	  
    			      	DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    			  		Calendar cal1 = Calendar.getInstance();
    			  	    System.out.println("end"+dateFormat1.format(cal1.getTime()));

    			    	  return ("shop:"+shop); 

    			    	  
    					/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    					Calendar cal = Calendar.getInstance();
    				    System.out.println("start"+dateFormat.format(cal.getTime()));
*/

    			          //throw new RuntimeException("this command always fails");


    			    }
    			    
    				    				
    			}.execute()
    			
    			
    			);
    	

    }

}

