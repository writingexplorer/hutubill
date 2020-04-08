package gui.panel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel{
	static {
    	GUIUtil.useLNF();
    }
    public static RecoverPanel instance=new RecoverPanel();
    JButton b=new JButton("»Ö¸´");
    private RecoverPanel() {
    	b.setPreferredSize(new Dimension(100,40));
    	this.add(b);
    	GUIUtil.setColor(ColorUtil.blueColor, b); 
    	addListener();
    }
    public void addListener() {
    	RecoverListener p=new RecoverListener();
    	b.addActionListener(p);
    }
    public void updateData() {
    	
    }
    public static void main(String args[]) {
    	GUIUtil.showPanel(instance);
    }
}
