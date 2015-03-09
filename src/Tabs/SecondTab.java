package Tabs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import Panels.HeaderPanel;
import Utils.ImageLoaderUtils;

public class SecondTab extends AbstractTabSetup {
	public SecondTab() {
		JPanel parentPanel = new JPanel(new BorderLayout());
		this.setViewportView(parentPanel);
		parentPanel.add(setup(), BorderLayout.CENTER);
	}

	public JPanel setup() {
		JPanel panel = new JPanel(new GridLayout(0, 4));
		String path = "C:/Users/Public/Pictures/Sample Pictures/";
		File directory = new File(path);
		ImageLoaderUtils images = new ImageLoaderUtils(directory);

		for (BufferedImage image : images.getUnalteredImages()) {

		}

		int i = 0;
		// Create file tree and use FileView to get icon of file.
		for (BufferedImage image : images.getUnalteredImages()) {
			System.out.println(image.toString());
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon(images.getScaledImage(i)));
			label.setSize(94, 94);
			System.out.println("Label width X height: " + images.getScaledImage(i).getWidth() + " x " +  images.getScaledImage(i).getHeight());
			panel.add(label);
			i++;
		}

		return panel;
	}
}
