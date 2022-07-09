package ImageOrganizerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageOrganizerButtonActionListener implements ActionListener {

	public ImageOrganizerButtonActionListener(ImageOrganizerController controller, int ID) {
		this.controller = controller;
		this.ID = ID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(ID);
		controller.MoveCurrentImageToFolder(ID);
	}
	
	private ImageOrganizerController controller;
	private int ID;

}
