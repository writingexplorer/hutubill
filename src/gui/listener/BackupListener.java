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
    	   //1. �����ж�MYSQL��װ·���Ƿ�����
    	   String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
    	   if(mysqlPath.length()==0) {
    		   JOptionPane.showMessageDialog(p,"�ڱ���ǰ���������ݿ�ı���·��");
    		   MainPanel.instance.workingPanel.show(BackupPanel.instance);
    		   ConfigPanel.instance.tfPath.grabFocus();
    		   return ;
    	   }
 //2. ���ļ�ѡ������ָ��Ҫ������ļ�, �ļ���Ĭ������Ϊhutubill.sql�Ժ�׺��.sql�����ļ�
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
    		 //���������ļ���û����.sql��β���Զ�����.sql
    		   System.out.println(file);
    		   if(!file.getName().toLowerCase().endsWith(".sql"));
    		   System.out.println(file);
    		   try {
    			   MysqlUtil.backup(mysqlPath,file.getAbsolutePath());
    			   JOptionPane.showMessageDialog(p,"���ݳɹ�,�����ļ�λ��:\r\n"+file.getAbsolutePath());    				       			   
    		   }catch(Exception e1) {
    			   e1.printStackTrace();
    			   JOptionPane.showMessageDialog(p, "����ʧ��\r\n,����:\r\n"+e1.getMessage());
    		   }
    		   
    	   }
       }
}
