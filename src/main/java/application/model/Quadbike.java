/*
 * Crear base de datos MySQL y conectarlas, H2 me crea una base de datos
 * volatil mediante Spring JPA ideal para el desarrollo
 */
package application.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author cterr
 */

@Entity
@Table(name="quadbike")
public class Quadbike implements Serializable{//Para enviar datos y recibir
    //en 
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(nullable = false, length = 45)//Ajustar longitud
    private String name;
    @Column(nullable = false, length = 45)
    private String brand;
    @Column(nullable = false, length = 4)    
    private Integer year;
    @Column(nullable = false, length = 250)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties({"quadbikes"})
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Reservation> reservations;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbike")
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
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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


