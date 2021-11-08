package application.reports;

import application.model.Client;

/**
 * ContadorClientes
 * Esta clase permite crear un objeto ContadorClientes el cual almacena
 * la información de un cliente y la cantidad de reservas que este cliente ha
 * hecho
 * 
 * @since 2021-11-08
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
public class ContadorClientes {
    
    /**
     * Este atributo cuenta la cantidad total de reservas del cliente.
     */
    private Long total;
    
    /**
     * Este atributo corresponde al cliente que se le cuenta el número de
     * reservaciones.
     */
    private Client client;

    /**
     * Constructor de la clase ContadorClientes
     * @param total Número total de reservas del cliente
     * @param client El cliente al que se le cuenta las reservas
     */
    public ContadorClientes(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    /**
     * Método get que devuelve el número total de reservaciones del cliente
     * @return Total de reservaciones del cliente
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Método set que modifica el número total de reservaciones del cliente
     * @param total Total de reservaciones del cliente
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * Método get que devuelve el cliente al que se le cuenta las reservaciones
     * @return El cliente
     */
    public Client getClient() {
        return client;
    }

    /**
     * Método set que modifica el cliente al que se le cuentan las
     * reservaciones
     * @param client El cliente modificado
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
}
