package application.web;

import application.model.Message;
import application.service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla message y provee al MessageService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})

public class MessageController {
    /**
     *Instancia con @Autowired de la clase servicio MessageService
     */
    @Autowired
    private MessageService messageService;
    
    /**
     *getMessages()
     *Método que devuelve todas los mensajes guardados en la base de datos a
     *traves de una petición GET
     *@return Lista con todas los mensajes
     */
    @GetMapping("/all")
    public List<Message> getMessages(){
        
        return messageService.getAll();
        
    }
    
    /**
     * getMessage(@PathVariable("id") int messageId)
     * Método que busca y devuelve un mensaje especifico por el id en la base
     * de datos a traves de una petición GET. Este id va en la ruta de la url
     * @param messageId, EL id del mensaje que se quiere buscar
     * @return Mensaje con el id de ingresado
     */
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        
        return messageService.getMessage(messageId);
        
    }
    
    /**
     * save(@RequestBody Message message)
     * Método que guarda y devuelve un mensaje en la base de datos a traves
     * de una petición POST
     * @param message, El mensaje que se va a guardar en formato JSON
     * @return El mensaje guardado
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Message save(@RequestBody Message message) {
        
        return messageService.save(message);
    }
    
     /**
     * update(@RequestBody Mensaje message)
     * Método que actualiza y devuelve un mensaje en la base de datos a
     * traves de una petición PUT
     * @param message, El mensaje que se va a actualizar en formato JSON
     * @return El mensaje actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Message update(@RequestBody Message message) {
        
        return messageService.update(message);
        
    }

     /**
     * delete(@PathVariable("id") int messageId)
     * Método que borra un mensaje por el id y devuelve un valor booleano
     * dependiendo de si se borro con exito. El id va incluido en la ruta
     * de la url
     * @param  messageId, El id del mensaje a borrar que va en la url
     * @return True o false dependiendo de si se borro el mensaje
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        
        return messageService.deleteMessage(messageId);
        
    }
    
}
