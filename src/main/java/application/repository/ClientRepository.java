package application.repository;

import application.model.Client;
import application.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ClientRepository
 * Esta clase es tipo repositorio, utiliza la interface ClientCrudRepository
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y
 * hacer operaciones sobre la tabla client
 *
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class ClientRepository {
    
    /**
     * Instancia con @Autowired de la interface ClientCrudRepository.
     */
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    /**
     * getAll()
     * Método que devuelve todos los clientes guardados en la base de datos
     * @return Lista con todos los clientes
     */
    public List<Client> getAll(){
        
        return (List<Client>) clientCrudRepository.findAll();
        
    }
    
    /**
     * getCliente(int id)
     * Método que busca y devuelve un cliente especifico por el id en la base
     * de datos
     * @param id EL id del cliente que se quiere buscar
     * @return Cliente con el id ingresado
     */
    public Optional<Client> getCliente(int id){
        
        return clientCrudRepository.findById(id);
        
    }

    /**
     * save(Client client)
     * Método que guarda un cliente en la base de datos y lo devuelve
     * @param client El cliente que se va a guardar
     * @return El clinete guardado
     */
    public Client save(Client client){
        
        return clientCrudRepository.save(client);
        
    }
    
    /**
     * delete(Client client)
     * Método que elimina un cliente de la base de datos
     * @param client El cliente que se va a eliminar
     */
    public void delete(Client client){
        
       clientCrudRepository.delete(client);
        
    }
}
