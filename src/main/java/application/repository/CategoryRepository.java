package application.repository;

import application.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import application.repository.crud.CategoryCrudRepository;

/**
 * CategoryRepository
 * Esta clase es tipo repositorio, utiliza la interface CategoryCrudRepository 
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y 
 * hacer operaciones sobre la tabla category
 *
 * @since 2021-10-25
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class CategoryRepository {

    /**
     * Instancia con @Autowired de la interface CategoryCrudRepository.
     */
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    /**
     * getAll()
     * Método que devuelve todas las categorias guardadas en la base de datos
     * @return Lista con todas las categorias
     */
     public List<Category> getAll(){
        
        return (List<Category>) categoryCrudRepository.findAll();

    }

    /**
     * getCategory(int id)
     * Método que busca y devuelve una categoria especifica por el id en la base
     * de datos
     * @param id EL id de la categoria que se quiere buscar
     * @return Categoria con el id ingresado
     */


    public Optional<Category>getCategory(int id){
        
        return categoryCrudRepository.findById(id);

    }

    /**
     * save(Category category)
     * Método que guarda una categoria en la base de datos y la devuelve
     * @param category La categoria que se va a guardar
     * @return La categoria guardada
     */
    public Category save(Category category) {

        return categoryCrudRepository.save(category);

    }

    

    /**
     * delete(Category category)
     * Método que elimina una categoria de la base de datos
     * @param category La categoria que se va a eliminar
     */
    public void delete(Category category) {

        categoryCrudRepository.delete(category);

    }
}
