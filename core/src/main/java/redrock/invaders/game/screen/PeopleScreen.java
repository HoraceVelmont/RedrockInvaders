package redrock.invaders.game.screen;

import com.badlogic.gdx.assets.AssetManager;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.ui.UiContainer;
import redrock.invaders.game.gameData.UserData;

/**
 * Created by Velmont on 2017-07-03.
 */
public abstract class PeopleScreen extends BasicGameScreen {
    protected AssetManager assetManager;
    protected UiContainer uiContainer;
    @Autowired
    protected UserData userData;

    public PeopleScreen(AssetManager assetManager){
        this.assetManager = assetManager;
    }
}
