package template;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.io.File;

import javax.swing.*;

public class Template1 {
	JFrame frame = new JFrame("Mind Map Program");
	
	JMenuBar mb = new JMenuBar();
	JMenu MenuNew = new JMenu("새로만들기");
	JMenu MenuOpen = new JMenu("열기");
	JMenu MenuSave = new JMenu("저장");
	JMenu MenuNameSave = new JMenu("다른이름으로 저장");
	JMenu MenuExit = new JMenu("닫기");
	JMenu MenuApply = new JMenu("적용");
	JMenu MenuChange = new JMenu("변경");
	
	JFileChooser FileChooser = new JFileChooser();
	
	JToolBar toolBar = new JToolBar();
	JButton Toolnew = new JButton("새로만들기");
	JButton ToolOpen = new JButton("열기");
	JButton ToolSave = new JButton("저장");
	JButton ToolNameSave = new JButton("다른이름으로 저장");
	JButton ToolExit = new JButton("닫기");
	JButton ToolApply = new JButton("적용");
	JButton ToolChange = new JButton("변경");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JScrollPane scrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
	JScrollPane scrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane scrollPane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane2,panel3);
	JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, splitPane2);
	
	JTextArea textEditorPane = new JTextArea();
	
	JButton set = new JButton("적용");
	////////////////////////////////////////////////////////////////////여기까지 첫번째 텍스트페인
	
	JLabel label2 = new JLabel("Mind Map Pane");
	
	////////////////////////////////////////////////////////////////////위에는 마인드맵 페인 아래는 속성페
	JButton chg = new JButton("변경");
	JPanel middle = new JPanel();
	GridLayout grid = new GridLayout(6,2);
	
	JLabel text = new JLabel("     TEXT");
	JTextField nodeName = new JTextField();
	JLabel X = new JLabel("     X");
	JTextField XofNode = new JTextField();
	JLabel Y = new JLabel("     Y");
	JTextField YofNode = new JTextField();
	JLabel W = new JLabel("     W");
	JTextField WofNode = new JTextField();
	JLabel H = new JLabel("     H");
	JTextField HofNode = new JTextField();
	JLabel Color= new JLabel("     Color");
	JTextField ColorofNode = new JTextField();
	
	Template1(){
		frame.setTitle("스플릿 페인 만들기");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setSize(1050,700);
		frame.setVisible(true);
		
		
		// 메뉴바 프레임에 생성하고 붙이기
		frame.setJMenuBar(mb);
		mb.add(MenuNew);
		mb.add(MenuOpen);
		mb.add(MenuSave);
		mb.add(MenuNameSave);
		mb.add(MenuExit);
		mb.add(MenuApply);
		mb.add(MenuChange);
		
		
		// 툴바 생성, 붙이기
		frame.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		//toolBar.setBackground(Color.LIGHT_GRAY);
		
		Toolnew.setToolTipText("파일을 생성합니다");
		toolBar.add(Toolnew);
		toolBar.add(ToolOpen);
		toolBar.add(ToolSave);
		toolBar.add(ToolNameSave);
		toolBar.add(ToolExit);
		toolBar.add(ToolApply);
		toolBar.add(ToolChange);

		// 메인 페인들
		scrollPane1.setViewportView(textEditorPane);
		
		panel1.setLayout(new BorderLayout());
		panel1.add(scrollPane1);
		JLabel label1 = new JLabel("Text Editor Pane");
		label1.setSize(50,50);
		scrollPane1.setPreferredSize(new Dimension(200, 500));
		scrollPane1.setColumnHeaderView(label1);
		
		panel1.add(set, BorderLayout.SOUTH);
		//////////////////////////////////////////////
		label2.setSize(50,50);	//
		scrollPane2.setPreferredSize(new Dimension(600, 500));//
		scrollPane2.setColumnHeaderView(label2);//
		scrollPane2.setViewportView(panel2);//
		/////////////////////////////////////
		
		panel3.setLayout(new BorderLayout());
		panel3.add(scrollPane3);
		JLabel label3 = new JLabel("Atribute Pane");
		label3.setSize(50,50);	
		scrollPane3.setPreferredSize(new Dimension(200, 200));
		scrollPane3.setColumnHeaderView(label3);
		
		panel3.add(chg, BorderLayout.SOUTH);
		
		grid.setVgap(10);
		
		middle.setLayout(grid);
		
		middle.add(text);
		middle.add(nodeName);
		middle.add(X);
		middle.add(XofNode);
		middle.add(Y);
		middle.add(YofNode);
		middle.add(W);
		middle.add(WofNode);
		middle.add(H);
		middle.add(HofNode);
		middle.add(Color);
		middle.add(ColorofNode);
		
		scrollPane3.setViewportView(middle);
		
		
		frame.add(splitPane1);
	}
	
	
	
}

