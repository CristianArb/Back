package application.repository;

import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.QuadbikeCrudRepository;

/**
 * QuadbikeRepository
 * Esta clase es tipo repositorio, utiliza la interface QuadbikeCrudRepository 
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y 
 * hacer operaciones sobre la tabla quadbike
 *
 * @since 2021-10-27
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class QuadbikeRepository{
    
    /**
     * Instancia con @Autowired de la interface QuadbikeCrudRepository
     */
    @Autowired
    private QuadbikeCrudRepository quadbikeCrudRepository;
    
    /**
     * getAll()
     * Método que devuelve todas las cuatrimotos guardadas en la base de datos
     * @return Lista con todas las cuatrimotos
     */
    public List<Quadbike> getAll(){
    
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    
    }
    
    /**
     * getQuadbike(Integer id)
     * Método que busca y devuelve una cuatrimoto especifica por el id en la 
     * base de datos
     * @param id EL id de la cuatrimotos que se quiere buscar
     * @return Cuatrimoto con el id ingresado
     */
    public Optional<Quadbike> getQuadbike(Integer id){
    
        return quadbikeCrudRepository.findById(id);
    
    }
    
    /**
     * save(Quadbike quadbike)
     * Método que guarda una cuatrimoto en la base de datos y la devuelve
     * @param quadbike La cuatrimoto que se va a guardar
     * @return La cuatrimoto guardada
     */
    public Quadbike save(Quadbike quadbike){
    
        return quadbikeCrudRepository.save(quadbike);
    
    }
    
    /**
     * delete(Quadbike quadbike)
     * Método que elimina una cuatrimoto de la base de datos
     * @param quadbike La cuatrimoto que se va a eliminar
     */
    public void delete(Quadbike quadbike){
        
        quadbikeCrudRepository.delete(quadbike);
        
    }
    
}
