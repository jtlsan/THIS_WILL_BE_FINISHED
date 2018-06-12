package MouseOption;

import template.ResizePanelSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class NodeMouseListener implements MouseListener, MouseMotionListener{
	JTextField name, x, y, width, height, color;
	MakeStructure strct;
	MakeStructure objectStrct;
	DrawInfo nodeInfo;
	DrawInfo objectNode;
	JButton chg;
	String objectText;
	JPanel mapPanel;
	int objectX = 0, objectY = 0;
	ApplyMouseListener ApplyListener;
	public NodeMouseListener(MakeStructure strct, DrawInfo nodeInfo, int x, int y) {
		this.objectX = x;
		this.objectY = y;
		this.strct = strct;
		this.nodeInfo = nodeInfo;
		Search(this.strct);
		SearchNode(this.nodeInfo);
	}
	public NodeMouseListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure strct, DrawInfo nodeInfo, JButton chg) {
		this.mapPanel = mapPanel;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strct = strct;
		this.nodeInfo = nodeInfo;
		this.chg = chg;
		
	}
	
	
	void redrawNode() {
		int r = 0, g = 0, b = 0;
		while(r < 100 || g < 100 || b < 100) {		//배경이 너무 진해서 글자가 안보이는 것 방지
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}
		SearchNode(nodeInfo);
		objectStrct.background = new Color(r, g, b);
		
		objectNode.node.setBackground(objectStrct.background);
		mapPanel.repaint();		 
	}
	public void mousePressed(MouseEvent e) {		 
		JLabel label = (JLabel)e.getSource();
		
			
		objectText = label.getText();
		objectX = label.getX();
		objectY = label.getY();
		Search(strct);
		redrawNode();
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText(Integer.toString(objectStrct.background.getRGB()));
		
		MouseListener listeners[] = chg.getMouseListeners();
		for(int i = 0; i < listeners.length; i++)
			chg.removeMouseListener(listeners[i]);

		chg.addMouseListener(ApplyListener = new ApplyMouseListener(mapPanel, name, x, y, width, height, color, objectStrct, objectNode, strct));
		mapPanel.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		
		int mouseX = e.getXOnScreen() - 220;
		int mouseY = e.getYOnScreen() - 110;
		JLabel label = (JLabel)e.getSource();
		objectX = label.getX();
		objectY = label.getY();
		Search(strct);
		SearchNode(nodeInfo);
		
		
		objectStrct.x = mouseX - (int)(objectStrct.width / 2.0);
		objectStrct.y = mouseY - (int)(objectStrct.height / 2.0);
		
		objectNode.node.setLocation(objectStrct.x, objectStrct.y);
		
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText(Integer.toString(objectStrct.background.getRGB()));
		mapPanel.repaint();
		new ResizePanelSize(strct, mapPanel);
	}
	
	
	
	
	void SearchNode(DrawInfo nodes) {
		DrawInfo tmp = nodes;

		if(objectX == tmp.node.getX() && objectY == tmp.node.getY())
			objectNode = tmp;
		
		else {
			for(int i = 0; i < 4; i++) {
				if(nodes.next[i] == null)
					break;
				
				SearchNode(nodes.next[i]);
			}
		}
	}
	void Search(MakeStructure structure) {
		
		MakeStructure tmp = structure;
		
		if(objectX == tmp.x && objectY == tmp.y) {
			objectStrct = tmp;
		}
		else {		
			for (int i = 0; i < 4; i++) {			
				if(tmp.next[i] == null)
					break;	
				
				Search(tmp.next[i]);
			}
		}
		
		
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
