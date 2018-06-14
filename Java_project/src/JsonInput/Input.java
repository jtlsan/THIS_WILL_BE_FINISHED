package JsonInput;

import java.awt.Color;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.json.simple.*;
import Structure.*;
import template.checkStore;


public class Input {
   
   public void StoreJson(MakeStructure root, String text, checkStore chk) {
      
      JSONObject start=new JSONObject();
      if (chk.chk == 0) {
      JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON","json","gif");
        chooser.setFileFilter(filter);
        
        int ret=chooser.showSaveDialog(null);
        if(ret!=JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        chk.filePath =chooser.getSelectedFile().getPath();
        chk.filePath = chk.filePath + ".json";
        chk.chk = 1;
      }
        start.put("text", text);
      JsonMaker(root, start);
      
      try { 
         FileWriter file = new FileWriter(chk.filePath);
           file.write(start.toJSONString());
           file.flush();
           file.close();
       } 
      catch(IOException e) {
          e.printStackTrace();
       }
      
      
   }
    void JsonMaker(MakeStructure a, JSONObject start){
      
      JSONArray next = new JSONArray();
       
       boolean flagNull = false;
       for(int  i = 0 ; i < 4; i++)
       {
          if(a.next[i] == null)
          {
             if(i == 0)
                flagNull = true;
             break;
          }
          else
          {
             JSONObject node=new JSONObject();
             JsonMaker(a.next[i] , node);
             next.add(node);
          }
       }
       start.put("treeHeight", a.treeHeight);
          start.put("x", a.x);
          start.put("y", a.y);
        start.put("width", a.width);
         start.put("height", a.height);
        start.put("r", a.r);
        start.put("g", a.g);
        start.put("b", a.b);
          start.put("name", a.name);
       if(flagNull)
          start.put("Next",null);
       else
          start.put("Next",next);
       
      
      
      
      
      
      
      
      
      
      
      
      
      
//       JSONArray next = new JSONArray();
//        
//       
//          start.put("treeHeight", a.treeHeight);
//          start.put("x", a.x);
//          start.put("y", a.y);
//        start.put("width", a.width);
//         start.put("height", a.height);
//        start.put("color", a.background);
//          start.put("name", a.name);
//                  
//         for(int i=0; i<4; i++) {
//                if(a.next[i] == null) {
//                  //start.put("Next", );
//                   return;
//                }
//                else {
//                   start.put("Next", next);
//                   JSONObject node=new JSONObject();
//                   
//                   next.add(node);
//                   JsonMaker(a.next[i], node);
//                }
//         }
       
     }
}