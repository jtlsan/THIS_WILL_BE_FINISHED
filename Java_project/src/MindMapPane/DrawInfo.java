package MindMapPane;


//속성이나 마우스로 노드의 정보를 변경하면 자료의 정보를 변경하고 즉각 draw함수를 다시 쓴다. 근데 color가 동일해야 할 때가 있으므로 Draw함수를 또 하나 만들어서 color를 유지시키되 모양만
//변하는 함수를 만들어야 할 것 같다.

//선 : 직선을 점 하나하나 해서(마우스로 그리듯이) 그리다가 컴포넌트에 만나면 방향을 조금씩 틀어서 만나지 않을 때까지 틀도록 하는 것
//마인드맵 : 옛날 신문 오려붙이기 할 때와 같은 구조 시도해보기
//마인드맵 구조 : 겹치면 노드들 사이 간격 띠우는 방식?
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MouseOption.NodeMouseListener;

public class DrawInfo {
	MakeStructure structure;
	JPanel panel;
	public DrawInfo next[] = new DrawInfo[4];
	public String name;
	public JLabel node;
	
	public DrawInfo(MakeStructure structure, JPanel panel) {		//600 x 500
		this.structure = structure;
		this.panel = panel;
		this.name = structure.name;
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
		node.setOpaque(true);
		
		
		for(int i = 0; i < 4; i++) {
			if (structure.next[i] == null)
				break;
			next[i] = new DrawInfo(structure.next[i], panel);
		}
	}
	
	
	

	


}
