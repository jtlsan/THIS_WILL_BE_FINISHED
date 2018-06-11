package template;

import java.awt.Dimension;
import javax.swing.*;
import MouseOption.AddMouseListener;
import MouseOption.NodeMouseListener;
import Structure.DrawKit;
import JsonInput.Input;
import Structure.MakeStructure;
import MindMapPane.DrawInfo;
import Structure.SplitByEnter;
import Structure.OverLap;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;

public class ResizePanelSize {
	int minX = 0, minY = 0, maxX = 600, maxY = 500;
	MakeStructure strct;
	JPanel panel;
	public ResizePanelSize(MakeStructure strct, JPanel panel) {
		this.strct = strct;
		this.panel = panel;
		GetMaxValue(this.strct);
		GetMinValue(this.strct);
		ShiftNode(strct);
		panel.setPreferredSize(new Dimension(maxX, maxY));
	}
	
	void GetMaxValue(MakeStructure strct) {
		MakeStructure tmp = strct;
		if ((tmp.x + tmp.width) > maxX)
			maxX = tmp.x + tmp.width;
		if ((tmp.y + tmp.height)> maxY )
			maxY = tmp.y + tmp.height;
		for (int i = 0;i < tmp.next.length; i++) {
			if(tmp.next[i] == null)
				break;
			GetMaxValue(tmp.next[i]);
		}
	}
	void GetMinValue(MakeStructure strct) {
		MakeStructure tmp = strct;
		if (tmp.x < minX)
			minX = tmp.x;
		if (tmp.y < minY)
			minY = tmp.y;
		
		for (int i = 0; i < tmp.next.length; i++) {
			if (tmp.next[i] == null)
				break;
			
			GetMinValue(tmp.next[i]);
			
		}
	}
	
	void ShiftNode(MakeStructure strct) {
		MakeStructure tmp = strct;
		tmp.x -= minX;
		tmp.y -= minY;
		for (int i = 0; i < tmp.next.length; i++) {
			if (tmp.next[i] == null)
				break;
			ShiftNode(tmp.next[i]);
		}
	}
}
