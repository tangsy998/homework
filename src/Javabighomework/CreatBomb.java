package Javabighomework;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by cloudadmin on 2017/6/19.
 */
public abstract class CreatBomb {
    Stage Primarystage;
    Pane gridpane;
    public  abstract  void creatBomb (Pane girdpane, Button[][] buttons,Stage primarystage) throws Exception;
}
