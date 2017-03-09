package githubakers.snake.logic;

        import githubakers.snake.data.Position.FinalData;

        import java.awt.Point;
        import java.util.Random;

        import static githubakers.snake.data.Position.FinalData.WINDOW_SIZE;

public class Food {
    static Random random=new Random(47);
    public static Point getFood(){
        int x,y;
        x=random.nextInt(WINDOW_SIZE);
        x=(x/FinalData.INTERVAL)*FinalData.INTERVAL;
        y=random.nextInt(WINDOW_SIZE);
        y=(y/FinalData.INTERVAL)*FinalData.INTERVAL;
        return new Point(x,y);
    }

}

