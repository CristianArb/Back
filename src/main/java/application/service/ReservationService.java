package application.service;

import application.model.Reservation;
import application.repository.ReservationRepository;
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
     * Instancia con @Autowired de la clase Reservation ReservationRepository
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

        } else {

            var paux = reservationRepository.getReservation(
                    reservation.getIdReservation()
            );

            if (!paux.isPresent()) {

                return reservationRepository.save(reservation);

            } else {

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

            var e = reservationRepository.getReservation(reservation.getIdReservation());

            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {

                    e.get().setStartDate(reservation.getStartDate());

                }

                if (reservation.getDevolutionDate() != null) {

                    e.get().setDevolutionDate(reservation.getDevolutionDate());

                }

                if (reservation.getStatus() != null) {

                    e.get().setStatus(reservation.getStatus());

                }

                reservationRepository.save(e.get());

                return e.get();
            } else {
                return reservation;
            }
        } else {
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
}
