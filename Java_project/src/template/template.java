package template;
import javax.swing.*;
import java.awt.*;

public class template extends JFrame{
	private Container c;
	public template() {
		setTitle("���ø� ���� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		creatMenu();
		creatTool();
		creatPane();
		setSize(1050,700);
		setVisible(true);
	}
	
	private void creatMenu() {
		JMenuBar mb = new JMenuBar();
		
		mb.add(new JMenu("���θ����"));
		mb.add(new JMenu("����"));
		mb.add(new JMenu("����"));
		mb.add(new JMenu("�ٸ� �̸����� ����"));
		mb.add(new JMenu("�ݱ�"));			// �޴�Ŭ���� �ٸ� �ɼǵ� �������°Ŷ� �̺�Ʈ �ٴ°� 743p ����
		mb.add(new JMenu("����"));
		mb.add(new JMenu("����"));
		
		setJMenuBar(mb);
	}
	private void creatTool() {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JButton newBtn = new JButton("���θ����");
		newBtn.setToolTipText("������ �����մϴ�");
		toolBar.add(newBtn);					// �����޶��� �̷���
		
		toolBar.add(new JButton("����"));			// �ȴ޶�
		toolBar.add(new JButton("����"));
		toolBar.add(new JButton("�ٸ��̸����� ����"));
		toolBar.add(new JButton("�ݱ�"));
		toolBar.add(new JButton("����"));
		toolBar.add(new JButton("����"));
		
		c.add(toolBar, BorderLayout.NORTH);
	}
	private void creatPane() {
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JScrollPane scrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		JScrollPane scrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scrollPane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane2,panel3);
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, splitPane2);
		
		JTextArea textEditorPane = new JTextArea();
		scrollPane1.setViewportView(textEditorPane);
		
		panel1.setLayout(new BorderLayout());
		panel1.add(scrollPane1);
		JLabel label1 = new JLabel("Text Editor Pane");
		label1.setSize(50,50);	
		scrollPane1.setPreferredSize(new Dimension(200, 500));
		scrollPane1.setColumnHeaderView(label1);
		JButton set = new JButton("����");
		panel1.add(set, BorderLayout.SOUTH);
	
		
		JLabel label2 = new JLabel("Mind Map Pane");
		label2.setSize(50,50);	
		scrollPane2.setPreferredSize(new Dimension(600, 500));
		scrollPane2.setColumnHeaderView(label2);
		
		panel3.setLayout(new BorderLayout());
		panel3.add(scrollPane3);
		JLabel label3 = new JLabel("Atribute Pane");
		label3.setSize(50,50);	
		scrollPane3.setPreferredSize(new Dimension(200, 200));
		scrollPane3.setColumnHeaderView(label3);
		JButton chg = new JButton("����");
		panel3.add(chg, BorderLayout.SOUTH);
		
		
		c.add(splitPane1);
	}
	public static void main(String[] args) {
		new template();
		
	}

}
