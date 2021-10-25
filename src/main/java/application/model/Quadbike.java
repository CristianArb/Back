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
 * Esta clase es un entity que se almacena con el nombre quadbike
 * @author Grupo 0.
 */
@Entity
@Table(name="quadbike")
public class Quadbike implements Serializable{
    
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
     * Atributo List<Reservation> que relaciona un entity reservations.
     * La relación es de uno a muchos.
     */
    @OneToMany(cascade = {PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Reservation> reservations;
    
    /**
     * Atributo List<Message> que relaciona un entity messages.
     * La relación es de uno a muchos.
     */
    @OneToMany(cascade = {PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;
 
    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }  
    
    
    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    
    /**
     * @return the idQuadbike
     */
    public Integer getId() {
        return idQuadbike;
    }

    /**
     * @param idQuadbike the idQuadbike to set
     */
    public void setId(Integer idQuadbike) {
        this.idQuadbike = idQuadbike;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the model to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}


