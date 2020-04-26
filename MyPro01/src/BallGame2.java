import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * @author cqc
 *
 */

public class BallGame2 extends JFrame {

	Image ball=Toolkit.getDefaultToolkit().getImage("images/a1.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/a2.jpg");
	
	double x=100,y=100,degree=3.14/3;

	boolean right=true;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)y,null);
		
		
		x  = x+ 10*Math.cos(degree);
        y  = y +10*Math.sin(degree); 
        if(y>500-40-30||y<40+40){//500是窗口高度；40是桌子边框，30是球直径；最后一个40是标题栏的高度
            degree = -degree;
        }
         
        //碰到左右边界
        if(x<40||x>856-40-30){
            degree = 3.14 - degree;
        }
         
    
	}
	
	void launchFrame(){
		setSize(856,500);
		setLocation(400,400);
		setVisible(true);
		
		
		while(true){
	
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("炒青菜的第一个小游戏");
		BallGame2 game=new BallGame2();
		game.launchFrame();
	
		
		

	}

}
