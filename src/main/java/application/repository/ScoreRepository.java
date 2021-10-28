package application.repository;

import java.util.List;
import java.util.Optional;
import application.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.ScoreCrudRepository;

/**
 * ScoreRepository
 * Esta clase es tipo repositorio, utiliza la interface ScoreCrudRepository 
 * para usar funciones basicas del CRUD, comunicarse con la base de datos y 
 * hacer operaciones sobre la tabla score
 *
 * @since 2021-10-28
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Repository
public class ScoreRepository {

    /**
     * Instancia con @Autowired de la interface ScoreCrudRepository
     */
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    /**
     * getAll()
     * Método que devuelve todos los scores guardados en la base de datos
     * @return Lista con todos los scores
     */
    public List<Score> getAll() {

        return (List<Score>) scoreCrudRepository.findAll();

    }

    /**
     * getScore(Integer id)
     * Método que busca y devuelve un score especifico por el id en la base
     * de datos
     * @param id EL id del score que se quiere buscar
     * @return Score con el id ingresado
     */
    public Optional<Score> getScore(Integer id) {

        return scoreCrudRepository.findById(id);

    }

    /**
     * save(Score score)
     * Método que guarda un score en la base de datos y lo devuelve
     * @param score El score que se va a guardar
     * @return El score guardado
     */
    public Score save(Score score) {

        return scoreCrudRepository.save(score);

    }

}
