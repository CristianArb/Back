package application.web;


import application.model.Reservation;
import application.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        
        return reservationService.getAll();
        
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        
        return reservationService.getReservation(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        
        return reservationService.save(reservation);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        
        return reservationService.update(reservation);
        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        
        return reservationService.deleteReservation( idReservation );
        
    }
}
