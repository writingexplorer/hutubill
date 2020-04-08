package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.GUIUtil;

public class CheckPanel extends JPanel{
	static {
		GUIUtil.useLNF();
	}
     public static CheckPanel instance=new CheckPanel();
     public JLabel lSpend=new JLabel("花费");
     public JTextField tfSpend=new JTextField("");
     public JLabel lDivide=new JLabel("分类");
    List<Category> cs=new CategoryService().list();
    String divide=cs.get(0).name;
    public JLabel Divide=new JLabel(divide);
     public JLabel lbeizhu=new JLabel("备注");
     public JTextField tfbeizhu=new JTextField("");
     public JLabel lDate=new JLabel("日期");
     public JXDatePicker datepicker=new JXDatePicker();
     public JButton bupdate=new JButton("更新");
     private CheckPanel() {
    	 this.setLayout(new BorderLayout());
    	 this.add(north(),BorderLayout.NORTH);
    	 this.add(center(),BorderLayout.CENTER);
     }
     private JPanel north() {
    	 JPanel p=new JPanel();
    	 p.setLayout(new GridLayout(4,2,40,40));
    	 p.add(lSpend);
    	 p.add(tfSpend);
    	 p.add(lDivide);
    	 p.add(Divide);
    	 p.add(lbeizhu);
    	 p.add(tfbeizhu);
    	 p.add(lDate);
    	 p.add(datepicker);
    	 return p;    	 
     }
     public JPanel center() {
    	 JPanel p=new JPanel();
    	 p.add(bupdate);
    	 return p;     
     }
     public static void main(String args[]) {
    	 GUIUtil.showPanel(CheckPanel.instance);
     }
}
