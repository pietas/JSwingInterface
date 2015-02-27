package Tabs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FifthTab extends AbstractTabSetup {
	public FifthTab()
	{
		JPanel scrollPanel = new JPanel(new BorderLayout());
		setUpDialog();
		scrollPanel.add(new JLabel("Fifth tab"), BorderLayout.CENTER);
		this.add(scrollPanel);
	}
	
	public void setUpDialog()
	{
		
		JDialog dialog = new JDialog();
	}
}
