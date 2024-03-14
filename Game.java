import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Game extends Applet implements ActionListener{
	private int x=10,y=10,xSpeed=1,ySpeed=5,h=500,deger=h,sure=0;
	private Timer timer;
	public Game() {
		timer = new Timer(100,this);
		timer.start();
	}
	public void init() {
		setSize(1000,600);
	}
	public void paint(Graphics g) {                                                                         // 500,400,320,256,204,163,130,104  
		g.drawLine(0,550, 1000, 550);                                                                       // 83,66,52,41,32,25,20,16,12,6,4,3,2,1ddd
		g.fillOval(x,y, 50,50);
		g.drawString("Topun Yüksekliði: "+ deger, 20, 20);
		g.drawString("Topun Çýkacaðý Yükseklik: "+ h, 20, 40);
		g.drawString("Geçen Süre: "+ sure/1000 +" saniye" , 20, 60);
		sure+=100;
	}
	public void move() {
		x+=xSpeed;
		y+=ySpeed;
		deger=deger-ySpeed;
	}
	public void kontrol() {
		if(y>=500) {
			ySpeed=-ySpeed;
			h = (h*80)/100;
		}
		if(deger>h) {
			ySpeed=-ySpeed;
		}
		if(deger == 0) {
			timer.stop();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		kontrol();
		move();
		repaint();
	}
}