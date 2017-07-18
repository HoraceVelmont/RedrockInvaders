package redrock.invaders.test.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import redrock.invaders.game.assets.RedrockAssetLoader;
import redrock.invaders.test.DummyRedrockInavaders;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Velmont on 2017-07-13.
 */
public class RedrockAssetLoaderTest {
    private DummyRedrockInavaders dummyRedrockInavaders;
    private final String SAMPLE_ASSET_DIRECTORY = "texture/animation";
    private final String SAMPLE_ASSET_NAME = "magi_victory";
    private final String SAMPLE_ASSET_SUFFIX = "atlas";
    private final String SAMPLE_ASSET_PATH = SAMPLE_ASSET_DIRECTORY + "/" + SAMPLE_ASSET_NAME + "." + SAMPLE_ASSET_SUFFIX;

    @Before
    public void setUp() throws Exception{
        dummyRedrockInavaders = new DummyRedrockInavaders();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(RedrockAssetLoader.class.getName());
        config.runGame = false;
        new HeadlessMini2DxGame(dummyRedrockInavaders, config);
    }

    @Test
    public void testIsInternalPathAvailable(){
        assertTrue(Gdx.files.internal(SAMPLE_ASSET_DIRECTORY).exists());
    }

    // Check if it is filtered by suffix
    @Test
    public void testIsSuffixMethodUsingRight(){
        FileHandle[] atlasFileArray = Gdx.files.internal(SAMPLE_ASSET_DIRECTORY).list(SAMPLE_ASSET_SUFFIX);
        String atlasFilePath = null;
        for(int i = 0; i< atlasFileArray.length; i++)   {
            if(!atlasFileArray[i].isDirectory()){
                atlasFilePath = atlasFileArray[i].path();
            }
        }
        assertThat(atlasFilePath, is(SAMPLE_ASSET_PATH));
    }

    @Test
    public void testLoadAll(){
        AssetManager assetManager = dummyRedrockInavaders.getAssetManager();
        // Before Loading, check is not loaded
        assertFalse(assetManager.isLoaded(SAMPLE_ASSET_PATH, TextureAtlas.class));

        // After Loading, check is loaded
        RedrockAssetLoader.loadAll(assetManager);
        assertTrue(assetManager.isLoaded(SAMPLE_ASSET_PATH, TextureAtlas.class));
    }

}
