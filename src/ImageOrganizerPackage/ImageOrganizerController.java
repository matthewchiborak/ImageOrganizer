package ImageOrganizerPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageOrganizerController implements KeyListener{

	public ImageOrganizerController(){
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyChar() == 'r') {
			System.out.println("Test");
			//model.reset();
			//model.draw();
			//model.draw();
			//model.draw();
			//model.printDrawnCards();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
