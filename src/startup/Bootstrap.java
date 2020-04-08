package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;
//所有的进程都有个启动入口，一般说来，稍微复杂点的程序，就会有一个类，专门负责启动的事情，通常这个类会叫做startup.Bootstrap
public class Bootstrap {
	public static void main(String[] args) throws Exception{
    	GUIUtil.useLNF();
    
    SwingUtilities.invokeAndWait(new Runnable() {
    	public void run() {
    		MainFrame.instance.setVisible(true);
    	MainPanel.instance.workingPanel.show(SpendPanel.instance);
    	}
    });
	}
    
}
