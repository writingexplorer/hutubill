package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener{
       public void actionPerformed(ActionEvent e) {
    	   BackupPanel p=BackupPanel.instance;
    	   //1. 首先判断MYSQL安装路径是否配置
    	   String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
    	   if(mysqlPath.length()==0) {
    		   JOptionPane.showMessageDialog(p,"在备份前请输入数据库的备份路径");
    		   MainPanel.instance.workingPanel.show(BackupPanel.instance);
    		   ConfigPanel.instance.tfPath.grabFocus();
    		   return ;
    	   }
 //2. 打开文件选择器，指定要保存的文件, 文件名默认设置为hutubill.sql以后缀名.sql过滤文件
    	   JFileChooser fc=new JFileChooser();
    	   fc.setSelectedFile(new File("hutubill1.sql"));
    	   fc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {			
				return f.getName().toLowerCase().endsWith(".sql");
			}
			@Override
			public String getDescription() {				
				return ".sql";
			}   		   
    	   });
    	   int returnVal=fc.showSaveDialog(p);
    	   File file=fc.getSelectedFile();
    	   System.out.println(file);
    	   if(returnVal==JFileChooser.APPROVE_OPTION) {
    		 //如果保存的文件名没有以.sql结尾，自动加上.sql
    		   System.out.println(file);
    		   if(!file.getName().toLowerCase().endsWith(".sql"));
    		   System.out.println(file);
    		   try {
    			   MysqlUtil.backup(mysqlPath,file.getAbsolutePath());
    			   JOptionPane.showMessageDialog(p,"备份成功,备份文件位于:\r\n"+file.getAbsolutePath());    				       			   
    		   }catch(Exception e1) {
    			   e1.printStackTrace();
    			   JOptionPane.showMessageDialog(p, "备份失败\r\n,错误:\r\n"+e1.getMessage());
    		   }
    		   
    	   }
       }
}
