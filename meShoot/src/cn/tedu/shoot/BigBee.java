package cn.tedu.shoot;

import java.util.Random;

public class BigBee extends FlyingObject implements Award{ 
	private int speed = 5; //移动速度
	private int life; 
	private int awardType;  //奖励的类型
	private int xSpeed = 1; //x坐标移动速度
	private int ySpeed = 2; //y坐标移动速度
	/** 构造方法 */
	public BigBee(){
		life=5; 
		image = ShootGame.bigbee; //图片
		width = image.getWidth();   //宽
		height = image.getHeight(); //高
		Random rand = new Random(); //随机数对象
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0到(窗口宽-敌机宽)之间的随机数
		y = -this.height; //y:负的敌机的高
		awardType = rand.nextInt(2); //0到1之间的随机数
	}
	public int getType(){
		return awardType; //返回奖励类型
	}
	
	/** 大敌机减命*/
	public void subtractLife(){
		life--; //命数减1
	}
	
	/** 重写step()走一步 */
	public void step(){
		x+=xSpeed; //x+(向左或向右)
		y+=ySpeed; //y+(向下)
		if(this.x>=ShootGame.WIDTH-this.width){ //若蜜蜂的x>=窗口宽-蜜蜂宽，意味着到最右边了，则+(-1)，即向左
			xSpeed=-1;
		}
		if(this.x<=0){ //若蜜蜂的x<=0，意味着到最左边了，则+(1)，即向右
			xSpeed=1;
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
