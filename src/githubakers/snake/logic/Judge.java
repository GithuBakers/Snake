package githubakers.snake.logic;

import githubakers.snake.data.Position.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xuxiangzhe on 2017/3/9.
 */
public class Judge {
    public static boolean gameGoOn(){
        ArrayList<Point> source= Position.getPosition();//访问数据层
        Point head=source.get(0);
        Boolean flag=true;
        source.remove(0);
        for(Point p:source){
            if(p.x==head.x&&p.y==head.y){
                flag=false;
                break;
            }
        }
        source.add(0,head);
        return flag;
    }
}
