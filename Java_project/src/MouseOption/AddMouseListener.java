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
	public AddMouseListener(JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure strct, DrawInfo nodeInfo) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strct = strct;
		
		AddListener(nodeInfo);
	}
	
	void AddListener(DrawInfo nodeState) {
		if(nodeState != null) {
			nodeState.node.addMouseListener(new NodeMouseListener(name, x, y, width, height, color, strct));
			
			for(int i = 0; i < nodeState.next.length; i++) {
				if (nodeState.next[i] == null)
					break;
				
				AddListener(nodeState.next[i]);
			}
		}
	}
}
