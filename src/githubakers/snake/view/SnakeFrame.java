package githubakers.snake.view;

import githubakers.snake.data.Position.FinalData;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 15852 on 2017/3/9 0009.
 */
public class SnakeFrame extends JFrame {

    public SnakeFrame(){

        setSize(FinalData.WINDOW_SIZE,FinalData.WINDOW_SIZE);
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //窗口大小拒绝修改
        setResizable(false);

        //设置窗口在屏幕中间
        setLocationRelativeTo(null);

        //暂定背景为白
        setBackground(Color.white);
    }


}
