 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository.crud;

import application.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cterr
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
