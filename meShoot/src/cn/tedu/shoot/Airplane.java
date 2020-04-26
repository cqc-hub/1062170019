package cn.tedu.shoot;
import java.util.Random;
/** 灏忔晫鏈�: 鏄琛岀墿锛屼篃鏄晫浜� */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 3; //绉诲姩閫熷害
	/** 鏋勯�犳柟娉� */
	public Airplane(){
		image = ShootGame.airplane; //鍥剧墖
		width = image.getWidth();   //瀹�
		height = image.getHeight(); //楂�
		Random rand = new Random(); //闅忔満鏁板璞�
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0鍒�(绐楀彛瀹�-鏁屾満瀹�)涔嬮棿鐨勯殢鏈烘暟
		y = -this.height; //y:璐熺殑鏁屾満鐨勯珮
	}
	
	/** 閲嶅啓getScore()寰楀垎 */
	public int getScore(){
		return 5; //鎵撴帀涓�涓晫鏈哄緱5鍒�
	}
	
	/** 閲嶅啓step()璧颁竴姝� */
	public void step(){
		int h=ShootGame.hard;
		if(h<=1)
			y+=speed;
		else{
			y=speed+y+2;
		}
	}
	
	/** 閲嶅啓outOfBounds()妫�鏌ヨ秺鐣� */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT; //鏁屾満鐨剏>=绐楀彛鐨勯珮锛屽嵆涓鸿秺鐣屼簡
	}
	
}


















