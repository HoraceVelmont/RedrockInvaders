package redrock.invaders.test.gameData;

import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import redrock.invaders.game.gameData.UserData;
import redrock.invaders.test.DummyRedrockInavaders;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Velmont on 2017-07-08.
 */
public class UserDataTest {
    @Autowired
    private UserData userData;
    private HeadlessMini2DxGame testLauncher;

    @Before
    public void setUp() throws Exception{
        DummyRedrockInavaders dummyRedrockInavaders = new DummyRedrockInavaders();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(UserDataTest.class.getName());
        config.runGame = false;
        testLauncher = new HeadlessMini2DxGame(dummyRedrockInavaders, config);
        Mdx.di.scan(new String[]{"redrock.invaders.game.gameData", "redrock.invaders.game.model"});
    }

    @Test
    public void testDependencyInjection(){
        userData = Mdx.di.getBean(UserData.class);
        assertNotNull(userData.getPerson());
    }
}
