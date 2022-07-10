package ImageOrganizerPackage;

import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImageOrganizerWindow {

	public ImageOrganizerWindow(ImageOrganizerController controller) {
		frame = new JFrame();
		frame.setBounds(300, 90, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Image Organizer");
		frame.setLayout(null);
		
		c = frame.getContentPane();
		
		parentFolderInput = new JTextField();
		parentFolderInput.setSize(450, 25);
		parentFolderInput.setLocation(0, 0);
		c.add(parentFolderInput);
		
		parentLoadButton = new JButton("Go");
		parentLoadButton.setSize(50, 25);
		parentLoadButton.setLocation(450, 0);
		parentLoadButton.addActionListener(new LoadButtonActionListener(controller));
		c.add(parentLoadButton);
		
		childInputs = new JTextField[10];
		childButtons = new JButton[10];
		for(int i = 0; i < 10; ++i)
		{
			childInputs[i] = new JTextField();
			childInputs[i].setSize(450, 25);
			childInputs[i].setLocation(0, (i+1) * 30);
			c.add(childInputs[i]);
			
			childButtons[i] = new JButton();
			childButtons[i].setSize(25, 25);
			childButtons[i].setLocation(475, (i+1) * 30);
			childButtons[i].setName(String.valueOf(i));
			childButtons[i].addActionListener(new ImageOrganizerButtonActionListener(controller, i));
			c.add(childButtons[i]);
		}
		
		skipButton = new JButton("Skip");
		skipButton.setSize(74, 25);
		skipButton.setLocation(425, 11 * 30);
		skipButton.addActionListener(new SkipActionListener(controller));
		c.add(skipButton);
		
		picLabel = new JLabel();
		picLabel.setSize(600, 600);
		picLabel.setLocation(550, 0);
		c.add(picLabel);
		
		keyInput = new JTextField();
		keyInput.setSize(450, 25);
		keyInput.setLocation(0, 15 * 30);
		keyInput.addKeyListener(new ChildFolderKeyListener(controller));
		c.add(keyInput);
		
		progressLabel = new JLabel();
		progressLabel.setSize(300, 25);
		progressLabel.setLocation(250, 325);
		c.add(progressLabel);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void loadImage(String filePath){
		try {
			c.remove(picLabel);
			
			BufferedImage image = ImageIO.read(new File(filePath));
			Image scaledImage = image.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
			picLabel = new JLabel(new ImageIcon(scaledImage));
			picLabel.setSize(600, 600);
			picLabel.setLocation(550, 0);
			c.add(picLabel);
			
			frame.repaint();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String GetChildDir(int ID) {
		return childInputs[ID].getText();
	}
	
	public String GetParentDir() {
		return parentFolderInput.getText();
	}
	
	public void SetProgress(String progress) {
		progressLabel.setText(progress);
	}
	
	private JFrame frame;
	private Container c;

	private JTextField parentFolderInput;
	private JButton parentLoadButton;
	
	private JTextField[] childInputs;
	private JButton[] childButtons;
	
	private JButton skipButton;
	
	private JLabel picLabel;
	
	private JLabel progressLabel;
	
	private JTextField keyInput;
}
