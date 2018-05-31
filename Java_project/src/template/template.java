package template;
import javax.swing.*;
import java.awt.*;

public class template extends JFrame{
	private Container c;
	public template() {
		setTitle("스플릿 페인 만들기");
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
		
		mb.add(new JMenu("새로만들기"));
		mb.add(new JMenu("열기"));
		mb.add(new JMenu("저장"));
		mb.add(new JMenu("다른 이름으로 저장"));
		mb.add(new JMenu("닫기"));			// 메뉴클릭시 다른 옵션들 내려오는거랑 이벤트 다는거 743p 참고
		mb.add(new JMenu("적용"));
		mb.add(new JMenu("변경"));
		
		setJMenuBar(mb);
	}
	private void creatTool() {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JButton newBtn = new JButton("새로만들기");
		newBtn.setToolTipText("파일을 생성합니다");
		toolBar.add(newBtn);					// 툴팁달때는 이렇게
		
		toolBar.add(new JButton("열기"));			// 안달때
		toolBar.add(new JButton("저장"));
		toolBar.add(new JButton("다른이름으로 저장"));
		toolBar.add(new JButton("닫기"));
		toolBar.add(new JButton("적용"));
		toolBar.add(new JButton("변경"));
		
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
		JButton set = new JButton("적용");
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
		JButton chg = new JButton("변경");
		panel3.add(chg, BorderLayout.SOUTH);
		
		
		c.add(splitPane1);
	}
	public static void main(String[] args) {
		new template();
		
	}

}
