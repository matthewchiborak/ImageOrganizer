package ImageOrganizerPackage;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageOrganizerWindow {

	public ImageOrganizerWindow(ImageOrganizerController controller) {
		frame = new JFrame();
		frame.setBounds(300, 90, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(controller);
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
			c.add(childButtons[i]);
		}
		
		try {
			final BufferedImage image = ImageIO.read(new File("D:\\eclipse-workspace\\ImageOrganizer\\src\\test\\resources\\Images\\FUvCHwTWYAAZj6I.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(image));
			picLabel.setSize(600, 600);
			picLabel.setLocation(550, 0);
			
			c.add(picLabel);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	private JFrame frame;
	private Container c;

	private JTextField parentFolderInput;
	private JButton parentLoadButton;
	
	private JTextField[] childInputs;
	private JButton[] childButtons;
}
