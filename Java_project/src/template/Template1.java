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
	JMenu MenuNew = new JMenu("���θ����");
	JMenu MenuOpen = new JMenu("����");
	JMenu MenuSave = new JMenu("����");
	JMenu MenuNameSave = new JMenu("�ٸ��̸����� ����");
	JMenu MenuExit = new JMenu("�ݱ�");
	JMenu MenuApply = new JMenu("����");
	JMenu MenuChange = new JMenu("����");
	
	JFileChooser FileChooser = new JFileChooser();
	
	JToolBar toolBar = new JToolBar();
	JButton Toolnew = new JButton("���θ����");
	JButton ToolOpen = new JButton("����");
	JButton ToolSave = new JButton("����");
	JButton ToolNameSave = new JButton("�ٸ��̸����� ����");
	JButton ToolExit = new JButton("�ݱ�");
	JButton ToolApply = new JButton("����");
	JButton ToolChange = new JButton("����");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JScrollPane scrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
	JScrollPane scrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane scrollPane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane2,panel3);
	JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, splitPane2);
	
	JTextArea textEditorPane = new JTextArea();
	
	JButton set = new JButton("����");
	////////////////////////////////////////////////////////////////////������� ù��° �ؽ�Ʈ����
	
	JLabel label2 = new JLabel("Mind Map Pane");
	
	////////////////////////////////////////////////////////////////////������ ���ε�� ���� �Ʒ��� �Ӽ���
	JButton chg = new JButton("����");
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
		frame.setTitle("���ø� ���� �����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setSize(1050,700);
		frame.setVisible(true);
		
		
		// �޴��� �����ӿ� �����ϰ� ���̱�
		frame.setJMenuBar(mb);
		mb.add(MenuNew);
		mb.add(MenuOpen);
		mb.add(MenuSave);
		mb.add(MenuNameSave);
		mb.add(MenuExit);
		mb.add(MenuApply);
		mb.add(MenuChange);
		
		
		// ���� ����, ���̱�
		frame.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		//toolBar.setBackground(Color.LIGHT_GRAY);
		
		Toolnew.setToolTipText("������ �����մϴ�");
		toolBar.add(Toolnew);
		toolBar.add(ToolOpen);
		toolBar.add(ToolSave);
		toolBar.add(ToolNameSave);
		toolBar.add(ToolExit);
		toolBar.add(ToolApply);
		toolBar.add(ToolChange);

		// ���� ���ε�
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

