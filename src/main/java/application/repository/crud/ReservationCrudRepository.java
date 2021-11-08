package application.repository.crud;

import application.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * ReservationCrudRepository
 * Esta Interface se extiende de la interface CrudRepository quien contiene las
 * operaciones basicas CRUD sobre la base de datos, para poder actuar sobre la
 * tabla reservation que tiene una llave primaria Integer. Ademas contiene
 * métodos de consultas especificas en a la base de datos y una consulta nativa
 * de jQuery.
 * 
 * @since 2021-10-26
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
    /**
     * findAllByStatus
     * Método busca todas las reservaciones por su status y devuelve una
     * lista de todas las reservaciones que coincidan con el status
     * @param status Status de las reservaciones a buscar
     * @return Lista de todas las reservaciones con el status especificado
     */
    public List<Reservation> findAllByStatus (String status);
    
    /**
     * findAllByStartDateAfterAndStartDateBefore
     * Método que devuelve una lista con todas las reservaciones que se
     * encuentren entre las fechas especificadas
     * @param dateOne Fecha inicial para la busqueda
     * @param dateTwo Fecha final para la busqueda
     * @return Lista de todas las reservaciones que esten en el intervalo de
     * tiempo
     */
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    /**
     * countTotalReservationByClient
     * Método que usa una consulta nativa en jQuery que devuelve una lista con
     * todos los clientes y su número de reservaciones ordenados de forma
     * descendente.
     * Consulta nativa:
     * Select clientid, count(*) as "total" from reservacion group by clientid order by total desc;
     * 
     * @return Lista de clientes con la cantidad total de reservaciones hechas
     * por cada uno ordenados de mayor a menor
     */
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
    
}
