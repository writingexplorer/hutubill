package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;
//���еĽ��̶��и�������ڣ�һ��˵������΢���ӵ�ĳ��򣬾ͻ���һ���࣬ר�Ÿ������������飬ͨ�����������startup.Bootstrap
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
