package ImageOrganizerPackage;

public class ImageOrganizer {

	public static void main(String[] args) {

		ImageOrganizerController controller = new ImageOrganizerController();
		ImageOrganizerWindow window = new ImageOrganizerWindow(controller);
		controller.setWindow(window);
		window.show();
	}

}
