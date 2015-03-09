package Tabs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Panels.HeaderPanel;
import Utils.ImageLoaderUtils;

public class FirstTab extends AbstractTabSetup {

	private ArrayList<BufferedImage> mOriginalImageList;
	private Dimension mSmallestImage;
	private static final String DIRECTORY = "resources/";
	private ImageLoaderUtils imageLoader;

	public FirstTab() {
		JPanel parentPanel = new JPanel(new BorderLayout());
		this.setViewportView(parentPanel);
		mOriginalImageList = new ArrayList<>();
		mSmallestImage = new Dimension(-1, -1);
		populateOriginalImageList(DIRECTORY);
		File file = new File("C:/Users/Public/Pictures/Sample Pictures/");
		imageLoader = new ImageLoaderUtils(file);
		parentPanel.add(setup(), BorderLayout.CENTER);
		
	}

	public JPanel setup() {
		JPanel panel = new JPanel(new GridLayout(0,1));

		JButton dialogButton = new JButton("Dialog");
		dialogButton.addMouseListener(dialogButtonListener());

		panel.add(dialogButton);
		ArrayList<BufferedImage> imageArray = imageLoader.getUnalteredImages();
		ImageIcon icon = new ImageIcon(imageArray.get(0));
		panel.add(new JLabel(icon));
		return panel;
	}

	public void populateOriginalImageList(String directory) {
		File file = new File(directory);

		ClassLoader loader;
		try {
			URL[] urlList = new URL[] { file.toURI().toURL() };
			for (URL url : urlList) {

				System.out.println(url.toString());
			}
			loader = new URLClassLoader(urlList);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MouseAdapter dialogButtonListener() {
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog dialog = new JDialog();
				dialog.setTitle("Image resize tester");
				dialog.setSize(400, 400);
				dialog.setVisible(true);

				// dialog.setMinimumSize(minimumSize);
			}
		};
		return adapter;
	}

	public JPanel classLoaderSetup() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel();
		panel.add(label, BorderLayout.CENTER);
		String path = "";
		ClassLoader cl = HeaderPanel.class.getClassLoader();
		try {
			BufferedImage image = ImageIO.read(cl.getResource(path
					+ "Solar.jpg"));
			label.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return panel;
	}

	public JPanel fileLoaderSetup() {
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

}
