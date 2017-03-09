package githubakers.snake.data.Position;

        import githubakers.snake.data.Position.FinalData;

        import java.awt.Point;
        import java.util.Random;

        import static githubakers.snake.data.Position.FinalData.WINDOW_SIZE;
//我觉得这个类应该属于数据层，因为只生成数据，没有数据处理

public class Food {
    static Random random=new Random();
    public static Point getFood(){
        int x,y;
        x=random.nextInt(WINDOW_SIZE);
        x=(x/FinalData.INTERVAL)*FinalData.INTERVAL;
        y=random.nextInt(WINDOW_SIZE);
        y=(y/FinalData.INTERVAL)*FinalData.INTERVAL;
        return new Point(x,y);
    }

}

