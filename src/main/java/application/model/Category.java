package application.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Esta clase es un entity que se almacena con el nombre Cateory
 * @author Cristian Peña
 */
@Entity
@Table(name="category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column( length = 45)
    private String name;
    @Column( length = 250)
    private String description;

    @OneToMany(cascade = {PERSIST},mappedBy = "category")
    @JsonIgnoreProperties({"category"})
    private List<Quadbike> quadbikes;

    
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
     * @return the quadbikes
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    /**
     * @param quadbikes the quadbikes to set
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }
    
}
