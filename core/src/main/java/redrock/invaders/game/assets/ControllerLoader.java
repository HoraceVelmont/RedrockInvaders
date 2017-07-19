package redrock.invaders.game.assets;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.Array;
import lombok.Getter;
import lombok.Setter;
import org.mini2Dx.core.di.annotation.Singleton;

@Singleton
public class ControllerLoader {
    @Getter
    private Controller controller;

    @Getter
    private ControllerAdapter controllerListener = new ControllerAdapter(){
        @Override
        public void connected(Controller c) {
            if (controller == null) {
                controller = c;
            }
        }
        @Override
        public void disconnected(Controller c) {
            if (controller == c) {
                controller = null;
            }
        }
    };

    public void loadController(){
        Array<Controller> controllers = Controllers.getControllers();
        if (controllers.size > 0) {
            controller = controllers.first();
        }
        Controllers.addListener(controllerListener);
        if(controller !=null)
            System.out.println("hey not null");
        else
            System.out.println("hey null");
    }
}
