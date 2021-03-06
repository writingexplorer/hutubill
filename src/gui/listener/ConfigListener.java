package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener{
	   @Override
	    public void actionPerformed(ActionEvent e) {
	        ConfigPanel p = ConfigPanel.instance;
	        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
	            return;
	        String mysqlPath =p.tfPath.getText();
	        if(0!=mysqlPath.length()){
	            File commandFile = new File(mysqlPath,"bin/mysql.exe");
	            if(!commandFile.exists()){
	                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
	                p.tfPath.grabFocus();
	                return;
	            }
	        }
	         
	        ConfigService cs= new ConfigService();
	        cs.update(ConfigService.budget,p.tfBudget.getText());
	        cs.update(ConfigService.mysqlPath,mysqlPath);
	         
	        JOptionPane.showMessageDialog(p, "设置修改成功");
	        p.updateData();
	    }
	 

}
