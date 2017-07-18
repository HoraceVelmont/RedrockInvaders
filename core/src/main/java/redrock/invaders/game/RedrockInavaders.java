package redrock.invaders.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.ui.UiContainer;
import redrock.invaders.game.assets.RedrockAssetLoader;
import redrock.invaders.game.screen.LoadingScreen;
import redrock.invaders.game.screen.MainScreen;
import redrock.invaders.game.screen.ScreenEnum;

public class RedrockInavaders extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "redrock.invaders.game";
	public static final int GAME_WIDTH = 960;
	public static final int GAME_HEIGHT = 540;
    public AssetManager assetManager;
    public UiContainer uiContainer;

	@Override
    public void initialise() {
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);

        RedrockAssetLoader.loadAll(assetManager);
        scanDependency();

        addScreen(new LoadingScreen(assetManager));
        addScreen(new MainScreen(assetManager));

    }

    private void scanDependency() {
        try {
            Mdx.di.scan(new String[]{"redrock.invaders.game.gameData", "redrock.invaders.game.model"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getInitialScreenId() {
        return ScreenEnum.LOADING.ordinal();
    }
}
