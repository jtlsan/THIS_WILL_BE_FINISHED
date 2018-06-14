package template;
import javax.swing.*;
import MouseOption.AddMouseListener;
import MouseOption.NodeMouseListener;
import Structure.DrawKit;
import JsonInput.Input;
import JsonOutput.Output;
import Structure.MakeStructure;
import MindMapPane.DrawInfo;
import Structure.SplitByEnter;
import Structure.OverLap;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
//2. �����ִ� ���游
//color 5�ڸ��� �� ��ġ��
//=======================================�� : �ذ�====================================================
//3. (��ȣ)color ���� >>> makestructure�̶� nodemouselitener�ٲ�
//���� axis edge��� �����ִ°� >>> templete����(Ŭ���ϳ� ����, �����ư Ŭ������ �� ������ �ΰ� �߰�)
//resizepanel����
//5. ���� �ڸ���ġ �ȵ� ��찡 ����. >>> overlapŬ���� ��ħ
//ũ�������Ҷ� ���� ��ġ�̵��Ǵ°� ���� �ľ� �ʿ�! >> edge, axel Ŭ���� ��ħ
//1. Ʈ�������ȿ� color�� getRGB int������ �����ϴ°�. �׷��� �ҷ��������� getRGB >> background�����ϴ°� �ʿ� >>>> 4������ ����
//4. COLOR getr getg getb 16�����Τ� >>> Ʈ�������� r,g,b�� ������ �� �ְ� �س���. >> mouseoption��Ű�� ��ħ
public class template extends JFrame{
	private Container c;
	MakeStructure struct;
	DrawInfo nodeInfo;
	MapPanel panel2;
	public template() { 
		setTitle("���ø� ���� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
				
		creatPane();
		setSize(1050,700);
		setVisible(true);
	}
	
	
	private void creatPane() {
		checkStore chk = new checkStore();
		chk.chk =0;
		JPanel panel1 = new JPanel();
		
		JPanel panel3 = new JPanel();
		JScrollPane scrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		JScrollPane scrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scrollPane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane2,panel3);
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, splitPane2);
		
		
		JTextArea textEditorPane = new JTextArea();
		textEditorPane.setTabSize(2);
		scrollPane1.setViewportView(textEditorPane);
		
		panel1.setLayout(new BorderLayout());
		panel1.add(scrollPane1);
		JLabel label1 = new JLabel("Text Editor Pane");
		label1.setSize(50,50);	
		scrollPane1.setPreferredSize(new Dimension(200, 500));
		scrollPane1.setColumnHeaderView(label1);
		JButton set = new JButton("����");
		panel1.add(set, BorderLayout.SOUTH);
		
		
	
	

		
		
	//-------------------------------------------------------------------------------------------

		
		JLabel label2 = new JLabel("Mind Map Pane");
		label2.setSize(50,50);	
		scrollPane2.setPreferredSize(new Dimension(600, 500));
		scrollPane2.setSize(600, 500);
		
		scrollPane2.setColumnHeaderView(label2);
		
		
		/*
		JLabel test = new JLabel("root");
		test.setSize(50,  20);
		panel2.setLayout(null);
		test.setLocation(50, 50);
		panel2.add(test);
		test.setBackground(Color.BLUE);
		test.setOpaque(true);
		*/
		//test.setVisible(true);
		
	
	//--------------------------------------------------------------------------------------------	
		panel3.setLayout(new BorderLayout());
		panel3.add(scrollPane3);
		JLabel label3 = new JLabel("Atribute Pane");
		label3.setSize(50,50);	
		scrollPane3.setPreferredSize(new Dimension(200, 200));
		scrollPane3.setColumnHeaderView(label3);
		JButton chg = new JButton("����");
		panel3.add(chg, BorderLayout.SOUTH);
		
		JPanel middle = new JPanel();
		
		GridLayout grid = new GridLayout(6,2);
		grid.setVgap(10);
		
		middle.setLayout(grid);
		
		JLabel text = new JLabel("     TEXT");
		JTextField nodeName = new JTextField();
		nodeName.setEditable(false);
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
		
		
		
		//-----------------------------------------------------------------------
		
		c.add(splitPane1);
		JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
		
		//----------------------------------tool---------------------------
		
      //  toolBar.setBackground(Color.LIGHT_GRAY);
        
        JButton newBtn = new JButton("���θ����");
        newBtn.setToolTipText("������ �����մϴ�");
        toolBar.add(newBtn); 
        newBtn.addMouseListener(new MouseListener() {
              public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
             
             textEditorPane.setText(null);
                // String splitList[] = (new SplitByEnter(newTextEditorPane.getText())).Split();
              
///////////////////////////////////////////////////////////////////////
                 
                 
              //new OverLap(struct).OverallOverLap();
                JPanel initial = new  JPanel();
              //panel2 = new JPanel(struct);
              scrollPane2.setViewportView(initial);
           
              }
              public void mouseReleased(MouseEvent e) {}
              public void mouseClicked(MouseEvent e) {}
              public void mouseEntered(MouseEvent e) {}
              public void mouseExited(MouseEvent e) {}
           });// �����޶��� �̷���
        
        JButton openBtn = new JButton("����");
        openBtn.setToolTipText("������ ���ϴ�");
        toolBar.add(openBtn);
       
        
        //////////////////////////////////////////////////
        JButton saveBtn = new JButton("����");
        
        saveBtn.setToolTipText("������ �����մϴ�");
        toolBar.add(saveBtn);
        saveBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
              
              Input tmp = new Input();
              tmp.StoreJson(struct,textEditorPane.getText(), chk);//
             // chk.chk = 1;
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {}
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        
        JButton otherSaveBtn = new JButton("�ٸ��̸����� ����");
        
        otherSaveBtn.setToolTipText("������ �ٸ� �̸����� �����մϴ�");
        toolBar.add(otherSaveBtn);
        otherSaveBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
              chk.chk =0;
              Input tmp = new Input();
              tmp.StoreJson(struct,textEditorPane.getText(),chk);//
              chk.chk =1;
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {}
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        JButton ExitBtn = new JButton("�ݱ�");
        ExitBtn.setToolTipText("���α׷��� �����մϴ�.");
        toolBar.add(ExitBtn);
        ExitBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
              
              System.exit(0);
              
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {}
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        JButton SetBtn = new JButton("����");
        SetBtn.setToolTipText("�ؽ�Ʈ�� ���ε������ �����մϴ�.");
        toolBar.add(SetBtn);
        SetBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
              
              
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {
	           String splitList[] = (new SplitByEnter(textEditorPane.getText())).Split();
	           struct = new MakeStructure(splitList, null);
	           new OverLap(struct).OverallOverLap();
	           
	           panel2 = new MapPanel(struct);
	           scrollPane2.setViewportView(panel2);
	           new ResizePanelSize(struct, panel2);
	           
	           panel2.setLayout(null);
	           nodeInfo = new DrawInfo(struct, panel2);
	           
	           panel2.setVisible(true);
	           RemoveNode remove;
	           panel2.addMouseListener(remove = new RemoveNode(nodeInfo));
				panel2.addMouseMotionListener(remove);
           }
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        
        JButton applybtn = new JButton("����");
	    toolBar.add(applybtn);
	    openBtn.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {   //////��ģ �κ� ���ټ����ϰ� ���콺������
               String saveText;
               Output tmp = new Output();
               text storeText = new text();
               struct = tmp.openJson(struct, storeText);
              
               textEditorPane.setText(storeText.text);
            new OverLap(struct).OverallOverLap();

            panel2 = new MapPanel(struct);
            scrollPane2.setViewportView(panel2);
            new ResizePanelSize(struct, panel2);
            
            panel2.setLayout(null);
            nodeInfo = new DrawInfo(struct, panel2);
            
            panel2.setVisible(true);
            new AddMouseListener(panel2, nodeName, XofNode, YofNode, WofNode, HofNode, ColorofNode, struct, nodeInfo, chg, applybtn);
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
         });
		set.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {	//��ģ �κ�
				
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				
				String splitList[] = (new SplitByEnter(textEditorPane.getText())).Split();
				struct = new MakeStructure(splitList, null);
				new OverLap(struct).OverallOverLap();

				panel2 = new MapPanel(struct);
				scrollPane2.setViewportView(panel2);
				new ResizePanelSize(struct, panel2);
				
				panel2.setLayout(null);
				nodeInfo = new DrawInfo(struct, panel2);
				
				panel2.setVisible(true);
				
				new AddMouseListener(panel2, nodeName, XofNode, YofNode, WofNode, HofNode, ColorofNode, struct, nodeInfo, chg, applybtn);
				RemoveNode remove;
				panel2.addMouseListener(remove = new RemoveNode(nodeInfo));
				panel2.addMouseMotionListener(remove);

			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {
				

			}
		});
       
        

        
        
        c.add(toolBar, BorderLayout.NORTH);
        //-------------------�Ʒ����� �޴�--------------------------------
        JMenuBar mb = new JMenuBar();
        
        
        JMenu Menu = new JMenu("�޴�");
        mb.add(Menu);
        JMenuItem NewMenu = new JMenuItem("���θ����");
        JMenuItem OpenMenu = new JMenuItem("����");
        JMenuItem SaveMenu = new JMenuItem("����");
        JMenuItem OtherSaveMenu = new JMenuItem("�ٸ��̸����� ����");
        JMenuItem ExitMenu = new JMenuItem("�ݱ�");
        JMenuItem SetMenu = new JMenuItem("����");
        JMenuItem ChgMenu = new JMenuItem("����");

        Menu.add(NewMenu);
        Menu.add(OpenMenu);
        Menu.add(SaveMenu);
        Menu.add(OtherSaveMenu);
        Menu.add(ExitMenu);
        Menu.add(SetMenu);
        Menu.add(ChgMenu);
        
        
                 
        setJMenuBar(mb);
		
		
	}

	
	class MapPanel extends JPanel{
		MakeStructure strct;
		public MapPanel(MakeStructure strct) {
			this.strct = strct;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			g.setColor(Color.BLACK);
			//�� ó�� root���� ���ἱ �׸���
			if(strct.treeHeight == 0) {
				for(int i = 0; i < strct.next.length; i++) {
					if (strct.next[i] == null)
						break;
					
					switch(i) {
					case 0:
						x1 = strct.x;
						y1 = strct.y + (int)(strct.height/2);
						x2= strct.next[i].x + strct.next[i].width;
						y2 = strct.next[i].y + (int)(strct.next[i].height/2);
						g.drawLine(x1,  y1,  x2,  y2);
						new DrawKit(strct.next[i]).WestLine(g);
						break;
					
					case 1:
						x1 = strct.x + (int)(strct.width / 2);
						y1 = strct.y;
						x2 = strct.next[i].x + (int)(strct.next[i].width / 2);
						y2 = strct.next[i].y + strct.next[i].height;
						g.drawLine(x1,  y1,  x2,  y2);
						new DrawKit(strct.next[i]).NorthLine(g);
						break;
						
					case 2:
						x1 = strct.x + strct.width;
						y1 = strct.y + (int)(strct.height / 2);
						x2 = strct.next[i].x;
						y2 = strct.next[i].y + (int)(strct.next[i].height / 2);
						g.drawLine(x1,  y1,  x2,  y2);
						new DrawKit(strct.next[i]).EastLine(g);
						break;
						
					case 3:
						x1 = strct.x + (int)(strct.width /2);
						y1 = strct.y + strct.height;
						x2 = strct.next[i].x + (int)(strct.next[i].width / 2);
						y2 = strct.next[i].y;
						g.drawLine(x1,  y1,  x2,  y2);
						new DrawKit(strct.next[i]).SouthLine(g);
						break;
					}
					
				}
			}
			
			else {
				
			}
		}
	}
	
	class RemoveNode extends MouseAdapter{//moved �ȵǸ� entered�غ���
		DrawInfo nodeinfo;
		public RemoveNode(DrawInfo nodeinfo) {
			this.nodeinfo = nodeinfo;
		}
		
		void Remove(DrawInfo nodePointer) {
			DrawInfo tmp = nodePointer;
			for(int i = 0; i < tmp.node.getComponents().length; i++) {
				tmp.node.getComponent(i).setVisible(false);
				//tmp.node.remove(tmp.node.getComponent(i));
			}
			for(int i = 0; i < 4; i++) {
				if (tmp.next[i] == null)
					break;
				Remove(tmp.next[i]);
			}
		}
		public void mouseEntered(MouseEvent e) {
			Remove(nodeinfo);
			}
		public void mouseMoved(MouseEvent e) {
			Remove(nodeinfo);
		}
		}
	


	public static void main(String[] args) {
		new template();
		
	}

}
