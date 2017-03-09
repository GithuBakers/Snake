package githubakers.snake.logic;

import githubakers.snake.data.Position.FinalData;
import githubakers.snake.data.Position.Food;
import githubakers.snake.data.Position.Position;

import java.awt.Point;
import java.util.ArrayList;


public class Snake {
	private static final int HEAD = 0;//头固定的位置
	private static int x0 = 100;//头的初始横坐标
	private static int y0 = 100;//头的初始纵坐标
	public static Point food=new Point(40,40);//这个地方因为懒所以没有改掉，本来应该写成private的，然后增加一个get方法

	static ArrayList<Point> body =Position.getPosition();//访问数据
	
	public static void startgame(){
		body.add(new Point(x0, y0));
		body.add(new Point(x0,y0+FinalData.INTERVAL));
		body.add(new Point(x0,y0+2*FinalData.INTERVAL));
		body.add(new Point(x0,y0+3*FinalData.INTERVAL));
		body.add(new Point(x0,y0+4*FinalData.INTERVAL));
		Position.setPosition(body);//返回数据
	}
	
	static boolean judgeFood(Point food){
		boolean flag=false;
		if(body.get(HEAD).x == food.x&&body.get(HEAD).y == food.y){//如果与食物相遇
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
			food= Food.getFood();
		}else {
			body.remove(body.size() - 1);
		}
	    Position.setPosition(body);
	    return body;
    }

    public static ArrayList getLoc(){
		return Position.getPosition();
	}//这个方法是界面调用数据的途径，稍显多余，为了编码风格
}