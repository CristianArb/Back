/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.model.Message;
import java.util.List;
import java.util.Optional;
import application.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.ScoreCrudRepository;

/**
 *
 * @author cterr
 */
@Repository
public class ScoreRepository {

    //Que hace esa etiqueta
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {

        return (List<Score>) scoreCrudRepository.findAll();

    }

    public Optional<Score> getScore(Integer id) {

        return scoreCrudRepository.findById(id);

    }

    public Score save(Score score) {

        return scoreCrudRepository.save(score);

    }

}
