import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * @author cqc
 *
 */
public class BallGame extends JFrame {

	Image ball=Toolkit.getDefaultToolkit().getImage("images/a1.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/a2.jpg");
	
	double x=100,y=100;
	boolean right=true;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)y,null);
		
		
		if(right)
			x+=10;
		else x-=10;
		
		if(x>856-40-30){    //856是窗口宽度，40是桌子边框的宽度，30是小球的直径
            right = false;
        }
         
        if(x<40){        //40是桌子边框的宽度
            right = true;
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
		BallGame game=new BallGame();
		game.launchFrame();
	
		
		

	}

}
