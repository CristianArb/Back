
package application.repository;
import java.util.List;
import java.util.Optional;
import application.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.ReservationCrudRepository;

/**
 *
 * @author cterr
 */
@Repository
public class ReservationRepository{
    
    //Que hace esa etiqueta
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
    
        return (List<Reservation>) reservationCrudRepository.findAll();
    
    }
    
    public Optional<Reservation> getReservation(Integer id){
    
        return reservationCrudRepository.findById(id);
    
    }
    
    public Reservation save(Reservation reservation){
    
        return reservationCrudRepository.save(reservation);
    
    }
    
    public void delete(Reservation reservation){
        
        reservationCrudRepository.delete(reservation);
        
    }
    
}
