package Javabighomework;

import javafx.scene.control.*;

import java.util.Scanner;


/**
 * Created by cloudadmin on 2017/6/21.
 */
public class SurroundBombsnumber extends Main{
    public  void Bombsnumber(Button[][] buttons)throws Exception {
        java.io.File file = new java.io.File("Data.txt");                           //文件IO
        java.io.PrintWriter input = new java.io.PrintWriter(file);
        int n = 0;
        Judgement judgement = new Judgement();
        int[][] Number = new int [10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int count = 0;
                if (buttons[i][j].getText().equals("雷")){
                    continue;
                }

                if ((i - 1) >= 0 && (j - 1) >= 0){
                    if(buttons[i-1][j-1].getText().equals("雷")){
                        count++;
                    }
                }

                if ((j - 1) >= 0) {
                    if (buttons[i][j - 1].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((i + 1) < 10 && (j - 1) >= 0) {
                    if (buttons[i + 1][j - 1].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((i + 1) < 10 ) {
                    if (buttons[i + 1][j].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((i + 1) < 10 && (j + 1) < 10) {
                    if (buttons[i + 1][j + 1].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((j +1) < 10) {
                    if (buttons[i][j + 1].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((i - 1) >= 0 && (j + 1) < 10) {
                    if (buttons[i - 1][j + 1].getText().equals("雷")) {
                        count++;
                    }
                }

                if ((i - 1) >= 0) {
                    if (buttons[i - 1][j].getText().equals("雷")) {
                        count++;
                    }
                }

                Number[i][j] = count;
                input.print(Number[i][j]);

                final int number = count;
                final int I = i;
                final  int J = j;
                final int  l = 1;
                buttons[i][j].setOnAction(event -> {
                    buttons[I][J].setText("雷");
                    input.print(buttons[I][J].getText());
                    buttons[I][J].setOnAction(event1 -> {
                        buttons[I][J].setText(Integer.toString(number));
                        int k = 0;
                        if( buttons[I][J].getText().equals("0")){
                            while (I + (l*k) < 10){
                                k++;
                                if (I + (l*k) == 10){
                                    k = 0;
                                    break;
                                }
                                buttons[I+(l*k)][J].setText(Integer.toString(Number[I+(l*k)][J]));
                                if (Number[I+(l*k)][J] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (I -(l*k) > -1 ){
                                k++;
                                if (I -(l*k) == -1){
                                    k = 0;
                                    break;
                                }
                                buttons[I-(l*k)][J].setText(Integer.toString(Number[I-(l*k)][J]));
                                if (Number[I-(l*k)][J] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J -(l*k) > -1 ){
                                k++;
                                if (J -(l*k) == -1){
                                    k = 0;
                                    break;
                                }
                                buttons[I][J-(l*k)].setText(Integer.toString(Number[I][J-(l*k)]));
                                if (Number[I][J-(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J +(l*k) < 10 ){
                                k++;
                                if (J +(l*k) == 10){
                                    k = 0;
                                    break;
                                }
                                buttons[I][J+(l*k)].setText(Integer.toString(Number[I][J+(l*k)]));
                                if (Number[I][J+(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J -(l*k) > -1 && I -(l*k) > -1 ){
                                k++;
                                if (J - (l*k) == -1 || I -(l*k) == -1 ){
                                    k = 0;
                                    break;
                                }
                                buttons[I -(l*k)][J-(l*k)].setText(Integer.toString(Number[I -(l*k)][J-(l*k)]));
                                if (Number[I -(l*k)][J-(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J +(l*k) < 10 && I +(l*k) < 10 ){
                                k++;
                                if (J +(l*k) == 10 || I + (l*k) ==10 ){
                                    k = 0;
                                    break;
                                }
                                buttons[I +(l*k)][J+(l*k)].setText(Integer.toString(Number[I +(l*k)][J+(l*k)]));
                                if (Number[I +(l*k)][J+(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J -(l*k) > -1 && I +(l*k) < 10 ){
                                k++;
                                if (J - (l*k) == -1 || I + (l*k) == 10 ){
                                    k = 0;
                                    break;
                                }
                                buttons[I +(l*k)][J-(l*k)].setText(Integer.toString(Number[I +(l*k)][J-(l*k)]));
                                if (Number[I +(l*k)][J-(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                            while (J +(l*k) < 10 && I -(l*k) > -1 ){
                                k++;
                                if (J +(l*k) == 10 || I -(l*k) == -1 ){
                                    k = 0;
                                    break;
                                }
                                buttons[I -(l*k)][J+(l*k)].setText(Integer.toString(Number[I -(l*k)][J+(l*k)]));
                                if (Number[I -(l*k)][J+(l*k)] != 0){
                                    k = 0;
                                    break;
                                }
                            }
                        }
                    });
                });
            }
        }
        Scanner output = new Scanner(file);
        while(output.hasNext()){
            n++;
            String out = output.next();
            System.out.println( out + " ");
        }
        output.close();
        try {                                                                                          //自定义异常
            judgement.MyJudgement(n);
        } catch (BombException e) {
        }
    }
}
