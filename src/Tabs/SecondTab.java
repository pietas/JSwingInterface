package Tabs;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Panels.HeaderPanel;

public class SecondTab extends AbstractTabSetup {
	public SecondTab() {
		JPanel parentPanel = new JPanel(new BorderLayout());
		this.setViewportView(parentPanel);
		parentPanel.add(setup(), BorderLayout.CENTER);
	}

	public JPanel setup() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		String path = "Images/";
		ClassLoader cl = HeaderPanel.class.getClassLoader();
		File directory;
		try {
			directory = new File(Paths.get(cl.getResource(path).toURI())
					.toAbsolutePath().toString());
			for (File file : directory.listFiles()) {
				JLabel label = new JLabel();
				BufferedImage image = ImageIO.read(file);
				label.setIcon(new ImageIcon(image));
				panel.add(label);
			}

			// Create file tree and use FileView to get icon of file.
			for (File images : directory.listFiles()) {
				System.out.println(images.toString());
			}
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return panel;
	}
}
