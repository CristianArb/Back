/*
 * Crear base de datos MySQL y conectarlas, H2 me crea una base de datos
 * volatil mediante Spring JPA ideal para el desarrollo
 */
package application.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author cterr
 */

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{

     
    @Id
    @GeneratedValue( strategy = IDENTITY) 
    private Integer id;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name="quadbike")
    @JsonIgnoreProperties({"quadbikes","client"})
    private Quadbike quadbike;
            
    @ManyToOne
    @JoinColumn(name="client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    
    @OneToOne
    @JoinColumn(name="score")
    @JsonIgnoreProperties({"reservation"})
    private Score score;    
    
    
    /**
     * @return the idReservation
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param idReservation the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.id = idReservation;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the finalDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * @param devolutionDate the finalDate to set
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.status = Status;
    }
       
    /**
     * @return the quadbike
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * @param quadbike the quadbike to set
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }
    
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
    /**
     * @return the score
     */
    public Score getScore() {
        return score;
    }

    /**
     * @param score the Score to set
     */
    public void setScore(Score score) {
        this.score = score;
    }
    
}