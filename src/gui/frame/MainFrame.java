package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;
//ǰ�����Ľ����඼������࣬���ܶ������С� ������Ŀ�����У�������Ҫһ������������ JFrame��������Щ����ࡣ
//����������ͨ��setContentPane��MainPanel����Ϊ�������
public class MainFrame extends JFrame{
       public static MainFrame instance=new MainFrame();
       private MainFrame() {
    	   this.setSize(500, 500);
    	   this.setTitle("һ����Ϳ��");
    	   this.setContentPane(MainPanel.instance);
    	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   //����
    	   this.setLocationRelativeTo(null);
           //���ߴ���Ϊ���ɱ�
    	   this.setResizable(false);
           
       }
       public static void main(String args[]) {
    	   instance.setVisible(true);
       }
}
