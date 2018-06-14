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
	JButton chg, applybtn;
	
	public AddMouseListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure strct, DrawInfo nodeInfo, JButton chg, JButton applybtn) {
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
		this.applybtn = applybtn;
		
		AddListener(this.nodeInfo);
	}

	void AddListener(DrawInfo nodeState) {
		if(nodeState != null) {
			NodeMouseListener mListener = new NodeMouseListener(mapPanel, name, x, y, width, height, color, strct, nodeInfo, chg, applybtn);
			nodeState.node.addMouseListener(mListener);
			nodeState.node.addMouseMotionListener(mListener);
			for(int i = 0; i < nodeState.next.length; i++) {
				if (nodeState.next[i] == null)
					break;
				
				AddListener(nodeState.next[i]);
			}
		}
	}
}
