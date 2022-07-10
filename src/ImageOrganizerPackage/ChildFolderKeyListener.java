package ImageOrganizerPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChildFolderKeyListener implements KeyListener {

	public ChildFolderKeyListener(ImageOrganizerController controller) {
		this.controller = controller;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyChar())
		{
		case '1':
			controller.MoveCurrentImageToFolder(0);
			break;
		case '2':
			controller.MoveCurrentImageToFolder(1);
			break;
		case '3':
			controller.MoveCurrentImageToFolder(2);
			break;
		case '4':
			controller.MoveCurrentImageToFolder(3);
			break;
		case '5':
			controller.MoveCurrentImageToFolder(4);
			break;
		case '6':
			controller.MoveCurrentImageToFolder(5);
			break;
		case '7':
			controller.MoveCurrentImageToFolder(6);
			break;
		case '8':
			controller.MoveCurrentImageToFolder(7);
			break;
		case '9':
			controller.MoveCurrentImageToFolder(8);
			break;
		case '0':
			controller.MoveCurrentImageToFolder(9);
			break;
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	private ImageOrganizerController controller;
}
