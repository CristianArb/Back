package application.web;


import application.model.Reservation;
import application.reports.ContadorClientes;
import application.reports.StatusReservas;
import application.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * ReservationController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla Reservation y provee al ReservationService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class ReservationController {
    
    /**
     *Instancia con @Autowired de la clase servicio ReservationService
     */
    @Autowired
    private ReservationService reservationService;

     /**
     *getReservations()
     *Método que devuelve todas las reservas guardadas en la base de datos a
     *traves de una petición GET
     *@return Lista con todas las reservas
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        
        return reservationService.getAll();
        
    }
    
     /**
     *getReservation(@PathVariable("id") int id)
     * Método que busca y devuelve una reserva en especifico por el id en la base
     * de datos a traves de una petición GET. Este id va en la ruta de la url
     * @param id, EL id de la reserva que se quiere buscar
     * @return Reserva con el id de ingresado
     */
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        
        return reservationService.getReservation(id);
        
    }

     /**
     * save(@RequestBody Reservation reservation)
     * Método que guarda y devuelve una reserva en la base de datos a traves
     * de una petición POST
     * @param reservation, La reserva que se va a guardar en formato JSON
     * @return La reserva guardada
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        
        return reservationService.save(reservation);
        
    }
    
     /**
     * update(@RequestBody Reservation reservation)
     * Método que actualiza y devuelve una reserva en la base de datos a
     * traves de una petición PUT
     * @param reservation, La reserva que se va a actualizar en formato JSON
     * @return La reserva actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        
        return reservationService.update(reservation);
        
    }

     /**
     * delete(@PathVariable("id") int idReservation)
     * Método que borra una reserva por el id y devuelve un valor booleano
     * dependiendo de si se borro con exito. El id va incluido en la ruta
     * de la url
     * @param  idReservation, El id de la reserva a borrar que va en la url
     * @return True o false dependiendo de si se borro la reserva
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        
        return reservationService.deleteReservation( idReservation );
        
    }
    
    /**
     * getReservationStatusReport()
     * Función que obtiene el status de la reserva de reservationService
     * @return Status de la Reserva
     */
    @GetMapping("/report-status")
    public StatusReservas getReservationStatusReport(){
        
        return reservationService.getReservationsStatusReport();
        
    }
    
    /**
     * getReservationReportDates()
     * Función que obtiene reporte de las reservas hecha en un intervalo de 
     * tiempo de reservationService
     * @param dateOne, fecha inicial 
     * @param dateTwo, fecha final 
     * @return Lista con las reservas hechas en un intervalo de tiempo
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable ("dateOne") String dateOne, @PathVariable ("dateTwo") String dateTwo) {
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    
    /**
     * getReservationReportClients()
     * Función que obtiene reporte de clientes que mas dinero le han dejado 
     * a la compañia dereservationService
     * @return Lista con los clientes que mas dinero le han dejado a la 
     * compañia
     */
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportsClients() {
        return reservationService.getTopClientes();
    }
    
}
