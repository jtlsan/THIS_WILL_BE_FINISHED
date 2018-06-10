package MouseOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class AddMouseListener {
	JTextField name, x, y, width, height, color;
	MakeStructure strct;
	DrawInfo nodeInfo;
	String objectText;
	JPanel mapPanel;
	public AddMouseListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
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
		
		AddListener(this.nodeInfo);
	}
	
	void AddListener(DrawInfo nodeState) {
		if(nodeState != null) {
			nodeState.node.addMouseListener(new NodeMouseListener(mapPanel, name, x, y, width, height, color, strct, nodeInfo));
			
			for(int i = 0; i < nodeState.next.length; i++) {
				if (nodeState.next[i] == null)
					break;
				
				AddListener(nodeState.next[i]);
			}
		}
	}
}
