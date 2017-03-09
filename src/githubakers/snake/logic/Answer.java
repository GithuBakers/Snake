package githubakers.snake.logic;

import githubakers.snake.data.Position.FinalData;
import githubakers.snake.data.Position.Food;
import githubakers.snake.data.Position.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static githubakers.snake.data.Position.FinalData.INTERVAL;

/**
 * Created by xuxiangzhe on 2017/3/9.
 */
public class Answer {
    private static boolean flag=true;
    public static ArrayList<Point> refreshPosition(char direction){
        ArrayList<Point> former= Position.getPosition();//这是对数据的调用
        Position.setDirection(direction);//这里将从界面传来的方向传递给数据层
/*****************************************************************************/
        Point preHead=former.get(0);
        Point head=new Point();
        head.x=preHead.x;
        head.y=preHead.y;
        Point tail=former.get(former.size()-1);
        flag=true;
        switch(direction){
            case 'a':head.x-= INTERVAL;break;
            case 's':head.y+= INTERVAL;break;
            case 'd':head.x+= INTERVAL;break;
            case 'w':head.y-= INTERVAL;break;
            default:
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showConfirmDialog(null,"La Ji Bay Mini",null,JOptionPane.ERROR_MESSAGE,JOptionPane.YES_OPTION);
                        System.exit(0);
                    }
                });
                flag=false;
        }
        if(flag) {


            if (head.x > FinalData.WINDOW_SIZE) {
                head.x -= FinalData.WINDOW_SIZE;
            } else if (head.x < 0) {
                head.x += FinalData.WINDOW_SIZE;
            }

            if (head.y > FinalData.WINDOW_SIZE) {
                head.y -= FinalData.WINDOW_SIZE;
            } else if (head.y < 0) {
                head.y += FinalData.WINDOW_SIZE;
            }
            former.add(0, head);
            if (Snake.judgeFood(Snake.food)) {
                Snake.food = Food.getFood();
            } else {
                former.remove(tail);
            }
/*********************************************************************/
            Position.setPosition(former);//写入数据
            Position.setDirection(direction);//写入数据
        }



        return former;//返回给界面

    }
}
