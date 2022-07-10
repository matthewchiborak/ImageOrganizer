package ImageOrganizerPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		
		//if(window.GetChildDir(ID).isBlank())
			//return;
		
		File dest = new File(window.GetChildDir(ID) + "\\" + listOfFiles[currentFile].getName());
		try {
			copy(listOfFiles[currentFile], dest);
			listOfFiles[currentFile].delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(currentFile+1 >= listOfFiles.length)
		{
			window.SetProgress("Done");
			return;
		}
		
		currentFile++;
		
		LoadCurrentImage();
	}
	
	public void SkipImage() {
		
		if(currentFile+1 >= listOfFiles.length)
		{
			window.SetProgress("Done");
			return;
		}
		
		currentFile++;
		
		LoadCurrentImage();
	}
	
	private void LoadCurrentImage()
	{
		while(!listOfFiles[currentFile].isFile())
		{
			if(currentFile+1 >= listOfFiles.length)
			{
				window.SetProgress("Done");
				return;
			}
			
			currentFile++;
		}
		
		window.loadImage(listOfFiles[currentFile].getAbsolutePath());
		
		window.SetProgress(String.valueOf(currentFile+1) + " of " + String.valueOf(listOfFiles.length));
	}
	
	public static void copy(File src, File dest) throws IOException { 
		InputStream is = null; 
		OutputStream os = null; 
		try { 
			is = new FileInputStream(src); 
			os = new FileOutputStream(dest); 
			// buffer size 1K 
			byte[] buf = new byte[1024]; 
			int bytesRead; 
			while ((bytesRead = is.read(buf)) > 0) { 
				os.write(buf, 0, bytesRead); 
			} 
		}
		finally { 
			is.close(); 
			os.close(); 
		} 
	}

	
	private ImageOrganizerWindow window;
	private File[] listOfFiles;
	private int currentFile;
}
