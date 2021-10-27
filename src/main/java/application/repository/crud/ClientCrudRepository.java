package application.repository.crud;

import application.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * ClientCrudRepository
 * Esta Interface se extiende de la interface CrudRepository quien contiene las
 * operaciones basicas CRUD sobre la base de datos, para poder actuar sobre la
 * tabla client que tiene una llave primaria Integer
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
    
}
