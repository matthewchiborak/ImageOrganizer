package ImageOrganizerPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class ImageOrganizerController {

	public ImageOrganizerController(){
		currentFile = 0;
	}
	
	public void setWindow(ImageOrganizerWindow window) {
		this.window = window;
	}
	
	public void LoadParentDirectory() {
		
		File folder = new File(window.GetParentDir());
		listOfFiles = folder.listFiles();
		
		currentFile = 0;

		LoadCurrentImage();
	}
	
	public void MoveCurrentImageToFolder(int ID) {
		
		
		/////////////
		
		if(currentFile+1 >= listOfFiles.length)
		{
			window.SetProgress("Done");
		}
	}
	
	public void SkipImage() {
		
		if(currentFile+1 >= listOfFiles.length)
		{
			window.SetProgress("Done");
		}
		
		currentFile++;
		
		LoadCurrentImage();
	}
	
	private void LoadCurrentImage()
	{
		while(!listOfFiles[currentFile].isFile())
			currentFile++;
		
		window.loadImage(listOfFiles[currentFile].getAbsolutePath());
		
		window.SetProgress(String.valueOf(currentFile+1) + " of " + String.valueOf(listOfFiles.length));
	}
	
	
	private ImageOrganizerWindow window;
	private File[] listOfFiles;
	private int currentFile;
}
