package githubakers.snake.logic;

import githubakers.snake.data.Position.FinalData;
import githubakers.snake.data.Position.Position;

import java.awt.Point;
import java.util.ArrayList;

import static githubakers.snake.logic.Food.getFood;


public class Snake {
//	public static final int MAXLENGTH = 30;//身体的最长长度，达到之后可以算通关
	public static final int HEAD = 0;//头固定的位置
	public static int x0 = 100;//头的初始横坐标
	public static int y0 = 100;//头的初始纵坐标
//	public int length = 1;//长度
//	private int vx = 5;//爬行速度
//	private int vy = 5;
	public static Point food=new Point(40,40);

	static ArrayList<Point> body =Position.getPosition();//存放身体的坐标
	
	public static void startgame(){
		body.add(new Point(x0, y0));//初始化蛇头的坐标
		body.add(new Point(x0,y0+FinalData.INTERVAL));
		body.add(new Point(x0,y0+2*FinalData.INTERVAL));
		body.add(new Point(x0,y0+3*FinalData.INTERVAL));
		body.add(new Point(x0,y0+4*FinalData.INTERVAL));
		Position.setPosition(body);
	}
	
	static boolean judgeFood(Point food){
		boolean flag=false;
		if(body.get(HEAD).x == food.x&&body.get(HEAD).y == food.y){//如果与食物相遇
//			int length=body.size();
//			length = length + 1;//吃了食物身体长度加一
//			body.add(HEAD, food);//原先食物的位置变成了头的位置
			flag=true;
		}
		return flag;
	}

	public static ArrayList move(){
		Point preLocation=body.get(HEAD);
	    Point curLocation=new Point();
	    curLocation.x=preLocation.x;
	    curLocation.y=preLocation.y;
	    switch(Position.getDirection()){
            case 'a':
                curLocation.x-= FinalData.INTERVAL;
                break;
            case 'w':
                curLocation.y -= FinalData.INTERVAL;
                break;
            case 's':
                curLocation.y += FinalData.INTERVAL;
                break;
            case 'd':
                curLocation.x += FinalData.INTERVAL;
                break;
        }
        if(curLocation.x>FinalData.WINDOW_SIZE){
	    	curLocation.x-=FinalData.WINDOW_SIZE;
		}else if(curLocation.x<0){
        	curLocation.x+=FinalData.WINDOW_SIZE;
		}

		if(curLocation.y>FinalData.WINDOW_SIZE){
			curLocation.y-=FinalData.WINDOW_SIZE;
		}else if(curLocation.y<0){
			curLocation.y+=FinalData.WINDOW_SIZE;
		}

		body.add(HEAD,curLocation);
		if(judgeFood(food)){
			food=Food.getFood();
		}else {
			body.remove(body.size() - 1);
		}






	    Position.setPosition(body);
	    return body;
    }

    public static ArrayList getLoc(){
		return Position.getPosition();
	}
}