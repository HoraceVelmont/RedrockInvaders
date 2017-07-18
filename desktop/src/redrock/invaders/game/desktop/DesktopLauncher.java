package redrock.invaders.game.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import redrock.invaders.game.RedrockInavaders;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(RedrockInavaders.GAME_IDENTIFIER);
		config.title = "Redrock Inavaders";
		config.width = RedrockInavaders.GAME_WIDTH;
		config.height = RedrockInavaders.GAME_HEIGHT;
		config.vSyncEnabled = true;
		new DesktopMini2DxGame(new RedrockInavaders(), config);
	}
}
