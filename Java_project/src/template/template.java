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
//2. 위에있는 변경만
//color 5자리일 때 고치기
//=======================================밑 : 해결====================================================
//3. (인호)color 반전 >>> makestructure이랑 nodemouselitener바꿈
//가끔 axis edge노드 남아있는거 >>> templete수정(클래하나 생성, 적용버튼 클릭했을 때 리스너 두개 추가)
//resizepanel수정
//5. 가끔 자리배치 안될 경우가 있음. >>> overlap클래스 고침
//크기조절할때 가끔 위치이동되는거 원인 파악 필요! >> edge, axel 클래스 고침
//1. 트리구조안에 color를 getRGB int형으로 저장하는거. 그러면 불러왓을때도 getRGB >> background설정하는거 필요 >>>> 4번으로 수정
//4. COLOR getr getg getb 16진수로ㅇ >>> 트리구조에 r,g,b값 저장할 수 있게 해놓음. >> mouseoption패키지 고침
public class template extends JFrame{
	private Container c;
	MakeStructure struct;
	DrawInfo nodeInfo;
	MapPanel panel2;
	public template() { 
		setTitle("스플릿 페인 만들기");
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
		JButton set = new JButton("적용");
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
		JButton chg = new JButton("변경");
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
        
        JButton newBtn = new JButton("새로만들기");
        newBtn.setToolTipText("파일을 생성합니다");
        toolBar.add(newBtn); 
        newBtn.addMouseListener(new MouseListener() {
              public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
             
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
           });// 툴팁달때는 이렇게
        
        JButton openBtn = new JButton("열기");
        openBtn.setToolTipText("파일을 엽니다");
        toolBar.add(openBtn);
       
        
        //////////////////////////////////////////////////
        JButton saveBtn = new JButton("저장");
        
        saveBtn.setToolTipText("파일을 저장합니다");
        toolBar.add(saveBtn);
        saveBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
              
              Input tmp = new Input();
              tmp.StoreJson(struct,textEditorPane.getText(), chk);//
             // chk.chk = 1;
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {}
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        
        JButton otherSaveBtn = new JButton("다른이름으로 저장");
        
        otherSaveBtn.setToolTipText("파일을 다른 이름으로 저장합니다");
        toolBar.add(otherSaveBtn);
        otherSaveBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
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
        JButton ExitBtn = new JButton("닫기");
        ExitBtn.setToolTipText("프로그램을 종료합니다.");
        toolBar.add(ExitBtn);
        ExitBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
              
              System.exit(0);
              
           }
           public void mouseReleased(MouseEvent e) {}
           public void mouseClicked(MouseEvent e) {}
           public void mouseEntered(MouseEvent e) {}
           public void mouseExited(MouseEvent e) {}
        });
        JButton SetBtn = new JButton("적용");
        SetBtn.setToolTipText("텍스트를 마인드맵으로 적용합니다.");
        toolBar.add(SetBtn);
        SetBtn.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
              
              
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
        
        JButton applybtn = new JButton("변경");
	    toolBar.add(applybtn);
	    openBtn.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {   //////고친 부분 툴바수정하고 마우스리스너
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
			public void mousePressed(MouseEvent e) {	//고친 부분
				
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
        //-------------------아래부터 메뉴--------------------------------
        JMenuBar mb = new JMenuBar();
        
        
        JMenu Menu = new JMenu("메뉴");
        mb.add(Menu);
        JMenuItem NewMenu = new JMenuItem("새로만들기");
        JMenuItem OpenMenu = new JMenuItem("열기");
        JMenuItem SaveMenu = new JMenuItem("저장");
        JMenuItem OtherSaveMenu = new JMenuItem("다른이름으로 저장");
        JMenuItem ExitMenu = new JMenuItem("닫기");
        JMenuItem SetMenu = new JMenuItem("적용");
        JMenuItem ChgMenu = new JMenuItem("변경");

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
			//맨 처음 root와의 연결선 그리기
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
	
	class RemoveNode extends MouseAdapter{//moved 안되면 entered해보기
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
