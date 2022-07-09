package ImageOrganizerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadButtonActionListener implements ActionListener {

	public LoadButtonActionListener(ImageOrganizerController controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Load");
		controller.LoadParentDirectory();
	}

	private ImageOrganizerController controller;
}
