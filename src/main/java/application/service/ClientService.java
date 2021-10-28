package application.service;

import application.model.Client;
import application.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla client en la base de datos usando el
 * repositorio ClientRepository
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class ClientService {

    /**
     * Instancia con @Autowired de la clase repositorio ClientRepository
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * getAll()
     * Método que devuelve todos los clientes guardados en la base de datos
     * @return Lista con todos los clientes
     */
    public List<Client> getAll() {

        return clientRepository.getAll();

    }

    /**
     * getClient(int clientId)
     * Método que busca y devuelve un cliente especifico por el id en la base
     * de datos
     * @param clientId EL id del cliente que se quiere buscar
     * @return Cliente con el id ingresado
     */
    public Optional<Client> getClient(int clientId) {

        return clientRepository.getCliente(clientId);

    }

    /**
     * save(Client client)
     * Método que guarda un cliente, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve el cliente cuardado, sino solo devuelve el
     * cliente ingresado
     * @param client Cliente que se va a guardar
     * @return El cliente ingresado
     */
    public Client save(Client client) {

        if (client.getIdClient() == null) {

            return clientRepository.save(client);

        } else {

            var e = clientRepository.getCliente(client.getIdClient());

            if (e.isEmpty()) {

                return clientRepository.save(client);

            } else {

                return client;

            }
        }
    }

    /**
     * update(Client client)
     * Método que actualiza un cliente, verifica que el cliente tenga id y
     * que exista en la base de datos, en caso de que tenga campos nulos no se
     * guardaran. Si pasa las validaciones devuelve el cliente actualizado,
     * sino solo devuelve el cliente ingresado
     * @param client Cliente que se va a actualizar
     * @return El cliente ingresado
     */
    public Client update(Client client) {

        if (client.getIdClient() != null) {

            var e = clientRepository.getCliente(client.getIdClient());

            if (!e.isEmpty()) {

                if (client.getName() != null) {

                    e.get().setName(client.getName());

                }

                if (client.getAge() != null) {

                    e.get().setAge(client.getAge());

                }
                if (client.getPassword() != null) {

                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());

                return e.get();
            } else {

                return client;
            }

        } else {

            return client;

        }
    }

    /**
     * deleteClient(int clientId)
     * Método que borra un cliente por el id, usando una función map para
     * verificar si el cliente con el id existe en la base de datos. Devuelve
     * un booleano dependiendo del exito de la operaión
     * @param clientId El id del cliente a borrar
     * @return Un true o false dependiendo de si se booro el cliente
     */
    public boolean deleteClient(int clientId) {

        var aBoolean = getClient(clientId).map(client -> {

            clientRepository.delete(client);

            return true;

        }).orElse(false);

        return aBoolean;
    }
}
