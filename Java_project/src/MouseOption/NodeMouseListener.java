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
	int objectX = 0, objectY = 0, maxX = 0, maxY = 0;
	JLabel edge[] = new JLabel[4];
	JLabel axis[] = new JLabel[4];
	ApplyMouseListener ApplyListener;
	int mouseX = 0, mouseY = 0;
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
		SearchNode(nodeInfo);
		objectStrct.r = Math.abs(objectStrct.r - 255);
		objectStrct.g = Math.abs(objectStrct.g - 255);
		objectStrct.b = Math.abs(objectStrct.b - 255);
		System.out.println(objectStrct.r + " " + objectStrct.g + " " + objectStrct.b);
		objectStrct.background = new Color(objectStrct.r, objectStrct.g, objectStrct.b);
		
		objectNode.node.setBackground(objectStrct.background);
		mapPanel.repaint();		 
	}
	public void mousePressed(MouseEvent e) {		 
		JLabel label = (JLabel)e.getSource();
		
		maxX = new ResizePanelSize(strct).maxX;
		maxY = new ResizePanelSize(strct).maxY;
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
		color.setText((Integer.toHexString(objectStrct.r) + Integer.toHexString(objectStrct.g) + Integer.toHexString(objectStrct.b)).toUpperCase());
		
		MouseListener listeners[] = chg.getMouseListeners();
		for(int i = 0; i < listeners.length; i++)
			chg.removeMouseListener(listeners[i]);

		chg.addMouseListener(ApplyListener = new ApplyMouseListener(mapPanel, name, x, y, width, height, color, objectStrct, objectNode, strct));
		mapPanel.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		JLabel label = (JLabel)e.getSource();
		objectX = label.getX();
		objectY = label.getY();
		Search(strct);
		SearchNode(nodeInfo);
		try {
			mouseX = (int)objectNode.node.getParent().getMousePosition().getX();
			mouseY = (int)objectNode.node.getParent().getMousePosition().getY();
			
		}
		catch(NullPointerException E) {
			
		}
	
		
		
		
		
		objectStrct.x = mouseX - (int)(objectStrct.width / 2.0);
		objectStrct.y = mouseY - (int)(objectStrct.height / 2.0);
		
		objectNode.node.setLocation(objectStrct.x, objectStrct.y);
		
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText((Integer.toHexString(objectStrct.r) + Integer.toHexString(objectStrct.g) + Integer.toHexString(objectStrct.b)).toUpperCase());
		mapPanel.repaint();
		
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
	public void mouseExited(MouseEvent e) {
		mouseX = e.getXOnScreen() - 220;
		mouseY = e.getYOnScreen() - 110;
		if (e.getX() < 0 || e.getX() > objectStrct.width || e.getY() < 0 || e.getY() > objectStrct.height)
			for(int i = 0; i < 4; i++) {
				edge[i].setVisible(false);
				edge[i].setOpaque(false);
				objectNode.node.remove(edge[i]);
				axis[i].setVisible(false);
				axis[i].setOpaque(false);
				objectNode.node.remove(axis[i]);
			}
		
	}
	public void mouseEntered(MouseEvent e) {
		JLabel label = (JLabel)e.getSource();
		objectX = label.getX();
		objectY = label.getY();
		Search(strct);
		SearchNode(nodeInfo);
		mouseX = e.getXOnScreen() - 220;
		mouseY = e.getYOnScreen() - 110;

		for(int i = 0; i < 4; i++) {
			edge[i] = new JLabel();
			axis[i] = new JLabel();
			edge[i].setSize(6, 6);
			axis[i].setSize(6, 6);
			
			switch(i) {
				case 0:
					edge[i].setLocation(0, 0);
					label.add(edge[i]);
					edge[i].setBackground(Color.BLACK);
					edge[i].setOpaque(true);
					edge[i].setVisible(true);
					edge[i].setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
					axis[i].setLocation(objectStrct.width /2 - 3, 0);
					label.add(axis[i]);
					axis[i].setBackground(Color.BLACK);
					axis[i].setOpaque(true);
					axis[i].setVisible(true);
					axis[i].setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
					break;
				case 1:
					edge[i].setLocation(objectStrct.width - 5, 0);
					label.add(edge[i]);
					edge[i].setBackground(Color.BLACK);
					edge[i].setOpaque(true);
					edge[i].setVisible(true);
					edge[i].setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
					axis[i].setLocation(objectStrct.width - 6, objectStrct.height/2 - 3);
					label.add(axis[i]);
					axis[i].setBackground(Color.BLACK);
					axis[i].setOpaque(true);
					axis[i].setVisible(true);
					axis[i].setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
					break;
				case 2:
					edge[i].setLocation(objectStrct.width - 5, objectStrct.height - 5);
					label.add(edge[i]);
					edge[i].setBackground(Color.BLACK);
					edge[i].setOpaque(true);
					edge[i].setVisible(true);
					edge[i].setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
					axis[i].setLocation(objectStrct.width/2 - 3, objectStrct.height - 6);
					label.add(axis[i]);
					axis[i].setBackground(Color.BLACK);
					axis[i].setOpaque(true);
					axis[i].setVisible(true);
					axis[i].setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
					break;
				case 3:
					edge[i].setLocation(0, objectStrct.height - 5);
					label.add(edge[i]);
					edge[i].setBackground(Color.BLACK);
					edge[i].setOpaque(true);
					edge[i].setVisible(true);
					edge[i].setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
					axis[i].setLocation(0, objectStrct.height/2 - 3);
					label.add(axis[i]);
					axis[i].setBackground(Color.BLACK);
					axis[i].setOpaque(true);
					axis[i].setVisible(true);
					axis[i].setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
					break;
			}
			
		}
		for (int i = 0; i < 4; i++) {
			switch(i) {
				case 0:
					edge[i].addMouseMotionListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					edge[i].addMouseListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseMotionListener(new AxelListener(edge,  axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseListener(new AxelListener(edge, axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					
					break;
				
				case 1:
					edge[i].addMouseMotionListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					edge[i].addMouseListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseMotionListener(new AxelListener(edge,  axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseListener(new AxelListener(edge, axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					break;
					
				case 2:
					edge[i].addMouseMotionListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					edge[i].addMouseListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseMotionListener(new AxelListener(edge,  axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseListener(new AxelListener(edge, axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					break;
					
				case 3:
					edge[i].addMouseMotionListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					edge[i].addMouseListener(new EdgeListener(axis, edge, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseMotionListener(new AxelListener(edge,  axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					axis[i].addMouseListener(new AxelListener(edge, axis, i, name, x, y, width, height, color, objectStrct, strct, mapPanel, objectNode));
					break;
			}
		}
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		new ResizePanelSize(strct, mapPanel);
		for(int i = 0; i < 4; i++) {
			edge[i].setVisible(false);
			edge[i].setOpaque(false);
			objectNode.node.remove(edge[i]);
			axis[i].setVisible(false);
			axis[i].setOpaque(false);
			objectNode.node.remove(axis[i]);
		}
	}
}
