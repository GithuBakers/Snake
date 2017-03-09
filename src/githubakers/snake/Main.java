package githubakers.snake;

import githubakers.snake.logic.Snake;
import githubakers.snake.view.SnakeFrame;

import javax.swing.*;

/**
 * Created by xuxiangzhe on 2017/3/9.
 */
public class Main {
    public static void main(String[] args) {
        Snake.startgame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SnakeFrame bakers=new SnakeFrame();
            }
        });
    }
}
