package template;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*; 
import java.awt.*;


public class AllListener extends JFrame{
	JButton j ;
	JFileChooser t;
	AllListener(JButton j, JFileChooser t){
		this.j = j;
		this.t= t;
		j.addActionListener(new MyActionListener( t));
	}
	
	
}
class MyActionListener implements ActionListener{

	JFileChooser t;
	MyActionListener(JFileChooser t){

		this.t= t;
	}
	public void actionPerformed(ActionEvent e) {
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG&GIF Images","jpg","gif");
       // t.setFileFilter(filter);
        
        int ret=t.showOpenDialog(null);
        if(ret!=JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String filePath=t.getSelectedFile().getPath();
		System.out.println(filePath);
	}

}

