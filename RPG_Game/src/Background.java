import java.awt.Graphics;
import java.awt.Rectangle;


public class Background extends Rectangle{
	
	public int[] id = {-1,-1};
	
	public Background(Rectangle rect, int id[]){
		setBounds(rect);
		this.id = id;
	}
	
	public void render(Graphics g){
		g.drawImage(Tile.layer1,x-(int)Core.ox, y-(int)Core.oy, x+width-(int)Core.ox, y+height-(int)Core.oy, id[0]*Tile.size, id[1]*Tile.size, id[0]*Tile.size+Tile.size,id[1]*Tile.size+Tile.size, null);
		
	}

}
