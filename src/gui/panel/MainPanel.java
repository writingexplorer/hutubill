package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.GUIUtil;

public class MainPanel extends JPanel{
    static {   	
    	GUIUtil.useLNF();    	    	
    }
   public static MainPanel instance = new MainPanel();
    JToolBar tb=new JToolBar();
    public JButton bSpend=new JButton();
    public JButton bRecord=new JButton();
	public JButton bCategory=new JButton("消费分类");
	public JButton bMonthSpend=new JButton("月消费报表");
	public JButton bSet=new JButton("设置");
	public JButton bBackup=new JButton("备份");
	public JButton bRecover=new JButton("恢复");
	public CenterPanel workingPanel;
   private MainPanel() {
	GUIUtil.setImageIcon(bSpend,"home.png","消费一览");
	GUIUtil.setImageIcon(bRecord, "record.png","记账");
	GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
	GUIUtil.setImageIcon(bMonthSpend, "report.png","月消费报表");
	GUIUtil.setImageIcon(bSet,"config.png", "设置");
	GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
	GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
	tb.add(bSpend);
    tb.add(bRecord);
    tb.add(bCategory);
    tb.add(bMonthSpend);
    tb.add(bSet);
    tb.add(bBackup);
    tb.add(bRecover);
    //设置工具栏移动为失败
    tb.setFloatable(false);
    workingPanel=new CenterPanel(0.8);
   setLayout(new BorderLayout());
    add(tb,BorderLayout.NORTH);
   add(workingPanel,BorderLayout.CENTER);
   addListener();
    }
   private void addListener() {
       ToolBarListener listener = new ToolBarListener();
        
       bSpend.addActionListener(listener);
       bRecord.addActionListener(listener);
       bCategory.addActionListener(listener);
       bMonthSpend.addActionListener(listener);
       bSet.addActionListener(listener);
       bBackup.addActionListener(listener);
       bRecover.addActionListener(listener);
        
   }
   public static void main(String[] args) {
       GUIUtil.showPanel(MainPanel.instance, 1);
   }
}
