package githubakers.snake.logic;

import githubakers.snake.data.Position.FinalData;
import githubakers.snake.data.Position.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by xuxiangzhe on 2017/3/9.
 */
public class Answer {
    private ArrayList<Point> arrayList=new ArrayList<>();
    private static int HEIGHT= FinalData.INTERVAL;
    public static ArrayList<Point> refreshPosition(char direction){
        ArrayList<Point> former= Position.getPosition();
        Position.setDirection(direction);
        Point preHead=former.get(0);
        Point head=new Point();
        head.x=preHead.x;
        head.y=preHead.y;
        Point tail=former.get(former.size()-1);
        former.remove(tail);
        switch(direction){
            case 'a':head.x-=HEIGHT;break;
            case 's':head.y+=HEIGHT;break;
            case 'd':head.x+=HEIGHT;break;
            case 'w':head.y-=HEIGHT;break;
            default:
                JOptionPane.showConfirmDialog(null,"La Ji Bay Mini");

        }
        if(head.x>FinalData.WINDOW_SIZE){
            head.x-=FinalData.WINDOW_SIZE;
        }else if(head.x<0){
            head.x+=FinalData.WINDOW_SIZE;
        }

        if(head.y>FinalData.WINDOW_SIZE){
            head.y-=FinalData.WINDOW_SIZE;
        }else if(head.y<0){
            head.y+=FinalData.WINDOW_SIZE;
        }
        if(Snake.judgeFood(Snake.food)){
            Snake.food=Food.getFood();
        }


        former.add(0,head);
        Position.setPosition(former);
        Position.setDirection(direction);
        return former;

    }
}
