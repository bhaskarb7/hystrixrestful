package poc.restclient;



import com.netflix.hystrix.*;

public class CommandSampleHystrix extends HystrixCommand<String> {

	   //final static Logger logger = LoggerFactory.getLogger(CommandSampleHystrix.class);
	   
    private final String name;

    public CommandSampleHystrix(String name) {
    	super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
    	        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
    	               .withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }

    @Override
    protected String run() {
        throw new RuntimeException("this command always fails");
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + name + "!";
    }
}
