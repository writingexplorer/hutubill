package gui.panel;

import javax.swing.*;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel{
    static {
    	GUIUtil.useLNF();
    }
    public static BackupPanel instance=new BackupPanel();
    JButton b=new JButton("±¸·Ý");
    private BackupPanel() {   
    	this.add(b);
    	GUIUtil.setColor(ColorUtil.blueColor, b); 
    	addListener();
    }
    public static void main(String args[]) {
    	GUIUtil.showPanel(instance);
    }
    public void updateData() {
    	
    }
    public void addListener() {
    	BackupListener listener=new BackupListener();
    	b.addActionListener(listener);
    }
}
