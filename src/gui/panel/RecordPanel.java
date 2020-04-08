package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.*;

import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
public class RecordPanel extends WorkingPanel{
   static {
	   GUIUtil.useLNF();
   }
   public static RecordPanel instance=new RecordPanel();
   JLabel lSpend=new JLabel("花费");
   public JTextField tfSpend1=new JTextField();
   JLabel diversity=new JLabel("分类");
   public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
   public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
   JLabel beizhu=new JLabel("备注");
   public JTextField tfbeizhu=new JTextField();
   JLabel lDate=new JLabel("日期");
   public JXDatePicker datePick=new JXDatePicker();
   private RecordPanel() {
	   this.setLayout(new BorderLayout());
	   this.add(north(),BorderLayout.NORTH);
	   this.add(center(),BorderLayout.CENTER);
	   addListener();
   }
   public JButton b=new JButton("记一笔");
   private Component center() {
	   JPanel p=new JPanel();
	   
	   p.add(b);
	 return p;
   }
   private JPanel north() {
	   JPanel p=new JPanel();
	   p.setLayout(new GridLayout(4,2,40,40));
	   p.add(lSpend);
	   p.add(tfSpend1);
	   p.add(diversity);
	   p.add(cbCategory);
	   p.add(beizhu);
	   p.add(tfbeizhu);
	   p.add(lDate);
	   p.add(datePick);	   
	   return p;
   }
   public Category getSelectedCategory() {
  	 return (Category)cbCategory.getSelectedItem();
   }
   public void updateData() {
	   cbModel.combos = new CategoryService().list();
       cbCategory.updateUI();
       resetInput();
       tfSpend1.grabFocus();
   }
   //每次输入后重置数据
   public void resetInput(){
       tfSpend1.setText("0");
       tfbeizhu.setText("");
       if(0!=cbModel.combos.size())
           cbCategory.setSelectedIndex(0);
       datePick.setDate(new Date());
   }  
	   public void addListener() {
		   RecordListener listener=new RecordListener();
		   b.addActionListener(listener);
	   }
   public static void main(String args[]) {
	 GUIUtil.showPanel(RecordPanel.instance);  
  }
}
 