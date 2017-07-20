package Javabighomework;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.awt.*;
import javafx.scene.Scene.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.concurrent.Worker.State.RUNNING;

/**
 * Created by cloudadmin on 2017/6/10.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RandomBomb randomBomb = new RandomBomb();
        GridPane gridpane = new GridPane();
        Scene scene = new Scene(gridpane,700,500);
        primaryStage.setScene(scene);

        Button[][] buttons = new Button[10][10];                                          //对象数组
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(50,50);
                gridpane.add(buttons[i][j],i,j);
            }
        }
        TextField showtime = new TextField();                                             // 计时器
        showtime.setPrefSize(60,50);
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            int runTimes = 0;
            @Override
            public void run() {
                runTimes++;
               showtime.setText(Integer.toString(runTimes));
                }

        }, 0,1000);
        Label notifiction1 = new Label("鼠标单击表置地雷");
        Label notifiction2 = new Label("鼠标双击查看情况");
        notifiction1.setPrefSize(100,20);
        notifiction2.setPrefSize(100,20);
        gridpane.add(notifiction1,10 ,1);
        gridpane.add(notifiction2,10 ,2);



        gridpane.add(showtime,10,5);

        randomBomb.creatBomb(gridpane,buttons,primaryStage);                               //调用抽象类方法

        SurroundBombsnumber surroundBombsnumber = new SurroundBombsnumber();              //调用子类方法
        surroundBombsnumber.Bombsnumber(buttons);

        randomBomb.hidebomb(buttons);                                                        //调用接口方法

        primaryStage.show();
    }
}