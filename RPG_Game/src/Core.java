import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;




public class Core extends Applet implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private static JFrame frame;
	
	public static final int res = 1;
	public static double oy = 0, ox = 0;
	public static int dir = 0;
	public static boolean moving = false;
	public static boolean run = false;	
	
	private Image screen;
	
	public Level level;
	
	//diemension class dient zu Verwaltung der Grossen von container
	public static Dimension screenSize = new Dimension(700, 560);
    public static Dimension pixel = new Dimension(screenSize.width,screenSize.height);
	public static Dimension Size;
	
	public static String name = "The Golden Key";
	
	public Core(){
		setPreferredSize(screenSize);
	}
	
	public static void main(String[] args){
		Core core = new Core();
		
		frame = new JFrame();
		frame.add(core);
		frame.pack();
		
		Size = new Dimension(frame.getWidth(),frame.getHeight());
		
		frame.setTitle(name);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		core.start();
	}
	
	public void start(){
		requestFocus();	
			
		level = new Level(4);
		new Tile();
		
		run = true;
		new Thread(this).start();
	}
	
	public void stop(){
		run = false;
	}

	public void tick(){
		level.tick();
	}
	
	public void render(){
		
		Graphics g = screen.getGraphics();
		
		level.render(g, (int)ox, (int)oy, (pixel.width/Tile.size)+2, (pixel.height/Tile.size)+2);
		
		
		g = this.getGraphics();
		g.drawImage(screen, 0, 0, screenSize.width, screenSize.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();

		
		
	}
	
	public void run(){
		screen = createVolatileImage(pixel.width, pixel.height);
		
		while(run){
			tick();
			render();
			
			try{
				Thread.sleep(5);
			}catch(Exception e){
				System.out.println("Sleeping thread Error");
			}
		}
		
	}

}
