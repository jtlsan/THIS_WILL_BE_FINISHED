package MindMapPane;


//�Ӽ��̳� ���콺�� ����� ������ �����ϸ� �ڷ��� ������ �����ϰ� �ﰢ draw�Լ��� �ٽ� ����. �ٵ� color�� �����ؾ� �� ���� �����Ƿ� Draw�Լ��� �� �ϳ� ���� color�� ������Ű�� ��縸
//���ϴ� �Լ��� ������ �� �� ����.

//�� : ������ �� �ϳ��ϳ� �ؼ�(���콺�� �׸�����) �׸��ٰ� ������Ʈ�� ������ ������ ���ݾ� Ʋ� ������ ���� ������ Ʋ���� �ϴ� ��
//���ε�� : ���� �Ź� �������̱� �� ���� ���� ���� �õ��غ���
//���ε�� ���� : ��ġ�� ���� ���� ���� ���� ���?
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
		//������
		node.setBackground(structure.background);
		node.setOpaque(true);
		
		
		for(int i = 0; i < 4; i++) {
			if (structure.next[i] == null)
				break;
			next[i] = new DrawInfo(structure.next[i], panel);
		}
	}
	
	
	

	


}
