package redrock.invaders.game.gameData;

import lombok.Data;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.di.annotation.Singleton;
import redrock.invaders.game.model.Person;

/**
 * Created by Velmont on 2017-07-08.
 */
@Singleton
@Data
public class UserData {
    @Autowired
    private Person person;
}
