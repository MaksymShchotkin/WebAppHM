package ee.mainor.WebAppHM.Service;

import ee.mainor.WebAppHM.DTO.GuessingGameDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GuessingGameService {
    Random rand = new Random();
    public List<GuessingGameDTO> gameSaver = new ArrayList<>();

    public Long startGame() {
        GuessingGameDTO guessingGameDTO = new GuessingGameDTO();
        guessingGameDTO.setId((long) gameSaver.size());
        guessingGameDTO.setAnswer(rand.nextInt(100)); // Using nextInt with upper bound only
        gameSaver.add(guessingGameDTO);
        return guessingGameDTO.getId();
    }

    public String takeGuess(Integer game_id, Integer number) {
        if (gameSaver.size() - 1 >= game_id) {
            if (gameSaver.get(game_id).getAnswer() > number) {
                return "The answer is bigger then " + number;
            } else if (gameSaver.get(game_id).getAnswer() < number) {
                return "The answer is lower then " + number;
            } else if (gameSaver.get(game_id).getAnswer() == number) {
                return "Congratulations! You got the answer " + gameSaver.get(game_id).getAnswer() + ". Your guess: " + number;
            }
        } else {
            return "Your id is invalid";
        }
        return "Unexpected condition occured";
    }
}