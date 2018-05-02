import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Serpent extends JPanel{
	
	private int posX = 270;
	private int posY = 250;
	
	public void paintComponent(Graphics g){	
		// Serpent
		g.setColor(Color.RED);
		g.fillOval(posX, posY, 50, 50);
		}

	public int getPosX() {return posX;}
	public void setPosX(int posX) {this.posX = posX;}
		
	public int getPosY() {return posY;}
	public void setPosY(int posY) {this.posY = posY;}
}