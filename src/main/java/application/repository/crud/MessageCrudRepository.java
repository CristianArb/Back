
package application.repository.crud;

import application.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    
}
