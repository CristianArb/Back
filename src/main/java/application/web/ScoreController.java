package application.web;

import application.model.Score;
import application.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * ScoreController
 * Esta clase es de tipo controller
 * Maneja las peticiones http que se crean desde el Front-end respecto a la
 * tabla score y provee al ScoreService de los insumos necesarios para
 * realizar sus operaciones
 * 
 * @since 2021-10-28
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class ScoreController {

    /**
     * Instancia con @Autowired de la clase servicio ScoreService
     */
    @Autowired
    private ScoreService scoreService;

    /**
     * save(@RequestBody Score c)
     * Método que guarda y devuelve un score en la base de datos a traves
     * de una petición POST
     * @param c El score que se va a guardar en formato JSON
     * @return El score guardado
     */
    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Score save(@RequestBody Score c){
        
        return scoreService.save(c);
        
    }
}
