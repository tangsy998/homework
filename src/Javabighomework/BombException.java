package Javabighomework;

/**
 * Created by cloudadmin on 2017/6/20.
 */
public class BombException extends  Exception{
    public BombException(int a){
        if(a > 10){
            System.out.println("你标志的雷数超标了！");
        }
    }
}

class Judgement{
    public void MyJudgement(int a) throws BombException{
        if (a > 10){
            throw new BombException(a);
        }
    }
}
