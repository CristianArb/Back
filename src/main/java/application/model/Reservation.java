
package application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author cterr
 */

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{

     
    @Id
    @Column(name = "idReservation")
    @GeneratedValue( strategy = GenerationType.IDENTITY) 
    private Integer idReservation;
    
    @Column(name = "startDate")
    private Date startDate;
    
    @Column(name = "devolutionDate")
    private Date devolutionDate;
    
    @Column(name = "status")
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservations")
    private Quadbike quadbike;
            
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    @OneToOne
    @JoinColumn(name="score")
    @JsonIgnoreProperties({"reservation"})
    private Score score;    
    

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

    /**
     * @return the idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * @param idReservation the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    
}