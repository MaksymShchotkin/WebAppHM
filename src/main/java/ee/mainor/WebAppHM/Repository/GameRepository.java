package ee.mainor.WebAppHM.Repository;

import ee.mainor.WebAppHM.Entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
