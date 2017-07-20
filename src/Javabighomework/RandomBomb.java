package Javabighomework;

import com.sun.deploy.util.BlackList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by cloudadmin on 2017/6/19.
 */
public class RandomBomb extends CreatBomb {

    Stage primarystage;
    Button[] buttons;
    Pane gridpane;
    public void hidebomb(Button[][] buttons ){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ( buttons[i][j].getText().equals("雷")){
                    buttons[i][j].setText("");
                }
            }
        }

    }

    public void creatBomb (Pane girdpane, Button[][] buttons,Stage primarystage) throws Exception{
        java.io.File file = new java.io.File("Cheat.txt");
        java.io.PrintWriter input = new java.io.PrintWriter(file);
        int max = 9;
        int min = 0;
        int j = 0;
        int X_location;
        int Y_location;
        GameOver gameOver = new GameOver();
        for (int i = 0; i < 10; i++) {
            int out = 1;
            int[] countx = new int[10];
            int[] county = new int[10];
            for ( int k = 0; k < 10; k++) {
                countx[k] = -1;
                county[k] = -1;
            }

            while(out <= 1 ){
                X_location = (int)(Math.floor(Math.random()*(max - min + 1)) + min);
                Y_location = (int)(Math.floor(Math.random()*(max - min + 1)) + min);
                for ( j = 0; j < 10; j++) {
                    if (j != 9) {
                        if (X_location == countx[j] && Y_location == county[j]) {
                            X_location = (int) (Math.floor(Math.random() * (max - min + 1)) + min);
                            Y_location = (int) (Math.floor(Math.random() * (max - min + 1)) + min);
                            j = 0;
                        }
                    }
                    else {
                            countx[i] = X_location;
                            county[i] = Y_location;
                            out++;

                    }
                }
            }
            input.print(countx[i]);
            input.print(" ");
            input.println(county[i]);
            buttons[countx[i]][county[i]].setText("雷");
            int finalI = i;

//            buttons[countx[finalI]][county[finalI]].setOnMouseClicked(event -> {
//                if (event.isSecondaryButtonDown() ){
//                    buttons[countx[finalI]][county[finalI]].setText("雷");
//                }
//                if(event.isPrimaryButtonDown()){
//                    gameOver.Boom(primarystage);
//                }
//            });

            buttons[countx[finalI]][county[finalI]].setOnAction(event1 -> {
                buttons[countx[finalI]][county[finalI]].setText("雷");
                buttons[countx[finalI]][county[finalI]].setOnAction(event -> {
                    gameOver.Boom(primarystage);
                });
            });

        }
        input.close();

    }
}
