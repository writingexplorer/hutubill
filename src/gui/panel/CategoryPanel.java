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
        public JButton bAdd=new JButton("����");
    	public JButton bEdit=new JButton("�༭");
    	public JButton bDelete=new JButton("ɾ��");
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
     //1. ΪCategoryPanel������һ��getSelectedCategory�������ȡJTable�ϵ�ǰѡ�е�Category����
 
     public Category getSelectedCategory() {
         int index = t.getSelectedRow();
         return cm.cs.get(index);
     }
     //2. ����һ��updateData���������������ӣ�ɾ�������޸�֮�󣬸��±���е���Ϣ����Ĭ��ѡ�е�һ�С� 
     //����֮�⣬�������жϣ���������û�����ݣ�ɾ�����޸İ�ť����ʹ�á�
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
