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
		
		if(x>856-40-30){    //856�Ǵ��ڿ�ȣ�40�����ӱ߿�Ŀ�ȣ�30��С���ֱ��
            right = false;
        }
         
        if(x<40){        //40�����ӱ߿�Ŀ��
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
		System.out.printf("����˵ĵ�һ��С��Ϸ");
		BallGame game=new BallGame();
		game.launchFrame();
	
		
		

	}

}
