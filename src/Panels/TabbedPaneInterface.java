package Panels;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Tabs.FifthTab;
import Tabs.FirstTab;
import Tabs.FourthTab;
import Tabs.SecondTab;
import Tabs.SixthTab;
import Tabs.ThirdTab;

public class TabbedPaneInterface extends JPanel {

	public static void main(String[] args) {
		interfaceSetup();
	}

	public static void interfaceSetup() {
		JFrame frame = new JFrame("Tabbed Pane Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(500, 500);
		frame.setVisible(true);
		JPanel parentPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		parentPanel.setLayout(layout);
		frame.add(parentPanel);
		JPanel title = new HeaderPanel();
		parentPanel.add(title, BorderLayout.NORTH);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		parentPanel.add(tabbedPane, BorderLayout.CENTER);

		FirstTab firstTab = new FirstTab();
		SecondTab secondTab = new SecondTab();
		ThirdTab thirdTab = new ThirdTab();
		FourthTab fourthTab = new FourthTab();
		FifthTab fifthTab = new FifthTab();
		SixthTab sixthTab = new SixthTab();
		tabbedPane.addTab("First", firstTab);
		tabbedPane.addTab("Second", secondTab);
		tabbedPane.addTab("Third", thirdTab);
		tabbedPane.addTab("Fourth", fourthTab);
		tabbedPane.addTab("Fifth", fifthTab);
		tabbedPane.addTab("Sixth", sixthTab);

	}

	public static void tabbedPaneSetup(JFrame superframe, JTabbedPane tabs) {

		JPanel firstPanel = new JPanel();
		JTextArea text = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(text, null);
		firstPanel.setLayout(new BorderLayout());
		firstPanel.add(scrollPane);
		tabs.addTab("First", firstPanel);
		superframe.add(tabs);
	}
}