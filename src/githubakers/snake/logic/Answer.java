package githubakers.snake.logic;

import githubakers.snake.data.Position.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xuxiangzhe on 2017/3/9.
 */
public class Answer {
    private ArrayList<Point> arrayList=new ArrayList<>();
    private static int HEIGHT=10;
    public static ArrayList<Point> refreshPosition(char direction){
        ArrayList<Point> former= Position.getPosition();
        Position.setDirection(direction);
        Point head=former.get(0);
        Point tail=former.get(former.size()-1);
        former.remove(tail);
        switch(direction){
            case 'a':head.x-=HEIGHT;break;
            case 's':head.y+=HEIGHT;break;
            case 'd':head.x+=HEIGHT;break;
            case 'w':head.y-=HEIGHT;break;

        }
        Position.setPosition(former);
        return former;

    }
}
