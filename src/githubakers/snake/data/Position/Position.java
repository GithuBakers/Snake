package githubakers.snake.data.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xxz on 2017/3/7.
 */

public class Position {
    private static ArrayList<Point> arrayList=new ArrayList<>();
    private static char direction;//a=left;d=right.....
    public static ArrayList getPosition(){
        return arrayList;
    }
    public static char getDirection(){
        return direction;
    }
    public static void setPosition(ArrayList<Point> a){
        arrayList=a;
    }
    public static void setDirection(char a){
        direction=a;
    }

}


