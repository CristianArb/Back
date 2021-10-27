package application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client
 * Esta clase implementa FirstCode
 * Es un entity que se almacena con el nombre <H2>client</H2> en la base de
 * datos Contiene los atributos y se maneja un autoincremento para idcliente
 *
 * @since 2021-10-25
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    /**
     * Este atributo corresponde a la PK de la tabla Client
     */
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = IDENTITY)
    private Integer idClient;

    /**
     * Este atributo corresponde al email de cada cliente y a la columna email
     * de la tabla Client
     */
    @Column(name = "email", length = 45)
    private String email;

    /**
     * Este atrubuto corresponde al password de cada cliente y a la columna
     * password de la tabla Client
     */
    @Column(name = "password", length = 45)
    private String password;

    /**
     * Este atrubuto corresponde al nombre de cada cliente y a la columna name
     * de la tabla Client
     */
    @Column(name = "name", length = 250)
    private String name;

    /**
     * Este atrubuto corresponde a la edad de cada cliente y a la columna age de
     * la tabla Client
     */
    @Column(name = "age", precision = 2, scale = 0)
    private Integer age;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Client con Reservation. Client posee relación de uno a muchos con
     * Reservation.
     */
    @OneToMany(cascade = {PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    private List<Reservation> reservations;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Client con Message. Client posee relación de uno a muchos con Message.
     */
    @OneToMany(cascade = {PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    private List<Message> messages;

    /**
     * Client()
     * Constructor vacio de la clase Client
     */
    public Client() {
    }

    /**
     * getId()
     * Método get que devuelve el valor del id del cliente
     * @return El id del cliente
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * setId(Integer id)
     * Método set para modificar el id del cliente
     * @param id El id del cliente
     */
    public void setId(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * getEmail()
     * Método get que devuelve el email del cliente
     * @return El email del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail(String email)
     * Método set para modificar el email del cliente
     * @param email El email del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getPassword()
     * Método get que devuelve el password del cliente
     * @return El password del cliente
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword(String password)
     * Método set para modificar el password del cliente
     * @param password El password del cliente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getName()
     * Método get que devuelve el nombre del cliente
     * @return El nombre del cliente
     */
    public String getName() {
        return name;
    }

    /**
     * setName(String name)
     * Método set para modificar el nombre del cliente
     * @param name El nombre del cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getAge()
     * Método get que devuelve la edad del cliente
     * @return La edad del cliente
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setAge(Integer age)
     * Método set para modificar la edad del cliente
     * @param age La edad del cliente
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * getReservations()
     * Método get que devuelve una lista con las reservaciones del cliente
     * @return Las reservaciones del cliente
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setReservations(List"<"Reservation">" reservations)
     * Método set para modificar la lista de reservaciones del cliente
     * @param reservations Lista de reservaciones del cliente
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * getMessages()
     * Método get que devuelve una lista con los mensajes del cliente
     * @return Los mensajes del cliente
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setMessages(List"<"Message">" messages)
     * Método set para modificar la lista de reservaciones del cliente
     * @param messages Lista de mensajes del cliente
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}