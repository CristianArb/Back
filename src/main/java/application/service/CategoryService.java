package application.service;

import application.model.Category;
import application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * CategoryService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla category en la base de datos usando el
 * repositorio CategoryRepository
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class CategoryService {
    
    /**
     * Instancia con @Autowired de la clase repositorio CategoryRepository
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * getAll()
     * Método que devuelve todas las categorias guardadas en la base de datos
     * @return Lista con todas las categorias
     */
    public List<Category> getAll(){
        
        return  categoryRepository.getAll();
        
    }
    
    /**
     * getCategory(int id)
     * Método que busca y devuelve una categoria especifica por el id en la base
     * de datos
     * @param id EL id de la categoria que se quiere buscar
     * @return Categoria con el id ingresado
     */
    public Optional<Category> getCategory(int id){
        
        return categoryRepository.getCategory(id);
        
    }

    /**
     * save(Category category)
     * Método que guarda una categoria, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve la categoria guardada, sino solo devuelve la
     * categoria ingresada
     * @param category Categora que se va a guardar
     * @return La categoria ingresada
     */
    public Category save(Category category){
        
        if(category.getId()==null){
            
            return categoryRepository.save(category);
            
        }
        
        else{
            
            var paux=categoryRepository.getCategory(category.getId());
            
            if(paux.isEmpty()){
                
                return categoryRepository.save(category);
                
            }
            else{
                
                return category;
                
            }
        }
    }
    
    /**
     * update(Category category)
     * Método que actualiza una categoria, verifica que la categoria tenga id y
     * que exista en la base de datos, en caso de que tenga campos nulos no se
     * guardaran. Si pasa las validaciones devuelve la categoria actualizada,
     * sino solo devuelve la categoria ingresada
     * @param category Categoria que se va a actualizar
     * @return La categoria ingresada
     */
    public Category update(Category category){
        
        if(category.getId()!=null){
            
            var g=categoryRepository.getCategory(category.getId());
            
            if(!g.isEmpty()){
                
                if(category.getDescription()!=null){
                    
                    g.get().setDescription(category.getDescription());
                    
                }
                
                if(category.getName()!=null){
                    
                    g.get().setName(category.getName());
                    
                }
                
                return categoryRepository.save(g.get());
                
            }
        }
        return category;
    }
    
    /**
     * deleteCategory(int categoriaId)
     * Método que borra una categoria por el id, usando una función map para
     * verificar si la categoria con el id existe en la base de datos. Devuelve
     * un booleano dependiendo del exito de la operaión
     * @param categoriaId El id de la categoria a borrar
     * @return Un true o false dependiendo de si se borro la categoria
     */
    public boolean deleteCategory(int categoriaId){
        
        var d=getCategory(categoriaId).map(categoria -> {
            
            categoryRepository.delete(categoria);
            
            return true;
        }).orElse(false);
        return d;
    }
}
