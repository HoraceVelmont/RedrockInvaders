package redrock.invaders.game.android;

import org.mini2Dx.android.AndroidMini2DxConfig;

import com.badlogic.gdx.backends.android.AndroidMini2DxGame;

import android.os.Bundle;

import redrock.invaders.game.RedrockInavaders;

public class AndroidLauncher extends AndroidMini2DxGame {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidMini2DxConfig config = new AndroidMini2DxConfig(RedrockInavaders.GAME_IDENTIFIER);
        initialize(new RedrockInavaders(), config);
    }
}
