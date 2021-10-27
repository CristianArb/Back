package application.repository.crud;

import application.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * CategoryCrudRepository
 * Esta Interface se extiende de la interface CrudRepository quien contiene las
 * operaciones basicas CRUD sobre la base de datos, para poder actuar sobre la
 * tabla category que tiene una llave primaria Integer
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
