package redrock.invaders.game.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.controllers.Controller;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.ScreenManager;
import redrock.invaders.game.assets.ControllerLoader;

/**
 * Created by Velmont on 2017-07-19.
 */
public class GamePlayScreen extends InvaderScreen{
    private ControllerLoader controllerLoader;

    public GamePlayScreen(AssetManager assetManager) {
        super(assetManager);
        controllerLoader = Mdx.di.getBean(ControllerLoader.class);
    }

    @Override
    public void initialise(GameContainer gc) {
        if(controllerLoader != null){
            System.out.println("notnull");
        }
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends org.mini2Dx.core.screen.GameScreen> screenManager, float delta) {

    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {

    }

    @Override
    public void render(GameContainer gc, Graphics g) {

    }

    @Override
    public int getId() {
        return ScreenEnum.GAME_PLAY.ordinal();
    }
}
