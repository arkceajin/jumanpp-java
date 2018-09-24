package arc.jumanpp;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        TomcatURLStreamHandlerFactory.disable();
        SpringApplication.run(JumanController.class, args);
    }
}
