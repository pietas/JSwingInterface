package Utils;

import java.awt.Component;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import jdk.internal.dynalink.DefaultBootstrapper;

public class DefaultMutableTreeNodeUsingFile {
	DefaultTreeModel dm;
	protected void initUI()
	{
		JFrame frame = new JFrame(DefaultMutableTreeNodeUsingFile.class.getSimpleName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dm = new DefaultTreeModel(createTreeModelInit(new File("C:/Users/Public")));
		final JTree tree = new JTree(dm);
		tree.setCellRenderer(new DefaultTreeCellRenderer(){
			@Override
			public  Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expand, boolean leaf, int row, boolean hasFocus){
				super.getTreeCellRendererComponent(tree, value, sel, expand, leaf, row, hasFocus);
				if(value instanceof DefaultMutableTreeNode){
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
					if(node.getUserObject() instanceof File){
						setText(((File)node.getUserObject()).getName());
					}
				}
				return this;
			}
		});
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener(){
			@Override
			public void valueChanged(TreeSelectionEvent e){
				Object object = tree.getLastSelectedPathComponent();
				if(object instanceof DefaultMutableTreeNode){
					Object userObject = ((DefaultMutableTreeNode)object).getUserObject();
					if(userObject instanceof File){
						File file = (File) userObject;
						if(file.isDirectory())
						{
							DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
							DefaultMutableTreeNode newChild = new DefaultMutableTreeNode("Node " + (root.getChildCount() + 1));
							dm.insertNodeInto(newChild, root, 0);
							tree.expandPath(new TreePath(dm.getPathToRoot(newChild.getParent())));
							
						}
						System.err.println("Selected file" + file.getAbsolutePath() + " is directory?" + file.isDirectory());
					}
					
				}
			}
		});
		JScrollPane pane = new JScrollPane(tree);
		frame.add(pane);
		frame.setSize(400, 600);
		frame.setVisible(true);
	}
	
	private DefaultMutableTreeNode createTreeModelInit(File file)
	{
		return createTreeModel(file, true);
	}
	
	private DefaultMutableTreeNode createTreeModel(File file, boolean recursive){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
		if(file.isDirectory() && recursive)
		{
			File[] children = file.listFiles();
			if(children != null)
			{
				for(File f : children)
				{
					node.add(createTreeModel(f, recursive));
				}
			}
		}
		return node;
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new DefaultMutableTreeNodeUsingFile().initUI();
			}
		});
	}
}
