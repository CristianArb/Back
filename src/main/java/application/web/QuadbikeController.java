package application.web;

import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import application.service.QuadbikeService;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * QuadbikeController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla cuatrimoto y provee al QuadbikeService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-27
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= { GET, POST, PUT, DELETE}, allowedHeaders = "*")
@RestController
public class QuadbikeController {
    
    /**
     * Instancia con @Autowired de la clase servicio QuadbikeService
     */
    @Autowired
    private QuadbikeService quadbikeService;
    
    /**
     * getAll()
     * Método que devuelve todas las categorias guardadas en la base de datos a
     * traves de una petición GET
     * @return Lista con todas las categorias
     */
    @GetMapping("/all")
    public List<Quadbike> getAll(){
        
        return quadbikeService.getAll();
        
    }
    
    /**
     * getQuadbike(@PathVariable("id") int id)
     * Método que busca y devuelve una cuatrimoto especifica por el id en la
     * base de datos a traves de una petición GET. Este id va en la ruta de la
     * url
     * @param id EL id de la cuatrimoto que se quiere buscar
     * @return Cuatrimoto con el id ingresado
     */
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int id){
        
        return quadbikeService.getQuadbike(id);
        
    }

    /**
     * save(@RequestBody Quadbike quadbike)
     * Método que guarda y devuelve una cuatrimoto en la base de datos a traves
     * de una petición POST
     * @param quadbike La cuatrimoto que se va a guardar en formato JSON
     * @return La cuatrimoto guardada
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike){
        
        return quadbikeService.save(quadbike);
        
    }
    
    /**
     * update(@RequestBody Quadbike quadbike)
     * Método que actualiza y devuelve una cuatrimoto en la base de datos a
     * traves de una petición PUT
     * @param quadbike La cuatrimoto que se va a actualizar en formato JSON
     * @return La cuatrimoto actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        
        return quadbikeService.update(quadbike);
        
    }

    /**
     * delete(@PathVariable("id") int idQuadbike)
     * Método que borra una cuatrimoto por el id y devuelve un valor booleano
     * dependiendo de si se borro con exito. El id va incluido en la ruta
     * de la url
     * @param idQuadbike El id de la cuatrimoto a borrar que va en la url
     * @return True o false dependiendo de si se borro la cuatrimoto
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idQuadbike) {
        
        return quadbikeService.deleteQuadbike( idQuadbike);
        
    }
    
}
