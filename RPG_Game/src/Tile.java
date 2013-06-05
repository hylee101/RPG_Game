import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Tile {
	
	public static int[] blank = {-1,-1};
	
	public static int[] grass = {15,0};	
	public static int[] road = {16,0};
	public static int[] leaves = {2,0};
	
	public static int size = 32;
	public static BufferedImage terrain, layer1,items,characters;
	
	public Tile(){
		try{ 
			Tile.layer1 = ImageIO.read(new File("res/bg.png"));
			Tile.terrain = ImageIO.read(new File("res/bg.png"));
			Tile.items = ImageIO.read(new File("res/bg.png"));
			Tile.characters = ImageIO.read(new File("res/bg.png"));
		}catch(Exception e){
			System.out.println("Error Loading >>> Tile");
		}
		
	}

}
