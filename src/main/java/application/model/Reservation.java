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
 * Reservation
 * Esta Clase implementa Serializable, es un Entity que se almacena
 * con el nombre <H2> reservation </H2> en la Base de Datos Contine los
 * atributos y se maneja un autoincremento para idReservation
 *
 * @since 201-10-25
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    /**
     * Este atributo corresponde a la PK de la tabla Reservation
     */
    @Id
    @Column(name = "idReservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    /**
     * Este atributo corresponde a la fecha de inicio de cada reservacion y a la
     * columna startDate de la tabla Reservation
     */
    @Column(name = "startDate")
    private Date startDate;

    /**
     * Este atrubuto corresponde a la fecha de devolucion de cada reservacion y
     * a la columna devolutionDate de la tabla Reservation
     */
    @Column(name = "devolutionDate")
    private Date devolutionDate;

    /**
     * Este atrubuto corresponde al estado de cada reservacion y a la columna
     * status de la tabla Reservation
     */
    @Column(name = "status")
    private String status = "created";

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Reservation con Quadbike. Reservation posee relación de uno a muchos con
     * Quadbike.
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Quadbike quadbike;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Reservation con Quadbike. Reservation posee relación de uno a muchos con
     * Client.
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    /**
     * Este atrubuto corresponde a la llave foranea que relaciona a la tabla
     * Reservation con Quadbike. Reservation posee relación de uno a uno con
     * Score.
     */
    @OneToOne
    @JoinColumn(name = "score")
    @JsonIgnoreProperties({"reservation"})
    private Score score;

    /**
     * getStartDate()
     * Método get que devuelve el valor de la fecha de inicio de la reservación
     *
     * @return La fecha de inicio de la reservacion
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * setStartDate(Date startDate)
     * Esta funcion recibe la fecha de inicio de la reservación y actualiza la
     * informacion del objeto
     *
     * @param startDate, the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * getDevolutionDate()
     * Esta función retorna la fecha de entrega para la reservación
     *
     * @return La fecha de finalización de la reserva
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * setDevolutionDate(Date devolutionDate)
     * Esta función recibe la fecha de entrega para la reservación y actualiza
     * la información del objeto
     *
     * @param devolutionDate, the devolutionDate to set
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * getStatus()
     * Esta función retorna el estado en el que se encuentra la reservación
     *
     * @return El estado de la reserva
     */
    public String getStatus() {
        return status;
    }

    /**
     * setStatus(String status)
     * Esta función recibe el estado de la reservació y actualiza la 
     * información del objeto
     *
     * @param Status, the Status to set
     */
    public void setStatus(String Status) {
        this.status = Status;
    }

    /**
     * getQuadbike()
     * Esta función retorna el id de la cuatrimoto a reservar
     *
     * @return La cuatrimoto a reservar
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * setQuadbike(Quadbike quadbike)
     * Esta función recibe el id de la cuatrimoto que se va reservar y actualiza
     * la información del objeto
     *
     * @param quadbike, the quadbike to set
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * getClient()
     * Esta función retorna el id del cliente que esta haciendo la reservación
     *
     * @return El cliente que va hacer la reserva
     */
    public Client getClient() {
        return client;
    }

    /**
     * setClient(Cliente client)
     * Esta función recibe el id del cliente que esta haciendo la reservación
     * y actualiza la información del objeto
     *
     * @param client, the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * getScore()
     * Esta función retorna el puntaje del cliente respecto a la reservación
     *
     * @return
     */
    public Score getScore() {
        return score;
    }

    /**
     * setScore(String score)
     * Esta función recibe el puntaje del cliente respecto a la reservación
     * y actualiza la información del objeto
     *
     * @param score, the score to set
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * getIdReservation()
     * Esta función retorna el id de la reservación
     *
     * @return El id de la reservacion realizada
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * setIdReservation(Integer idReservation)
     * Esta función recibe el id de la reservación y actualiza la información
     * del objeto
     *
     * @param idReservation, the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

}
