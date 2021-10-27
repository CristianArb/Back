package application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Quadbike 
 * Esta clase es un entity que se almacena con el nombre quadbike en la
 * base de Datos Contiene los atributos y se maneja un autoincremento para id
 *
 * @since 26-10-2021
 * @version 1.0
 * @author Grupo 0.
 */
@Entity
@Table(name = "quadbike")
public class Quadbike implements Serializable {

    /**
     * Constructor de la clase Quadbike.
     */
    public Quadbike() {
    }

    /**
     * Atributo integer que actua como llave principal de la clase quadbike.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Atributo String que almacena el nombre de la cuatrimoto. Longitud de 45
     * caracteres.
     */
    @Column(name = "name", length = 45)
    private String name;

    /**
     * Atributo String que almacena la marca de la cuatrimoto. Longitud de 45
     * caracteres.
     */
    @Column(name = "brand", length = 45)
    private String brand;

    /**
     * Atributo Integer que almacena el año de la cuatrimoto. Precision de 4
     * digito con escala de 0 decimales.
     */
    @Column(name = "year", precision = 4, scale = 0)
    private Integer year;

    /**
     * Atributo String que almacena la descripcion de la cuatrimoto. Longitud de
     * 250 caracteres.
     */
    @Column(name = "description", length = 250)
    private String description;

    /**
     * Atributo Category que relaciona el entity Quadbike con un entity
     * category. La relación se da mediante la llave foranea id Category. La
     * relacioón es de muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties({"quadbikes"})
    private Category category;

    /**
     * Atributo List<Message> que relaciona un entity messages. La relación es
     * de uno a muchos.
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;

    /**
     * Atributo List<Reservation> que relaciona un entity reservations. La
     * relación es de uno a muchos.
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Reservation> reservations;

    /**
     * Función que devuelve la lista almacenada en el atributo messages.
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Función que recibe la lista messages y la almacena en el atributo
     * messages.
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Función que devuelve un Integer almacenado en el atributo id.
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Función que recibe el Integer y lo almacena en el atributo id.
     * @param idCategory the id to set
     */
    public void setId(Integer idCategory) {
        this.id = idCategory;
    }

    /**
     * Función que devuelve la lista almacenada en el atributo reservations.
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Función que recibe la lista reservations y la almacena en el atributo
     * reservations.
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Función que devuelve un String almacenado en el atributo description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Función que recibe el String description y lo almacena en el atributo
     * description.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Función que devuelve el id almacenada en el atributo category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Función que recibe el id category y lo almacena en el atributo category.
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Función que devuelve el String almacenado en el atributo brand.
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Función que recibe el String brand y lo almacena en el atributo brand.
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Función que devuelve el Integer almacenada en el atributo year.
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Función que recibe el Integer year y lo almacena en el atributo year.
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Función que devuelve el String almacenado en el atributo name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Función que recibe el String name y lo almacena en el atributo name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
