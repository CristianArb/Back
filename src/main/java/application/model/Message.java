
package application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message
 * Esta Clase implementa Serializable, es un Entity que se almacena con
 * el nombre <H2> message </H2> en la Base de Datos Contine los atributos y se
 * maneja un autoincremento para idMenssage
 *
 * @since 201-10-25
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 *
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    
    /**
     * Message()
     * Constructor vacio de la clase Quadbike.
     */
    public Message() {
    }
    
    /**
     * Este atributo corresponde a la PK de la tabla Menssage.
     */
    @Id
    @Column(name = "idMessage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    /**
     * Este atributo corresponde al mensaje que ingresa cada cliente y a la
     * columna messageText de la tabla Message.
     */
    @Column(name = "messageText", length = 250)
    private String messageText;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Message con Quadbike. Message posee relación de uno a muchos con
     * Quadbike.
     */

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Message con Client. Message posee relación de uno a muchos con Client.
     */
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Client client;

    /**

     * getIdMessage()
     * Esta función retorna el id de mensaje
     * @return El id del mensaje
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**

     * getIdMessage()
     * Esta función retorna el id de mensaje
     * @param idMessage
     * @returm idMenssage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * getMessageText()
     * Esta función retorna un mensaje almacenado en la base de datos
     *
     * @return El mensaje por cada cuatrimoto
     * @returm messageText, the messageText to set
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * setMessageText(String messageText)
     * Esta función retorna un mensaje almacenado en la base de datos
     *
     * @param messageText, the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * getQuadbike()
     * Esta función retorna la cuatrimoto almacenada en la base de datos
     *
     * @return La cuatrimoto de la cual corresponde el mensaje
     * @returm the quadbike
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * setQuadbike(Quadbike quadbike)
     * Esta función recibe la información almacenada de cuatrimotos
     *
     * @param quadbike, the quadbike to set
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * getClient()
     * Esta funcion retorna la informacion del cliente almacenada en la base
     * de datos
     *
     * @return El cliente al cual corresponde el mensaje
     * @returm the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * setClient(Cliente client)
     * Esta funcion recibe un cliente y actualiza la informacion del mensaje
     * en la base de datos
     *
     * @param client, the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
       
}
