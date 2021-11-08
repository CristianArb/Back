package application.service;

import application.model.Reservation;
import application.reports.ContadorClientes;
import application.reports.StatusReservas;
import application.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * ReservationService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla Reservation en la base de datos usando el
 * repositorio ReservationRepository
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class ReservationService {
    
    /**
     * Instancia con @Autowired de la clase Reservation ReservationRepository.
     */
    @Autowired
    private ReservationRepository reservationRepository;
    
    /**
     * getAll()
     * Método que devuelve todas las reservas guardadas en la base de datos
     * @return Lista con todas las reservas
     */
    public List<Reservation> getAll() {

        return reservationRepository.getAll();

    }
    
    /**
     * getReservation(int id)
     * Método que busca y devuelve una reserva en especifico por el id en la base
     * de datos
     * @param id, EL id de la reserva que se quiere buscar
     * @return reserva con el id de ingresado
     */
    public Optional<Reservation> getReservation(int id) {

        return reservationRepository.getReservation(id);
    }
    
    /**
     * save(Reservation reservation)
     * Método que guarda una reserva, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve la reserva guardada, sino solo devuelve el
     * mensaje ingresado
     * @param reservation, Reserva que se va a guardar
     * @return La reserva ingresada
     */
    public Reservation save(Reservation reservation) {

        if (reservation.getIdReservation() == null) {


            return reservationRepository.save(reservation);
            
        }
        else{
            
            Optional<Reservation> reservationAux=reservationRepository.getReservation(
                    reservation.getIdReservation()
            );
            
            if(reservationAux.isEmpty()){
                
                return reservationRepository.save(reservation);
                
            }
            else{
                
                return reservation;
                
            }
        }
    }

         
    /**
     * update(Reservation reservation)
     * Método que actualiza una reserva, verifica que la reserva tenga id y
     * que exista en la base de datos, en caso de que tenga campos nulos no se
     * guardaran. Si pasa las validaciones devuelve la reserva actualizada,
     * sino solo devuelve la reserva ingresada
     * @param reservation, Reserva que se va a actualizar
     * @return La reserva ingresada
     */
    public Reservation update(Reservation reservation) {

        if (reservation.getIdReservation()!= null) {

            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());

            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {

                    e.get().setStartDate(reservation.getStartDate());
                    
                }
                
                if(reservation.getDevolutionDate()!=null){
                    
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                    
                }
                
                if(reservation.getStatus()!=null){
                    
                    e.get().setStatus(reservation.getStatus());
                    
                }
                
                reservationRepository.save(e.get());
                
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /**
     * deleteReservation(int reservationId)
     * Método que borra una reserva por el id, usando una función map para
     * verificar si la reserva con el id existe en la base de datos. Devuelve
     * un booleano dependiendo del exito de la operación
     * @param reservationId, El id de la reserva a borrar
     * @return Un true o false dependiendo de si se borro la reserva
     */
    public boolean deleteReservation(int reservationId) {
        
        var aBoolean = getReservation(reservationId).map(reservation -> {          
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        
        return aBoolean;
        
    }
    
    /**
     * getReservationsStatusReport
     * Método que devuelve el objeto StatusReservas con la información de la
     * cantidad de reservas completadas y canceladas
     * @return Objeto StatisReservas con la información de las reservas
     * completas y canceladas
     */
    public StatusReservas getReservationsStatusReport (){
       List<Reservation>completed = reservationRepository.getReservationByStatus("completed");
       List<Reservation>cancelled = reservationRepository.getReservationByStatus("cancelled");
       return new StatusReservas(completed.size(), cancelled.size());
    }
    
    /**
     * getReservationPeriod
     * Método que recibe y parsea dos fechas y que devuelve una lista con las
     * reservaciones que estan en el intervalo de tiempo de las 2 fechas
     * @param dateA Fecha inicial del periodo de tiempo
     * @param dateB Fecha final del periodo de tiempo
     * @return Lista con las reservaciones que estan entre las 2 fechas
     */
    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date aDate = new Date();
        Date bDate = new Date();
        
        try{
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        } catch(ParseException evt) {
            evt.printStackTrace();
        }
        
        if(aDate.before(bDate)) {
            return reservationRepository.getReservationPeriod(aDate, bDate);
        } else {
            return new ArrayList<>();
        }
    }
    
    /**
     * getTopClientes
     * Método que devuelve una lista de ContadorClientes con el top de los
     * clientes con el mayor número de reservas ordenados de mayor a menor
     * 
     * @return Lista top de los clientes con mas reservaciones ordenados
     * en orden descendente
     */
    public List<ContadorClientes> getTopClientes() {
        return reservationRepository.getTopClients();
    }
    
}
