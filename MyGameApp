import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.entity.components.ViewComponent;
import com.almasb.fxgl.entity.factories.EntityFactory;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.*;

public class MyGameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("My Game");
        settings.setVersion("0.1");
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new GameEntityFactory());

        // Spawn players and cards
        spawn("player", 100, 100);
        spawn("card", 200, 200);
    }

    @Override
    protected void initInput() {
        // Initialize input controls here
    }

    @Override
    protected void initUI() {
        // Initialize UI elements here
    }

    public static void main(String[] args) {
        launch(args);
    }
}