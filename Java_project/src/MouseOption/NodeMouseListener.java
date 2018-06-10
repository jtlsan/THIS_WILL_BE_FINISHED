package MouseOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class NodeMouseListener extends MouseAdapter{
	JTextField name, x, y, width, height, color;
	MakeStructure strct;
	MakeStructure objectStrct;
	DrawInfo nodeInfo;
	DrawInfo objectNode;
	String objectText;
	JPanel mapPanel;
	public NodeMouseListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure strct, DrawInfo nodeInfo) {
		this.mapPanel = mapPanel;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strct = strct;
		this.nodeInfo = nodeInfo;
		int e = MouseEvent.MOUSE_CLICKED;
		
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
		
	
	
		/*
		 node = new JLabel(name);
		node.setHorizontalAlignment(SwingConstants.CENTER);
		
		if (structure.width < node.getPreferredSize().width)
			structure.width = node.getPreferredSize().width;
		if (structure.height < node.getPreferredSize().height)
			structure.height = node.getPreferredSize().height;
		
		node.setSize(structure.width, structure.height);					
		node.setLocation(structure.x, structure.y);
		panel.add(node);
		//색깔설정
		node.setBackground(structure.background);
		node.setOpaque(true);*/
		 
	}
	public void mouseClicked(MouseEvent e) {		//노드색 반전 필요!!
		JLabel label = (JLabel)e.getSource();
		
			
		objectText = label.getText();
		Search(strct);
		redrawNode();
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText(Integer.toString(objectStrct.background.getRGB()));


	}
	
	void SearchNode(DrawInfo nodes) {
		DrawInfo tmp = nodes;
		if(tmp == null)
			System.out.println("tmp가 널");
		if(objectText == null)
			System.out.println("objecttext가 널");
		if(objectText.equals(tmp.node.getText()))
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
		
		if(objectText.equals(tmp.name)) {
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
	

}
