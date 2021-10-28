package application.service;

import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repository.QuadbikeRepository;


/**
 * CategoryService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla quadbike en la base de datos usando el
 * repositorio QuadbikeRepository
 * 
 * @since 2021-10-27
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class QuadbikeService {
    
    /**
     * Instancia con @Autowired de la clase repositorio CategoryRepository.
     */
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    /**
     * getAll()
     * Método que devuelve todas las cuatrimotos guardadas en la base de datos
     * @return Lista con todas las cuatrimotos
     */
    public List<Quadbike> getAll(){
    
        return  quadbikeRepository.getAll();
    
    }
    
    /**
     * getQuadbike(Integer id)
     * Método que busca y devuelve una cuatrimoto especifica por el id en la 
     * base de datos
     * @param id EL id de la cuatrimotos que se quiere buscar
     * @return Cuatrimoto con el id ingresado
     */
    public Optional<Quadbike> getQuadbike(Integer id){
    
        return quadbikeRepository.getQuadbike(id);
    
    }
    
    /**
     * save(Quadbike quadbike)
     * Método que guarda una cuatrimoto, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve la cuatrimoto guardada, sino solo devuelve la
     * cuatrimoto ingresada
     * @param quadbike Cuatrimoto que se va a guardar
     * @return La cuatrimoto ingresada
     */
    public Quadbike save(Quadbike quadbike){
    
        if(quadbike.getId()==null){
            
            return quadbikeRepository.save(quadbike);
            
        }
        
        else{
        
            Optional<Quadbike> quadbikeAux= quadbikeRepository.getQuadbike(
                    quadbike.getId()
            );
            
            if(quadbikeAux.isEmpty()){
                
                return quadbikeRepository.save(quadbike);
                
            }
            
            else{
            
            return quadbike;
                
            }   
        }
    } 
    
    /**
     * update(Quadbike quadbike)
     * Método que actualiza una cuatrimoto, verifica que la cuatrimoto tenga id
     * y que exista en la base de datos, en caso de que tenga campos nulos no se
     * guardaran. Si pasa las validaciones devuelve la cuatrimoto actualizada,
     * sino solo devuelve la cuatrimoto ingresada
     * @param quadbike Cuatrimoto que se va a actualizar
     * @return La cuatrimoto ingresada
     */
    public Quadbike update(Quadbike quadbike){
        
        if(quadbike.getId()!=null){
            
            Optional<Quadbike> e=quadbikeRepository.getQuadbike(quadbike.getId());
            
            if(!e.isEmpty()){
                
                if(quadbike.getName()!=null){
                    
                    e.get().setName(quadbike.getName());
                   
                }
                
                if(quadbike.getBrand()!=null){
                    
                    e.get().setBrand(quadbike.getBrand());
                    
                }
                
                if(quadbike.getYear()!=null){
                    
                    e.get().setYear(quadbike.getYear());
                    
                }
                
                if(quadbike.getDescription()!=null){
                    
                    e.get().setDescription(quadbike.getDescription());
                    
                }
                
                /*if(quadbike.getCategory()!=null){
                    
                    e.get().setCategory(quadbike.getCategory());
                    
                }*/
                
                quadbikeRepository.save(e.get());
                
                return e.get();
                
            }
            
            else{
                
                return quadbike;
                
            }
            
        }
        
        else{
            
            return quadbike;
            
        }
    }

    /**
     * deleteQuadbike(int idQuadbike)
     * Método que borra una cuatrimoto por el id, usando una función map para
     * verificar si la cuatrimoto con el id existe en la base de datos. Devuelve
     * un booleano dependiendo del exito de la operaión
     * @param idQuadbike El id de la cuatrimoto a borrar
     * @return Un true o false dependiendo de si se borro la cuatrimoto
     */
    public boolean deleteQuadbike(int idQuadbike) {
        
        var aBoolean = getQuadbike(idQuadbike).map(bike -> {            
            quadbikeRepository.delete(bike);     
            return true;            
        }).orElse(false);
        
        return aBoolean;
    }
}
