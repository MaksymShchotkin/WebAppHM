package ee.mainor.WebAppHM.Controller;

import ee.mainor.WebAppHM.Service.GuessingGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GuessingGameController {

    private final GuessingGameService guessingGameService;

    @Autowired
    public GuessingGameController(GuessingGameService guessingGameService) {
        this.guessingGameService = guessingGameService;
    }

    @PostMapping("/game")
    public Long startGame() {
        return guessingGameService.startGame();
    }

    @GetMapping("/game/{game_id}/guess/{number}")
    public String takeGuess(@PathVariable("game_id") Long gameId, @PathVariable("number") Integer number) {
        return guessingGameService.takeGuess(gameId, number);
    }

    @GetMapping("/game")
    public Long printGameID() {
        return guessingGameService.startGame();
    }
}
