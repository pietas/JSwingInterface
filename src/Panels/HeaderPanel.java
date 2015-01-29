package Panels;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HeaderPanel extends JPanel {
	public HeaderPanel() {
		setUpHeader();
	}

	public void setUpHeader() {
		JPanel organizer = new JPanel();
		this.add(organizer);
		GridLayout layout = new GridLayout(1, 3);
		organizer.setLayout(layout);
		organizer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		organizer.add(setUpTitle(), 0);
		organizer.add(setUpMiddle(),1);

	}

	public JPanel setUpMiddle()
	{
		JPanel imagePanel = new JPanel();
		BufferedImage middleImage;
		try
		{
			InputStream url = getClass().getResourceAsStream("../Sun.jpg");
			middleImage = ImageIO.read(new File(url.toString()));
			imagePanel.paint(middleImage.getGraphics());
			return imagePanel;
			
		} catch (IOException ioEx)
		{
			System.err.print(ioEx);
			return imagePanel;
		}
		
	}

	public JTextField setUpTitle() {
		JTextField title = new JTextField("Title:");
		title.setEditable(false);
		return title;
	}
}
