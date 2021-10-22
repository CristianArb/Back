/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.web;


import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import application.service.QuadbikeService;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author cterr
 */
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= { GET, POST, PUT, DELETE}, allowedHeaders = "*")
@RestController
public class QuadbikeController {
    
    @RequestMapping("/api")
    public String welcomePage() {
        
		return "Bienvenido a la api";
                
	}
           
    
    @Autowired
    private QuadbikeService quadbikeService;
    
    @GetMapping("/all")
    public List<Quadbike> getPapelerias(){
        
        return quadbikeService.getAll();
        
    }
    
    
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int id){
        
        return quadbikeService.getQuadbike(id);
        
    }

    
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike){
        
        return quadbikeService.save(quadbike);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        
        return quadbikeService.update(quadbike);
        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idQuadbike) {
        
        return quadbikeService.deleteQuadbike( idQuadbike);
        
    }
}
