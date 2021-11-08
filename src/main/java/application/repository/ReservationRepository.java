package application.repository;

import application.model.Client;
import java.util.List;
import java.util.Optional;
import application.model.Reservation;
import application.reports.ContadorClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;

/**
 * ReservationRepository
 * Esta clase es tipo repositorio, utiliza la interfaz ReservationCrudRepository
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y
 * hacer operaciones sobre la tabla Reservation
 *
 * @desde 2021-10-25
 * @version 1.0
 * @autor Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class ReservationRepository{
    
   /**
     * Instancia con @Autowired de la interface ReservationCrudRepository.
     */
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    /**
     * getAll()
     * Método que devuelve todas las reservaciones guardadas en la base de datos
     * @return Lista con todas las reservaciones
     */
    public List<Reservation> getAll(){
    
        return (List<Reservation>) reservationCrudRepository.findAll();
    
    }
    
    /**
     * getReservation(Integer id)
     * Método que busca y devuelve una reservacion en especifico por el id en la base
     * de datos
     * @param id, EL id de la reservacion que se quiere buscar
     * @return Reservacion con el id de ingresado
     */
    public Optional<Reservation> getReservation(Integer id){
    
        return reservationCrudRepository.findById(id);
    
    }
    
    /**
     * save(Reservation reservation)
     * Método que guarda una reservacion en la base de datos y la devuelve
     * @param reservation,La reserva que se va a guardar
     * @return La reserva guardada
     */
    public Reservation save(Reservation reservation){
    
        return reservationCrudRepository.save(reservation);
    
    }
    
    /**
     * delete(Reservation reservation)
     * Método que elimina un mensaje de la base de datos
     * @param reservation, La reserva que se va a eliminar
     */
    public void delete(Reservation reservation){
        
        reservationCrudRepository.delete(reservation);
        
    }
    
    /**
     * getReservationByStatus
     * Método que devuelve una lista con todas la reservaciones que coincidan
     * con el status especificado
     * @param status El status de las reservaciones a consultar
     * @return Lista de reservaciones con el status especificado
     */
    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    /**
     * getReservationPeriod
     * Método que devuelve una lista con todas las reservaciones que este entre
     * dos fechas
     * @param a Fecha inicial del intervalo de tiempo
     * @param b Fecha final del intervalo de tiempo
     * @return Lista de reservaciones que esten en el intervalo de tiempo
     */
    public List<Reservation> getReservationPeriod(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    /**
     * getTopClients
     * Método que devulve una lista de objetos ContadorClientes, la cual
     * representa el top de clientes con mas reservaciones. Cada objeto
     * ContadorClientes almacena el cliente y su número de reservaciones
     * @return Lista con los clientes con mas reserva ordenados de mayor a menor
     */
    public List<ContadorClientes> getTopClients() {
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorClientes((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }
    
}
