package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

//主程序类
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;  //窗口的宽
	public static final int HEIGHT = 654; //窗口的高
	
	public static BufferedImage background; //背景图
	public static BufferedImage start;		//启动图
	public static BufferedImage pause;		//暂停图
	public static BufferedImage gameover;	//游戏结束图
	public static BufferedImage airplane;	//小敌机
	public static BufferedImage bigplane;
	public static BufferedImage bigbee;
	public static BufferedImage bee;		//小蜜蜂
	public static BufferedImage bullet;		//子弹
	public static BufferedImage hero0;  	//英雄机0
	public static BufferedImage hero1;		//英雄机1
	public static int hard=1;
	static{ //初始化静态资源(图片)
		try{
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bigplane = ImageIO.read(ShootGame.class.getResource("bigplane0.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bigbee = ImageIO.read(ShootGame.class.getResource("bigbee0.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static final int START = 0;     //启动状态
	public static final int RUNNING = 1;   //运行状态
	public static final int PAUSE = 2;     //暂停状态
	public static final int GAME_OVER = 3; //游戏结束状态
	private int state = START; //当前状态(默认为启动状态)
	private Hero hero = new Hero(); //一个英雄机
	private FlyingObject[] flyings = {}; //一堆敌人(敌机+小蜜蜂)
	private Bullet[] bullets = {}; //一堆子弹
	public static  int Enemyint=40;//敌人出现间隔
	
	
	/** 创建敌人(敌机+小蜜蜂)对象 */
	public FlyingObject nextOne(){
		Random rand = new Random(); //随机数对象
		int type = rand.nextInt(20); //0到19之间的随机数
		if(type<4){ //0到3时返回小蜜蜂
			return new Bee();
		}else if(type<6){ //4到19时返回敌机
			return new BigPlane();
		}else if(type<9){ //4到19时返回敌机
			return new BigBee();
		}
		else{ //4到19时返回敌机
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0; //敌人入场计数
	/** 敌人(敌机+小蜜蜂)入场 */
	public void enterAction(){ //10毫秒走一次
		flyEnteredIndex++; //每10个毫秒增1
		if(flyEnteredIndex%Enemyint==0){ //每400(40*10)毫秒走一次
			FlyingObject obj = nextOne(); //获取敌人(敌机+小蜜蜂)对象
			flyings = Arrays.copyOf(flyings,flyings.length+1); //扩容
			flyings[flyings.length-1] = obj; //将敌人对象添加到flyings中的最后一个元素位置
		}
	}
	
	/** 飞行物走一步 */
	public void stepAction(){ //10毫秒走一次
		hero.step(); //英雄机走一步
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			flyings[i].step(); //敌人走一步
		}
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			bullets[i].step(); //子弹走一步
		}
	}
	
	int shootIndex = 0; //射击计数
	/** 子弹入场(英雄机发射子弹) */
	public void shootAction(){ //10毫秒走一次
		shootIndex++; //每10毫秒增1
		if(shootIndex%30==0){ //每300(30*10)毫秒走一次
			Bullet[] bs = hero.shoot(); //获取子弹对象(英雄机发射出来的)
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length); //扩容(bs有几个元素就扩大几个容量)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //数组的追加
		}
	}
	
	/** 删除越界的飞行物(敌机+小蜜蜂+子弹) */
	public void outOfBoundsAction(){ //10毫秒走一次
		int index = 0; //1)不越界敌人数组下标  2)不越界敌人个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; //不越界敌人数组
		for(int i=0;i<flyings.length;i++){ //遍历敌人数组
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(!f.outOfBounds()){ //不越界
				flyingLives[index] = f; //将不越界敌人对象添加到不越界敌人数组中
				index++; //1)不越界敌人数组下标增一 2)不越界敌人个数增一
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); //将不越界敌人数组复制到flyings中，flyings的长度为index(不越界敌人个数)
		
		index = 0; //1)不越界子弹数组下标归零 2)不越界子弹个数归零
		Bullet[] bulletLives = new Bullet[bullets.length]; //不越界子弹数组
		for(int i=0;i<bullets.length;i++){ //遍历子弹数组
			Bullet b = bullets[i]; //获取每一个子弹
			if(!b.outOfBounds()){ //不越界
				bulletLives[index] = b; //将不越界子弹对象添加到不越界子弹数组中
				index++; //1)不越界子弹数组下标增一 2)不越界子弹个数增一
			}
		}
		bullets = Arrays.copyOf(bulletLives,index); //将不越界子弹数组复制到bullets中，bullets的长度为index(不越界子弹个数)
		
	}
	
	/** 所有子弹与所有敌人(敌机+小蜜蜂)的碰撞 */
	public void bangAction(){ //10毫秒走一次
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i]; //获取每一个子弹
			bang(b); //1个子弹与所有敌人的碰撞
		}
	}
	
	int oldscore = 0; //玩家得分
	int score = 0;
	/** 一个子弹与所有敌人(敌机+小蜜蜂)的碰撞 */
	public void bang(Bullet b){
		int index = -1; //被撞敌人的下标
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(f.shootBy(b)){ //撞上了
				index = i; //记录被撞敌人的下标
				break; //其余的敌人不再参与比较了
			}
		}
		
		
		int index2 = -1; //被撞子弹的下标
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b1 = bullets[i]; //获取每一个子弹
			if(b1.shootBy(b)){ //撞上了
				index2 = i; //记录被撞子弹的下标
				break; //其余的子弹不再参与比较了
			}
		}
		
		if(index!=-1){ //撞上了
			FlyingObject one = flyings[index]; //获取被撞的敌人对象
			if(one instanceof Airplane){ //被撞对象是敌人
				Enemy e = (Enemy)one; //将被撞对象强转为敌人类型
				score += e.getScore(); //玩家得分
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//缩容(去掉最后一个元素，即被撞的敌人对象)
				flyings = Arrays.copyOf(flyings,flyings.length-1);
			}
			if(one instanceof BigPlane){ //被撞对象是敌人
				BigPlane e = (BigPlane)one; //将被撞对象强转为敌人类型
				e.subtractLife();
				
				if(e.live()){
					//将被撞的敌人对象与数组中的最后一个元素交换
					FlyingObject t = flyings[index];
					flyings[index] = flyings[flyings.length-1];
					flyings[flyings.length-1] = t;
					//缩容(去掉最后一个元素，即被撞的敌人对象)
					flyings = Arrays.copyOf(flyings,flyings.length-1);
					score += e.getScore(); //玩家得分
				}
				
			}
			if(one instanceof Bee){ //被撞对象是奖励
				Award a = (Award)one; //将被撞对象强转为奖励类型
				int type = a.getType(); //获取奖励类型
				switch(type){ //根据奖励类型来获取不同的奖励
				case Award.DOUBLE_FIRE:   //若奖励类型为火力
					hero.addDoubleFire(); //则英雄机增火力
					break;
				case Award.LIFE:    //若奖励类型为命
					hero.addLife2(); //则英雄机增命
					break;
				}
				//将被撞的敌人对象与数组中的最后一个元素交换
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//缩容(去掉最后一个元素，即被撞的敌人对象)
				flyings = Arrays.copyOf(flyings,flyings.length-1);
			}
			if(one instanceof BigBee){ //被撞对象是奖励
				BigBee a = (BigBee)one; //将被撞对象强转为奖励类型
				a.subtractLife();
				
				if(a.live()){
					int type = a.getType(); //获取奖励类型
					switch(type){ //根据奖励类型来获取不同的奖励
					case Award.DOUBLE_FIRE:   //若奖励类型为火力
						hero.addDoubleFire(); //则英雄机增火力
						break;
					case Award.LIFE:    //若奖励类型为命
						hero.addLife2(); //则英雄机增命
						break;
					}
					//将被撞的敌人对象与数组中的最后一个元素交换
					FlyingObject t = flyings[index];
					flyings[index] = flyings[flyings.length-1];
					flyings[flyings.length-1] = t;
					//缩容(去掉最后一个元素，即被撞的敌人对象)
					flyings = Arrays.copyOf(flyings,flyings.length-1);
				}
				
			}

			Bullet b2 = bullets[index2];
			bullets[index2] = bullets[bullets.length-1];
			bullets[bullets.length-1] = b2;
			//缩容(去掉最后一个元素，即被撞的敌人对象)
			bullets = Arrays.copyOf(bullets,bullets.length-1);
			
			if(Enemyint>20){
				if(score-oldscore>100){
					oldscore=score;
					Enemyint=Enemyint-10;
					hard++;
					
				}
			}
			
		}
	}
	
	/** 英雄机与敌人(敌机+小蜜蜂)的碰撞 */
	public void hitAction(){ //10毫秒走一次
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(hero.hit(f)){ //撞上了
				hero.subtractLife(); //英雄机减命
				hero.clearDoubleFire(); //英雄机清空火力值
				//将被撞的敌人对象与数组中的最后一个元素交换
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//缩容(去掉最后一个元素，即被撞的敌人对象)
				flyings = Arrays.copyOf(flyings,flyings.length-1);
			}
		}
	}
	
	/** 检测游戏结束 */
	public void checkGameOverAction(){ //10毫秒走一次
		if(hero.getLife()<=0){ //游戏结束了
			state=GAME_OVER;   //修改当前状态为游戏结束状态
		}
	}
	
	/** 启动程序的执行 */
	public void action(){
		MouseAdapter l = new MouseAdapter(){ //创建侦听器对象
			/** 重写mouseMoved()鼠标移动 */
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){ //运行状态时执行
					int x = e.getX(); //获取鼠标的x坐标
					int y = e.getY(); //获取鼠标的y坐标
					hero.moveTo(x, y); //英雄机随着鼠标移动
				}
			}
			/** 重写mouseClicked()鼠标点击 */
			public void mouseClicked(MouseEvent e){
				switch(state){ //根据当前状态做不同的处理
				case START:        //启动状态时
					state=RUNNING; //修改为运行状态
					break;
				case GAME_OVER:  //游戏结束状态时
					score = 0; //清理现场
					hero = new Hero();
					hard=1;
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state=START; //修改为启动状态
					break;
				}
			}
			/** 重写mouseExited()鼠标移出 */
			public void mouseExited(MouseEvent e){
				if(state==RUNNING){ //运行状态时
					state=PAUSE;    //修改为暂停状态
				}
			}
			/** 重写mouseEntered()鼠标移入 */
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE){  //暂停状态时
					state=RUNNING; //修改为运行状态
				}
			}
		};
		this.addMouseListener(l); //处理鼠标操作事件
		this.addMouseMotionListener(l); //处理鼠标滑动事件
		
		Timer timer = new Timer(); //定时器对象
		int intervel = 10; //时间间隔(以毫秒为单位)
		timer.schedule(new TimerTask(){
			public void run(){ //每10毫秒走一次--定时干的那个事
				if(state==RUNNING){ //运行状态时执行
					enterAction(); //敌人(敌机+小蜜蜂)入场
					stepAction();  //飞行物走一步
					shootAction(); //子弹入场(英雄机发射子弹)
					outOfBoundsAction(); //删除越界的飞行物
					bangAction();  //子弹与敌人(敌机+小蜜蜂)的碰撞
					hitAction();   //英雄机与敌人(敌机+小蜜蜂)的碰撞
					checkGameOverAction(); //检测游戏结束
				}
				repaint();     //重画(重新调用paint()方法)
			}
		},intervel,intervel); //定时日程
	}
	
	/** 重写paint() g:画笔 */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //画背景图
		paintHero(g); //画英雄机对象
		paintFlyingObjects(g); //画敌人(敌机+小蜜蜂)对象
		paintBullets(g); //画子弹对象
		paintScoreAndLife(g); //画分和画命
		paintState(g); //画状态
	}
	/** 画英雄机对象 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null); //画英雄机对象
	}
	/** 画敌人(敌机+小蜜蜂)对象 */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //遍历敌人数组
			FlyingObject f = flyings[i]; //获取每一个敌人
			g.drawImage(f.image,f.x,f.y,null); //画敌人对象
		}
	}
	/** 画子弹对象 */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //遍历子弹数组
			Bullet b = bullets[i]; //获取每一个子弹
			g.drawImage(b.image,b.x,b.y,null); //画子弹对象
		}
	}
	/** 画分和画命 */
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000)); //设置颜色(纯红)
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24)); //设置字体(字体:SANS_SERIF 字体样式:BOLD加粗  字号:24)
		g.drawString("SCORE: "+score,10,25); //画分
		g.drawString("LIFE: "+hero.getLife(),10,45); //画命
		g.drawString("HARD:" + hard, 10, 65);
	}
	/** 画状态 */
	public void paintState(Graphics g){
		switch(state){ //根据当前状态的不同来画不同的图
		case START: //启动状态时
			g.drawImage(start,0,0,null); //画启动图
			break;
		case PAUSE: //暂停状态时
			g.drawImage(pause,0,0,null); //画暂停图
			break;
		case GAME_OVER: //游戏结束状态时
			g.drawImage(gameover,0,0,null); //画游戏结束图
			break;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //创建窗口对象
		ShootGame game = new ShootGame(); //创建面板对象
		frame.add(game); //将面板添加到窗口上
		
		frame.setSize(WIDTH, HEIGHT); //设置窗口大小
		frame.setAlwaysOnTop(true); //设置一直在最上面
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭操作(窗口关闭时退出程序)
		frame.setLocationRelativeTo(null); //设置居中显示
		frame.setVisible(true); //1)设置窗口可见  2)尽快调用paint()方法
		
		game.action(); //启动程序的执行
	}
	
}






























