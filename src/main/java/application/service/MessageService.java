
package application.service;

import application.model.Message;
import application.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MessageService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla Messaje en la base de datos usando el
 * repositorio MessageRepository
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class MessageService {

    /**
     * Instancia con @Autowired de la clase Message MessageRepository.
     */
    @Autowired
    private MessageRepository messageRepository;
    
    /**
     * getAll()
     * Método que devuelve todas los mensajes guardados en la base de datos
     * @return Lista con todas los mensajes
     */
    public List<Message> getAll() {

        return messageRepository.getAll();
        
    }
    /**
     * getMessage(int messageId)
     * Método que busca y devuelve un mensaje especifico por el id en la base
     * de datos
     * @param messageId, EL id del mensaje que se quiere buscar
     * @return mensaje con el id de ingresado
     */
    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }
    
    
    /**
     * save(Message message)
     * Método que guarda un mensaje, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve el mensaje guardado, sino solo devuelve el
     * mensaje ingresado
     * @param message, mensaje que se va a guardar
     * @return El mensaje ingresado
     */
    public Message save(Message message) {

        if (message.getIdMessage() == null) {


            return messageRepository.save(message);
            
        }
        
        else{
            
            Optional<Message> messageAux= messageRepository.getMessage(message.getIdMessage());
            
            if(messageAux.isEmpty()){
                
                return messageRepository.save(message);
                
            }
            else{
                
                return message;
                
            }
        }
    }


    
    /**
     * update(Message message)
     * Método que actualiza un mensaje, verifica que el mensaje tenga id y
     * que exista en la base de datos, en caso de que tenga campos nulos no se
     * guardaran. Si pasa las validaciones devuelve el mensaje actualizado,
     * sino solo devuelve el mensaje ingresado
     * @param message, Mensaje que se va a actualizar
     * @return El mensjae ingresado
     */
    public Message update(Message message) {

        if (message.getIdMessage() != null) {

            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());

            if (!e.isEmpty()) {

                if (message.getMessageText() != null) {

                    e.get().setMessageText(message.getMessageText());
             
                }
                
                messageRepository.save(e.get());
                
                return e.get();
                
            }
            
            else{
                
                return message;
                
            }
            
        }
        else{
            
            return message;
            
        }
    }
    
    /**
     * deleteMessage(int messageId)
     * Método que borra un mensaje por el id, usando una función map para
     * verificar si el mensaje con el id existe en la base de datos. Devuelve
     * un booleano dependiendo del exito de la operaión
     * @param messageId, El id del mensaje a borrar
     * @return Un true o false dependiendo de si se borro el mensaje
     */
    public boolean deleteMessage(int messageId) {
        
        var aBoolean = getMessage(messageId).map(message -> {
            
            messageRepository.delete(message);
    
            return true;
            
        }).orElse(false);
        
        return aBoolean;
    }
}
