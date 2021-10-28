package application.repository;

import application.model.Message;
import application.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * MessageRepository 
 * Esta clase es tipo repositorio, utiliza la interfaz MessageCrudRepository
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y
 * hacer operaciones sobre la tabla Message
 *
 * @desde 2021-10-25
 * @version 1.0
 * @autor Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class MessageRepository {

    /**
     * Instancia con @Autowired de la interface MessageCrudRepository
     */
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     * getAll()
     * Método que devuelve todas las categorías guardadas en la base de datos
     *
     * @return Lista con todos los mensajes
     */
    public List<Message> getAll() {

        return (List<Message>) messageCrudRepository.findAll();

    }

    /**
     * getMessage(int id)
     * Método que busca y devuelve un mensaje especifico por el id en la base
     * de datos
     *
     * @param id, EL id de el mensaje que se quiere buscar
     * @return Mensaje con el id de ingresado
     */
    public Optional<Message> getMessage(int id) {

        return messageCrudRepository.findById(id);

    }

    /**
     * save(Message message)
     * Método que guarda un mensaje en la base de datos y la devuelve
     *
     * @param message, El mensaje que se va a guardar
     * @return El Mensaje guardado
     */
    public Message save(Message message) {

        return messageCrudRepository.save(message);

    }

    /**
     * delete(Message message)
     * Método que elimina un mensaje de la base de datos
     *
     * @param message, El mensaje que se va a eliminar
     */
    public void delete(Message message) {

        messageCrudRepository.delete(message);

    }
}
