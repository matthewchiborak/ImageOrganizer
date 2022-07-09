package ImageOrganizerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipActionListener implements ActionListener {

	public SkipActionListener(ImageOrganizerController controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.SkipImage();
	}

	private ImageOrganizerController controller;
}
