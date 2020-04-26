import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;


/**
 * @author cqc
 *
 */
public class Ball1 extends JFrame {

	 Image a1=Toolkit.getDefaultToolkit().getImage("images/a1.png");
	 Image a2=Toolkit.getDefaultToolkit().getImage("images/a2.jpg");
	
	 boolean flag=true;
	 double x=100,y=100;
	 
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(a2, 0, 0, null);
			g.drawImage(a1, (int)x, (int)y, null);
			
			if(flag) x+=10; else x-=10;
			if(x>856-40-30) flag=false;
			if(x<40) flag=true;

		}

		void launchJFrame(){
			setSize(856,500);
			setLocation(400,400);
			setVisible(true);
			while(true)
			{
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Image a2=Toolkit.getDefaultToolkit().getImage("images/a2.jpg");
	Image a1=Toolkit.getDefaultToolkit().getImage("images/a1.png");
	double x=100,y=100;
	boolean flag=true;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(a2, 0, 0, null);
		g.drawImage(a1, (int)x, (int)y, null);
		
		if(flag) x+=10; else x-=10;
		if(x>856-40-30) flag=false;
		if(x<40) flag=true;

	}

	void launchJFrame(){
		setSize(856,500);
		setLocation(400,400);
		setVisible(true);
		while(true)
		{
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ball1 ball=new Ball1();
		ball.launchJFrame();

	}



}







