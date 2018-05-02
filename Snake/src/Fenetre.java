import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Fenetre extends JFrame implements KeyListener{
	
	Serpent ser = new Serpent();
	
	boolean touche_up = false;
	boolean touche_down = false;
	boolean touche_left = false;
	boolean touche_right = false;
	
	public int x;
	public int y;
	
	public Fenetre(){
		this.setTitle("Snake !");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(ser);
		this.setVisible(true);
		this.addKeyListener(this);
		initialise();
		}
	
	boolean bord = true;
	boolean action = false;
	
	public void initialise(){
		
		do{
			ser.setPosX(270);
			ser.setPosY(250);
			x = ser.getPosX();
			y = ser.getPosY();
			repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			if (x == 0 || x == 550 || y == 0 || y == 527) {
				bord = false;
			}
			if (touche_up == true) {action = true; move_up();}
			if (touche_down == true) {action = true; move_down();}
			if (touche_left == true) {action = true; move_left();}
			if (touche_right == true) {action = true; move_right();}
		} while((x > 0 && x < 550 && bord == true) || (y > 0 && y < 527 && bord == true) || action == true);
	}
	
	public void move_up() {
		action = false;
		x = ser.getPosX();
		do {
			y--;
			ser.setPosY(y);
			ser.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			if (x == 0 || x == 550 || y == 0 || y == 527) {
				bord = false;
			}
			if (touche_left == true) {action = true; move_left();}
			if (touche_right == true) {action = true; move_right();}
		} while ((x > 0 && x < 550 && bord == true) || (y > 0 && y < 527 && bord == true) || action == true);
		bord = true;
		initialise();
	}
	
	public void move_down() {
		action = false;
		x = ser.getPosX();
		do {
			y++;
			ser.setPosY(y);
			ser.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			if (x == 0 || x == 550 || y == 0 || y == 527) {
				bord = false;
			}
			if (touche_left == true) {action = true; move_left();}
			if (touche_right == true) {action = true; move_right();}
		} while ((x > 0 && x < 550 && bord == true) || (y > 0 && y < 527 && bord == true) || action == true);
		bord = true;
		initialise();
	}
	
	public void move_left() {
		action = false;
		y = ser.getPosY();
		do {
			x--;
			ser.setPosX(x);
			ser.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			if (x == 0 || x == 550 || y == 0 || y == 527) {
				bord = false;
			}
			if (touche_up == true) {action = true; move_up();}
			if (touche_down == true) {action = true; move_down();}
		} while ((x > 0 && x < 550 && bord == true) || (y > 0 && y < 527 && bord == true) || action == true);
		bord = true;
		initialise();
	}

	public void move_right() {
		action = false;
		y = ser.getPosY();
		do {
			x++;
			ser.setPosX(x);
			ser.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			if (x == 0 || x == 550 || y == 0 || y == 527) {
				bord = false;
			}
			if (touche_up == true) {action = true; move_up();}
			if (touche_down == true) {action = true; move_down();}
		} while ((x > 0 && x < 550 && bord == true) || (y > 0 && y < 527 && bord == true) || action == true);
		bord = true;
		initialise();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {touche_up = true;}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {touche_down = true;}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {touche_left = true;}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {touche_right = true;}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {touche_up = false;}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {touche_down = false;}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {touche_left = false;}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {touche_right = false;}
	}

}

