package application;

import static org.springframework.boot.SpringApplication.run;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan( basePackages= {"application.model"})
@SpringBootApplication
public class Reto3Application {

	public static void main(String[] args) {
            
		run(Reto3Application.class, args);
                
	}

}
