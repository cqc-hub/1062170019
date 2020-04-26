package cn.tedu.shoot;

import java.util.Random;

public class BigPlane extends FlyingObject implements Enemy{ 
	private int speed = 4; //移动速度
	private int life; 
	/** 构造方法 */
	public BigPlane(){
		life=3; 
		image = ShootGame.bigplane; //图片
		width = image.getWidth();   //宽
		height = image.getHeight(); //高
		Random rand = new Random(); //随机数对象
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0到(窗口宽-敌机宽)之间的随机数
		y = -this.height; //y:负的敌机的高
	}
	
	/** 重写getScore()得分 */
	public int getScore(){
		return 40; //打掉一个敌机得5分
	}
	/** 大敌机减命*/
	public void subtractLife(){
		life--; //命数减1
	}
	
	/** 重写step()走一步 */
	public void step(){
		int h=ShootGame.hard;
		if(h<=1)
			y+=speed;
		else{
			y=speed+y+2;
		}
	}
	
	/** 重写outOfBounds()检查越界 */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT; //敌机的y>=窗口的高，即为越界了
	}
	
	public boolean live(){
		return life==0; 
	}
}
