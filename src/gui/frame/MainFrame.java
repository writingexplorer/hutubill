package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;
//前面做的界面类都是面板类，不能独立运行。 整个项目的运行，还是需要一个顶级容器类 JFrame来容纳这些面板类。
//在主窗体中通过setContentPane把MainPanel设置为内容面板
public class MainFrame extends JFrame{
       public static MainFrame instance=new MainFrame();
       private MainFrame() {
    	   this.setSize(500, 500);
    	   this.setTitle("一本糊涂账");
    	   this.setContentPane(MainPanel.instance);
    	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   //居中
    	   this.setLocationRelativeTo(null);
           //将尺寸设为不可变
    	   this.setResizable(false);
           
       }
       public static void main(String args[]) {
    	   instance.setVisible(true);
       }
}
