package githubakers.snake.view;

import githubakers.snake.data.Position.FinalData;
import githubakers.snake.logic.Answer;
import githubakers.snake.logic.Judge;
import githubakers.snake.logic.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuxiangzhe on 2017/3/9.
 * 表示界面代码根本就不知道怎样写，就是到处打补丁，小白形成自己的编程风格就好啦
 */
public class SnakePanel extends JPanel implements Runnable,KeyListener{
    Thread t=new Thread(this);
    ArrayList<Point> snake;

    public SnakePanel(){

        t.start();
        setFocusable(true);
        addKeyListener(this);


    }
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            snake=Snake.move();
            this.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        snake=Snake.getLoc();
        g=(Graphics2D)g;
        g.setColor(Color.RED);
        g.fillRect(Snake.food.x,Snake.food.y,FinalData.INTERVAL-5,FinalData.INTERVAL-5);
        g.setColor(Color.BLACK);
        for(Point p:snake){
            g.fillRect(p.x,p.y, FinalData.INTERVAL-5,FinalData.INTERVAL-5);
        }
        if(Judge.gameGoOn()){

        }else {
            t.interrupt();
            System.out.println("there");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showConfirmDialog(SnakePanel.this,"GAME OVER",null,JOptionPane.ERROR_MESSAGE,JOptionPane.YES_OPTION);

                }
            });

        }

    }
    @Override
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent event) {

        Answer.refreshPosition(event.getKeyChar());
        repaint();

        if(Judge.gameGoOn()){

        }else {
            t.interrupt();
            JOptionPane.showConfirmDialog(this,"GAME OVER",null,JOptionPane.ERROR_MESSAGE,JOptionPane.YES_OPTION);
            System.exit(0);
        }
    }

}
