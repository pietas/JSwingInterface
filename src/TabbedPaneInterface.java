import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TabbedPaneInterface extends JPanel
{
    public static void main(String[] args)
    {
        interfaceSetup();
    }
    
    public static void interfaceSetup()
    {
        JFrame frame = new JFrame("Tabbed Pane Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPaneSetup(frame, tabbedPane);
        tabbedPaneSetup(frame, tabbedPane);
    }
    
    public static void tabbedPaneSetup(JFrame superframe, JTabbedPane tabs)
    {
        
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