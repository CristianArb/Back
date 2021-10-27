package application.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Category
 * Esta clase implementa FirstCode 
 * Es un entity que se almacena con el nombre <H2>quadbike</H2> en la base de
 * datos Contiene los atributos y se maneja un autoincremento para idCategory
 *
 * @since 2021-10-27
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Entity
@Table(name="quadbike")
public class Quadbike implements Serializable{
    
    /**
     * Quadbike()
     * Constructor vacio de la clase Quadbike.
     */
    public Quadbike() {
    }
    
    /**
     * Atributo integer que actua como llave principal de la clase quadbike.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = IDENTITY) 
    private Integer idQuadbike;
    
    /**
     * Atributo String que almacena el nombre de la cuatrimoto.
     * Con una longitud de 45 caracteres.
     */
    @Column(name = "name", length = 45)
    private String name;
    
    /**
     * Atributo String que almacena la marca de la cuatrimoto.
     * Longitud de 45 caracteres.
     */
    @Column(name = "brand", length = 45)
    private String brand;
    
    /**
     * Atributo Integer que almacena el año de la cuatrimoto.
     */ 
    @Column(name = "year", precision = 4, scale = 0)
    private Integer year;
    
    /**
     * Atributo String que almacena la descripcion de la cuatrimoto.
     * Longitud de 250 caracteres.
     */
    @Column(name = "description", length = 250)
    private String description;
    
    /**
     * Atributo category que relaciona un entity category.
     * La relación se da mediante la llave foranea id Category.
     * La relacioón es de muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties({"quadbikes"})
    private Category category;
    
    /**
     * Atributo List"<"Reservation">" que relaciona un entity reservations.
     * La relación es de uno a muchos.
     */
    @OneToMany(cascade = {PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Reservation> reservations;
    
    /**
     * Atributo List"<"Message">" que relaciona un entity messages.
     * La relación es de uno a muchos.
     */
    @OneToMany(cascade = {PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;

    /**
     * getIdQuadbike()
     * Método get que devuelve el valor del id de la cuatrimoto
     * @return El id de la cuatrimoto
     */
    public Integer getIdQuadbike() {
        return idQuadbike;
    }

    /**
     * setIdQuadbike(Integer idQuadbike)
     * Método set para modificar el id de la cuatrimoto
     * @param idQuadbike El id de la cuatrimoto
     */
    public void setIdQuadbike(Integer idQuadbike) {
        this.idQuadbike = idQuadbike;
    }

    /**
     * getName()
     * Método get que devuelve el nombre de la cuatrimoto
     * @return El nombre de la cuatrimoto
     */
    public String getName() {
        return name;
    }

    /**
     * setName(String name)
     * Método set para modificar el nombre de la cuatrimoto
     * @param name El nombre de la cuatrimoto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getBrand()
     * Método get que devuelve la marca de la cuatrimoto
     * @return La marca de la cuatrimoto
     */
    public String getBrand() {
        return brand;
    }

    /**
     * setBrand(String brand)
     * Método set para modificar la marca de la cuatrimoto
     * @param brand La marca de la cuatrimoto
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * getYear()
     * Método get que devuelve el año de la cuatrimoto
     * @return El año de la cuatrimoto
     */
    public Integer getYear() {
        return year;
    }

    /**
     * setYear(Integer year)
     * Método set para modificar el año de la cuatrimoto
     * @param year El año de la cuatrimoto
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * getDescription()
     * Método get que devuelve la descripción de la cuatrimoto
     * @return La descripción de la cuatrimoto
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription(String description)
     * Método set para modificar la descripción de la cuatrimoto
     * @param description La descipción de la cuatrimoto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getCategory()
     * Método get que devuelve la categoria de la cuatrimoto
     * @return La categoria de la cuatrimoto
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setCategory(Category category)
     * Método set para modificar la categoria de la cuatrimoto
     * @param category La categoria de la cuatrimoto
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * getReservations()
     * Método get que devuelve una lista con las reservaciones de la cuatrimoto
     * @return Las reservaciones de la cuatrimoto
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setReservations(List"<"Reservation">" reservations)
     * Método set para modificar la lista de reservaciones de la cuatrimoto
     * @param reservations Lista de reservaciones de la cuatrimoto
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * getMessages()
     * Método get que devuelve una lista con los mensajes de la cuatrimoto
     * @return Los mensajes de la cuatrimoto
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setMessages(List"<"Message">" messages)
     * Método set para modificar la lista de mensajes de la cuatrimoto
     * @param messages Lista de mensajes de la cuatrimoto
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    
}