package githubakers.snake.logic;

        import java.awt.Point;

public class Food {
    public int dx = (int)(300*Math.random());//横坐标
    public int dy = (int)(400*Math.random());//纵坐标
    public Point foodlocation = new Point(dx,dy);//食物的坐标

}

