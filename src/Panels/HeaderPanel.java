package Panels;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
		organizer.add(classLoaderSetup(), 1);
//		organizer.add(fileLoaderSetup(), 2);

	}

	public  JPanel fileLoaderSetup() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel();
		panel.add(label, BorderLayout.CENTER);
		String path = "/JSwingInterface/resources/";
		File file = new File(path + "Solar.jpg");
		try {
			BufferedImage image = ImageIO.read(file);
			label.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return panel;
	}

	
	public  JPanel classLoaderSetup() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel();
		panel.add(label, BorderLayout.CENTER);
		String path = "Images/";
		ClassLoader cl = HeaderPanel.class.getClassLoader();
		try {
			BufferedImage image = ImageIO.read(cl.getResource(path
					+ "Solar.jpg"));
			System.out.println(Paths.get(cl.getResource(path).toURI()).toAbsolutePath().toString());
			label.setIcon(new ImageIcon(image));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

		return panel;
	}

	public JLabel setUpTitle() {
		JLabel dialogButton = new JLabel("Title");
		return dialogButton;
	}
}
