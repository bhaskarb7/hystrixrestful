package poc.restclient;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.client.RestTemplate;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.*;

public class CommandSampleHystrix extends HystrixCommand<String> {

   
    protected final String name;

    public CommandSampleHystrix(String name) {
    	/*super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
    	        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
    	               .withExecutionIsolationThreadTimeoutInMilliseconds(1000)));*/
    	 super(HystrixCommandGroupKey.Factory.asKey("restfulservice"));
         ConfigurationManager.getConfigInstance().setProperty(
                 "hystrix.command.restfulservice.execution.isolation.thread.timeoutInMilliseconds",
                 new Long(5000));
         
        this.name = name;

    }
    
    /*protected  String  onRun() {
		RestTemplate restTemplate = new RestTemplate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
	    System.out.println("start"+dateFormat.format(cal.getTime()));

    	  Shop shop = restTemplate
    	    .getForObject("http://localhost:8080/SpringMVC/rest/kfc/brands/kfc-benguluru", Shop.class);
    	  return ("shop:"+shop); 
	}
    
    protected  String getFallBackResult(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
	    System.out.println("end"+dateFormat.format(cal.getTime()));

        return  (" Failure Hello " + name + "!");
	
    }
*/
    @Override
    protected String run() {
    	//return onRun();
    	RestTemplate restTemplate = new RestTemplate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
	    System.out.println("start"+dateFormat.format(cal.getTime()));

    	  Shop shop = restTemplate
    	    .getForObject("http://localhost:8080/SpringMVC/rest/kfc/brands/kfc-benguluru", Shop.class);
    	  
      	DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  		Calendar cal1 = Calendar.getInstance();
  	    System.out.println("end"+dateFormat1.format(cal1.getTime()));

    	  return ("shop:"+shop); 

    }

    @Override
    protected String getFallback() {
       //return getFallback();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
	    System.out.println("end"+dateFormat.format(cal.getTime()));

        return  (" Failure Hello " + name + "!");

    }
}
