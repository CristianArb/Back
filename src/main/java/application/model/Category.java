package application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Category.
 * Esta clase implementa FirstCode Es un entity que se almacena con el
 * nombre <H2>category</H2> en la base de datos Contiene los atributos y se
 * maneja un autoincremento para idCategory.
 *
 * @since 2021-10-25
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    /**
     * Constructor vacio de la clase Category.
     */
    public Category() {
    }

    /**
     * Este atributo corresponde a la PK de la tabla Category.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    /**
     * Este atributo corresponde al nombre de cada categoria y a la columna
     * name. de la tabla Category
     */
    @Column(name = "name", length = 45)
    private String name;

    /**
     * Este atrubuto corresponde a la descripción de cada cliente y a la columna
     * description de la tabla Category.
     */
    @Column(name = "description", length = 250)
    private String description;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Category con Quadbike. Category posee relación de uno a muchos con
     * Quadbike.
     */
    @OneToMany(cascade = {PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties({"category"})
    private List<Quadbike> quadbikes;

    /**
     * getId() 
     * Método get que devuelve el valor del id de la categoria
     * @return El id de la categoria
     */
    public Integer getId() {
        return id;
    }

    /**
     * setId(Integer id) 
     * Método set para modificar el id de la categoria
     * @param id El id de la categoria
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getName() 
     * Método get que devuelve el nombre de la categoria
     * @return El nombre de la categoria
     */
    public String getName() {
        return name;
    }

    /**
     * setName(String name) 
     * Método set para modificar el nombre de la categoria
     * @param name El nombre de la categoria
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDescription() 
     * Método get que devuelve la descripción de la categoria
     * @return La descripción de la categoria
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription(String description) 
     * Método set para modificar la descripción de la categoria
     * @param description La descripción de la categoria
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getQuadbikes() 
     * Método get que devuelve una lista con las cuatrimotos de
     * la categoria
     * @return Las cuatrimotos de la categoria
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    /**
     * setQuadbikes(List"<"Quadbike">" quadbikes) 
     * Método set para modificar la lista de cuatrimotos de la categoria
     * @param quadbikes Lista de cuatrimotos de la categoria
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }

}
