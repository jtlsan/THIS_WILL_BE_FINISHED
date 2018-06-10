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

public class DrawInfo {
	MakeStructure structure;
	JPanel panel;
	DrawInfo next[] = new DrawInfo[4];
	public String name;
	JLabel node;
	Color background;
	
	public DrawInfo(MakeStructure structure, JPanel panel, Color background) {		//600 x 500
		this.structure = structure;
		this.panel = panel;
		this.name = structure.name;
		this.background = background;
		
		int r = 0, g = 0, b = 0;
		
		if (background == null) {
			while(r < 100 || g < 100 || b < 100) {		//����� �ʹ� ���ؼ� ���ڰ� �Ⱥ��̴� �� ����
				r = (int)(Math.random() * 256);
				g = (int)(Math.random() * 256);
				b = (int)(Math.random() * 256);
			}
			background = new Color(r, g, b);
			r = 0; g = 0; b = 0;
		}
		while(r < 100 || g < 100 || b < 100) {		//����� �ʹ� ���ؼ� ���ڰ� �Ⱥ��̴� �� ����
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}

		Color setNextColor = new Color(r, g, b);
		
		structure.background = this.background;
		node = new JLabel(name);
		node.setHorizontalAlignment(SwingConstants.CENTER);
		node.setSize(50, 20);					//add�� �� �������� background������ �ؾ� �Ǵ� ��
		node.setLocation(structure.x, structure.y);
		panel.add(node);
		//������
		node.setBackground(background);
		node.setOpaque(true);
		
		
		for(int i = 0; i < 4; i++) {
			if (structure.next[i] == null)
				break;
			new DrawInfo(structure.next[i], panel, setNextColor);
		}
	}
	

	


}
