package ee.mainor.WebAppHM.Service;

import ee.mainor.WebAppHM.Entity.Game;
import ee.mainor.WebAppHM.Repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class GuessingGameService {
    private final GameRepository gameRepository;
    private final Random rand = new Random();

    public GuessingGameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Long startGame() {
        Game game = new Game();
        game.setAnswer(rand.nextInt(100)); // Using nextInt with upper bound only
        Game savedGame = gameRepository.save(game);
        return savedGame.getId();
    }

    @Transactional(readOnly = true)
    public String takeGuess(Long gameId, Integer number) {
        // Retrieve the game from the database by its ID
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game != null) {
            Integer answer = game.getAnswer();

            if (answer > number) {
                return "The answer is bigger than " + number;
            } else if (answer < number) {
                return "The answer is lower than " + number;
            } else {
                return "Congratulations! You got the answer " + answer + ". Your guess: " + number;
            }
        } else {
            return "Game with ID " + gameId + " not found";
        }
    }
}