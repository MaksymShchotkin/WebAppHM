package ee.mainor.WebAppHM.Mapper;

import ee.mainor.WebAppHM.Entity.Game;
import ee.mainor.WebAppHM.DTO.GameDTO;

public class GameMapper {
    public static Game updateEntity(GameDTO source, Game target) {
        target.setAnswer(source.getAnswer());
        return target;
    }


    public static GameDTO toDto(Game request) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(request.getId());
        gameDTO.setAnswer(request.getAnswer());
        return gameDTO;
    }
}
