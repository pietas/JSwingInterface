package Tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabbedPaneDemo extends JPanel
{
    public TabbedPaneDemo()
    {
        JTabbedPane tabbedPane = new JTabbedPane();
        Component panel1 = makeTextPanel("Blah");
        tabbedPane.addTab("One", null, panel1, "Does nothing");
        tabbedPane.setSelectedIndex(0);

        Component panel2 = makePanel();
        tabbedPane.addTab("Two", null, panel2, "Does nothing at all");
        // Add the tabbed pane to this panel.
        setLayout(new GridLayout(1, 1));
        this.add(tabbedPane);
        
        Component panel3 = makePanel();
        tabbedPane.addTab("Two", null, panel3, "Does nothing at all");
        // Add the tabbed pane to this panel.
        this.setLayout(new GridLayout(1, 1));
        this.add(tabbedPane);
    }

    protected Component makeTextPanel(String text)
    {
        //creates initial panel.
        JPanel panel = new JPanel(false);
        //Creates label filler text for panel.
        JLabel filler = new JLabel(text);
        //Sets the filler alignment to center in panel.
        filler.setHorizontalAlignment(JLabel.CENTER);
        //Sets the panels layout to grid layout, one row, one column.
        panel.setLayout(new GridLayout(1, 1));
        //Add the centered label to the single row/column of 
        panel.add(filler);
        //Returns panel for instantiation within the tabbed pane demo.
        return panel;
    }

    protected Component makePanel()
    {
        //Creates initial panel.
        JPanel panel = new JPanel(false);
        //Creates editor/text pane for text editing.
        JTextArea jEdit = new JTextArea();
        //Creates scroll panel for editor pane.
        JScrollPane jScrollPane1 = new JScrollPane();
        //scroll panel adds the editor pane as its viewport.
        jScrollPane1.getViewport().add(jEdit, null);
//        panel.add(jScrollPane1, null);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(jScrollPane1);
        return panel;
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        frame.getContentPane().add(new TabbedPaneDemo(), BorderLayout.CENTER);
        frame.setSize(3200, 1800);
        frame.setVisible(true);
    }
}