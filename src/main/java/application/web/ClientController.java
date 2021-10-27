package application.web;

import application.model.Client;
import application.service.ClientService;
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
 * ClientController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla cliente y provee al ClientService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE})
public class ClientController {

    /**
     * Instancia con @Autowired de la clase servicio CategoryService
     */
    @Autowired
    private ClientService clientService;

    /**
     * getClients()
     * Método que devuelve todos los clientes guardados en la base de datos a
     * traves de una petición GET
     * @return Lista con todos los clientes
     */
    @GetMapping("/all")
    public List<Client> getClients() {

        return clientService.getAll();

    }

    /**
     * getClient(@PathVariable("id") int clientId)
     * Método que busca y devuelve un cliente especifico por el id en la base
     * de datos a traves de una petición GET. Este id va en la ruta de la url
     * @param clientId EL id del cliente que se quiere buscar
     * @return Cliente con el id ingresado
     */
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId) {

        return clientService.getClient(clientId);

    }

    /**
     * save(@RequestBody Client client)
     * Método que guarda y devuelve un cliente en la base de datos a traves
     * de una petición POST
     * @param client El cliente que se va a guardar en formato JSON
     * @return El cliente guardado
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Client save(@RequestBody Client client) {

        return clientService.save(client);

    }

    /**
     * update(@RequestBody Client client)
     * Método que actualiza y devuelve un cliente en la base de datos a
     * traves de una petición PUT
     * @param client El cliente que se va a actualizar en formato JSON
     * @return El cliente actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Client update(@RequestBody Client client) {

        return clientService.update(client);

    }

    /**
     * delete(@PathVariable("id") int clientId)
     * Método que borra un cliente por el id y devuelve un valor booleano
     * dependiendo de si se borro con exito. El id va incluido en la ruta
     * de la url
     * @param clientId El id del cliente a borrar que va en la url
     * @return True o false dependiendo de si se borro el cliente
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return clientService.deleteClient(clientId);
    }
}
