package application.service;

import application.model.Score;
import application.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * ScoreService
 * Esta clase es de tipo servicio
 * Contiene la logica de negocios con sus respectivas validaciones poder hacer
 * consultas y modificaciones a la tabla score en la base de datos usando el
 * repositorio ScoreRepository
 * 
 * @since 2021-10-28
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
@Service
public class ScoreService {

    /**
     * Instancia con @Autowired de la clase repositorio ScoreRepository.
     */
    @Autowired
    private ScoreRepository scoreRepository;

    /**
     * getAll()
     * Método que devuelve todos los scores guardados en la base de datos
     * @return Lista con todos los scores
     */
    public List<Score> getAll() {

        return scoreRepository.getAll();

    }

    /**
     * getScore(int id)
     * Método que busca y devuelve un cliente especifico por el id en la base
     * de datos
     * @param id EL id del score que se quiere buscar
     * @return Score con el id ingresado
     */
    public Optional<Score> getScore(int id) {

        return scoreRepository.getScore(id);
    }


    /**
     * save(Score score)
     * Método que guarda un score, verifica que no tenga id para guardarlo
     * y si tiene id valida que no este repetido en la base de datos. Si pasa
     * las validaciones devuelve el score cuardado, sino solo devuelve el
     * score ingresado
     * @param score Score que se va a guardar
     * @return El Score ingresado
     */

    public Score save(Score score) {

        if (score.getIdScore() == null) {

            return scoreRepository.save(score);

        } else {

            var paux = scoreRepository.getScore(
                    score.getIdScore()
            );

            if (!paux.isPresent()) {

                return scoreRepository.save(score);

            } else {

                return score;

            }
        }
    }
}
