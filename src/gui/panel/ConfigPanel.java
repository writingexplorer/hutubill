package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel{
     static {
    	 GUIUtil.useLNF();
     }
     public static ConfigPanel instance=new ConfigPanel();
     JButton b=new JButton("更新");
     public JLabel lBudget=new JLabel("本月预算");
     public JTextField tfBudget=new JTextField();
     public JLabel lpath=new JLabel("Mysql安装目录");
     public JTextField tfPath=new JTextField();
     private ConfigPanel() {    	
    	 JPanel p=new JPanel();
    	 p.add(b);
    	 GUIUtil.setColor(ColorUtil.grayColor,lBudget,tfBudget,lpath,tfPath);
    	GUIUtil.setColor(ColorUtil.blueColor,b);
    	 this.setLayout(new BorderLayout());
    	 this.add(north(),BorderLayout.NORTH);
    	 this.add(p,BorderLayout.CENTER);
    	 addListener();
     }
     private JPanel north() {
    	 JPanel p=new JPanel();
    	 p.setLayout(new GridLayout(4,1,40,40));
    	 p.add(lBudget);
    	 p.add(tfBudget);
    	 p.add(lpath);
    	 p.add(tfPath);
    	 return p;
     }
     public void updateData() {
    	 String budget=new ConfigService().get(ConfigService.budget);
    	 String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
    	 tfBudget.setText(budget);
    	 tfPath.setText(mysqlPath);
    	 tfBudget.grabFocus();
     }
     public void addListener() {
         ConfigListener l =new ConfigListener();
         b.addActionListener(l);
     }
     public static void main(String[] args) {
         GUIUtil.showPanel(ConfigPanel.instance);
     }
}
