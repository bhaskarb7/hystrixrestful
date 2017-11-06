package poc.restclient;


//import org.springframework.web.client.RestTemplate;

public class ApacheHttpClient {


    public static void main(String args[]) {
        //RestTemplate restTemplate = new RestTemplate();
        //Shop shop = restTemplate.getForObject("http://localhost:8080/SpringMVC/rest/kfc/brands/kfc-kampar", Shop.class);
        //System.out.println(shop.toString());
    	System.out.println(""+new CommandSampleHystrix("World", true).execute());
    }

}

