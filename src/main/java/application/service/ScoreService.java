package application.service;

import application.model.Score;
import application.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {

        return scoreRepository.getAll();

    }

    public Optional<Score> getScore(int id) {

        return scoreRepository.getScore(id);
    }

   
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
