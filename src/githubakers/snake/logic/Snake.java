package githubakers.snake.logic;

import githubakers.snake.data.Position.Position;

import java.awt.Point;
import java.util.ArrayList;


class Snake {
	public static final int MAXLENGTH = 30;//身体的最长长度，达到之后可以算通关
	public static final int HEAD = 0;//头固定的位置
	public int x0 = 100;//头的初始横坐标
	public int y0 = 100;//头的初始纵坐标
	public int length = 1;//长度
	private int vx = 5;//爬行速度
	private int vy = 5;
    ;
	ArrayList<Point> body = new ArrayList<Point>();//存放身体的坐标
	
	public void startgame(){
		body.add(new Point(x, y));//初始化蛇头的坐标
	}
	
	public void getfood(){
		Food food = new Food();//新建一个食物出来
		if(body.get(HEAD) == food.foodlocation){//如果与食物相遇
			length = length + 1;//吃了食物身体长度加一
			body.add(HEAD, food.foodlocation);//原先食物的位置变成了头的位置			
		}
	}

	public void move(){
	    Point preloction = body.get(HEAD);
	    switch(Position.getDirection()){
            case 'a':
                preloction.x =preloction.x  - vx;
                break;
            case 'w':
                preloction.y =preloction.y  + vy;
                break;
            case 's':
                preloction.y = preloction.y - vy;
                break;
            case 'd':
                preloction.x = preloction.x + vx;
                break;
        }
        Point newlocation = preloction;
	    body.add(HEAD,newlocation);
	    body.remove(body.size()-1);

    }
}