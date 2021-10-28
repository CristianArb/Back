package application.web;

import application.model.Category;
import application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * CategoryController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla categoria y provee al CategoryService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class CategoryController {

    /**
     * Instancia con @Autowired de la clase servicio CategoryService
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * getCategorys()
     * Método que devuelve todas las categorias guardadas en la base de datos a
     * traves de una petición GET
     * @return Lista con todas las categorias
     */
    @GetMapping("/all")
    public List<Category> getCategorys(){
        
        return categoryService.getAll();
        
    }
    
    /**
     * getCategory(@PathVariable("id") int id)
     * Método que busca y devuelve una categoria especifica por el id en la base
     * de datos a traves de una petición GET. Este id va en la ruta de la url
     * @param id EL id de la categoria que se quiere buscar
     * @return Categoria con el id ingresado
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        
        return categoryService.getCategory(id);
        
    }

    /**
     * save(@RequestBody Category category)
     * Método que guarda y devuelve una categoria en la base de datos a traves
     * de una petición POST
     * @param category La categoria que se va a guardar en formato JSON
     * @return La categoria guardada
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Category save(@RequestBody Category category){
        
        return categoryService.save(category);
        
    }
    
    /**
     * update(@RequestBody Category category)
     * Método que actualiza y devuelve una categoria en la base de datos a
     * traves de una petición PUT
     * @param category La categoria que se va a actualizar en formato JSON
     * @return La categoria actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Category update(@RequestBody Category category) {
        
        return categoryService.update(category);
        
    }

    /**
     * delete(@PathVariable("id") int idCategory)
     * Método que borra una categoria por el id y devuelve un valor booleano
     * dependiendo de si se borro con exito. El id va incluido en la ruta
     * de la url
     * @param idCategory El id de la categoria a borrar que va en la url
     * @return True o false dependiendo de si se borro la categoria
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idCategory) {
        
        return categoryService.deleteCategory( idCategory);
        
    }
}
