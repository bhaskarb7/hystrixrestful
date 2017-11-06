package poc.restclient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.client.RestTemplate;

//import org.springframework.web.client.RestTemplate;

public class ApacheHttpClient {


    public static  <T> void main(String args[]) {
        //RestTemplate restTemplate = new RestTemplate();
        //Shop shop = restTemplate.getForObject("http://localhost:8080/SpringMVC/rest/kfc/brands/kfc-kampar", Shop.class);
        //System.out.println(shop.toString());
    	System.out.println(""+new CommandSampleHystrix("World").execute());
    	//System.out.println(""+new CommandSampleHystrix("World",false).execute());
    	System.out.println(
    			new CommandSampleHystrix("World"){
    				@Override
    			    protected String run(){
    					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    					Calendar cal = Calendar.getInstance();
    				    System.out.println("start"+dateFormat.format(cal.getTime()));


    			          throw new RuntimeException("this command always fails");


    			    }
    			    
    				@Override
    			    protected String getFallback(){
    					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    					Calendar cal = Calendar.getInstance();
    				    System.out.println("end"+dateFormat.format(cal.getTime()));

    			        return  (" Failure Hello " + name + "!");
    			    	
    			    }

    				
    			}.execute()
    			
    			
    			);
    	

    }

}

