package githubakers.snake.data.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xxz on 2017/3/7.
 * 这是一个典型的数据类模型，通常有n个储存数据的变量，然后每个变量对应一个set方法和一个get方法
 */

public class Position {
    private static ArrayList<Point> arrayList=new ArrayList<>();
    private static char direction='a';//a=left;d=right.....
    synchronized public static ArrayList getPosition(){
        return arrayList;
    }
    synchronized public static char getDirection(){
        return direction;
    }
    synchronized public static void setPosition(ArrayList<Point> a){
        arrayList=a;
    }
    synchronized public static void setDirection(char a){
        direction=a;
    }

}


