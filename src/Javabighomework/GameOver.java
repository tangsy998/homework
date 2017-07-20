package Javabighomework;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by cloudadmin on 2017/6/19.
 */
public class GameOver implements Bomb {
    Stage primarystage;
    @Override
    public void Boom(Stage primarystage) {
        primarystage.close();
    }
}
