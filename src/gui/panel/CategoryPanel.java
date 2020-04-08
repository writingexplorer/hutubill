package gui.panel;

import java.awt.BorderLayout;
import javax.swing.*;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryModel;
import service.CategoryService;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel {
     static {
    	 GUIUtil.useLNF();
     } 
        public JButton bAdd=new JButton("新增");
    	public JButton bEdit=new JButton("编辑");
    	public JButton bDelete=new JButton("删除");
    	 public CategoryModel cm = new CategoryModel();
     public static CategoryPanel instance=new CategoryPanel();
     private CategoryPanel() { 
    	 JScrollPane sp=new JScrollPane(t);
    	 this.setLayout(new BorderLayout());
    	 this.add(sp,BorderLayout.CENTER);
    	 this.add(south(),BorderLayout.SOUTH);
    	 addListener();
     }
     public JTable t=new JTable(cm);
     
     private JPanel south() {    	
    	 JPanel p=new JPanel();
    	 p.add(bAdd);
    	 p.add(bEdit);
    	 p.add(bDelete);
    	 return p;
    	 }
     //1. 为CategoryPanel新增加一个getSelectedCategory，方便获取JTable上当前选中的Category对象
 
     public Category getSelectedCategory() {
         int index = t.getSelectedRow();
         return cm.cs.get(index);
     }
     //2. 增加一个updateData方法，用于在增加，删除，和修改之后，更新表格中的信息，并默认选中第一行。 
     //除此之外，还进行判断，如果表格里没有数据，删除和修改按钮不可使用。
     public void updateData() {
       cm.cs=new CategoryService().list();
       t.updateUI();
       t.getSelectionModel().setSelectionInterval(0, 0);
       if(0==cm.cs.size()) {
    	   bEdit.setEnabled(false);
    	   bDelete.setEnabled(false);
       }
       else {
    	   bEdit.setEnabled(true);
    	   bDelete.setEnabled(true);
       }
     }
    
     public  void addListener() {
    	 CategoryListener listener=new CategoryListener();
    	 bAdd.addActionListener(listener);
    	 bEdit.addActionListener(listener);
    	 bDelete.addActionListener(listener);
     }
     public static void main(String args[]) {
    	 GUIUtil.showPanel(instance);
     }
}
