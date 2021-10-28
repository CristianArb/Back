package application;

import static org.springframework.boot.SpringApplication.run;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Reto3Application
 * Esta clase contiene a la funcion main del para el reto 3
 * Este proyecto utiliza al framework springboot y a maven como herramienta
 * para desplegar springboot
 * Utiliza una base de datos H2 y springboot JPA para manipular la base de datos
 * Este proyecto implementa la arquitectura MVC
 *
 * @since 2021-10-28
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@EntityScan( basePackages= {"application.model"})
@SpringBootApplication
public class Reto3Application {

	public static void main(String[] args) {
            
		run(Reto3Application.class, args);
                
	}

}
