package util;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import javax.swing.*;
import gui.panel.CenterPanel;
public class GUIUtil {
	//��������������Ƿ�Ϊ��
      public static boolean checkEmpty(JTextField tf,String input) {
               String str=tf.getText().trim();
               if(str.length()==0) {
            	   JOptionPane.showMessageDialog(null,input+"����Ϊ��");
            	   tf.grabFocus();
            	   return false;
               }
             return true;
      }
      //У��һ����������Ƿ������ָ�ʽ
      public static boolean checkNumber(JTextField tf,String input) {
    	  if (!checkEmpty(tf, input))
    	        return false;
    	  String str=tf.getText().trim();
    	  try {
    		  Integer.parseInt(str);
    		  return true;
    	  }catch(NumberFormatException e) {
    		  e.printStackTrace();
    		  JOptionPane.showMessageDialog(null, input+"����������");
    		  tf.grabFocus();
    		  return false;
    	  }
      }
      //����һ������������Ƿ�����
      public static boolean checkZero(JTextField tf,String input) {
    	  if(!checkNumber(tf,input)) {
    		  return false;
    	  }
    	  String str=tf.getText().trim();
    	  if(Integer.parseInt(str)==0) {
    		  JOptionPane.showMessageDialog(null, input+"����Ϊ��");
    		  tf.grabFocus();
    		  return false;
    	  }
    	  return true;
      }
      //�������������ǰ��ɫ
      public static void setColor(Color color,JComponent...cs) {
    	  for(JComponent c:cs) {
    		  c.setForeground(color);
    	  }
      }
     
      //����ť����ͼ���Լ���ʾ����
      private static String imageFolder = "d:/java����/img";
      public static void setImageIcon(JButton b,String Filename,String tip) {
    	  ImageIcon i=new ImageIcon(new File(imageFolder,Filename).getAbsolutePath());
    	  b.setIcon(i);
    	  b.setPreferredSize(new Dimension(61,81));
    	  //���������Label��ͣ��ʱ��ʾ��ʾ��Ϣ��
    	  b.setToolTipText(tip);
    	  //���ñ�ǩ���ı������ͼ��Ĵ�ֱλ��,JButton.Bottom��Ϊ�ײ�
    	  b.setVerticalTextPosition(JButton.BOTTOM);
    	  //���ñ�ǩ���ı������ͼ���ˮƽλ��,centerΪ���м�
    	  b.setHorizontalTextPosition(JButton.CENTER);
    	  //���ð�ť����
    	  b.setText(tip);
      }
      //ʹ��ˮ��Ƥ��
      public static void useLNF() {
     try 
      { javax.swing.UIManager.setLookAndFeel(
    		  "com.birosoft.liquid.LiquidLookAndFeel");   	 
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      }
      //������ʾһ���������ݣ�����ǰ���½ڵ�ѧϰ������֪��������Ŀ��滮һ��һ���Ķ��������Panel�� 
      //������屾���ܶ�����ʾ����������׼����ôһ��showPanel�������Ϳ��Ժܷ������ʾ��Щ����ˡ� 
      public static void showPanel(JPanel p,double strech) {
    	    GUIUtil.useLNF();
    	    JFrame f = new JFrame();
    	    f.setSize(500, 500);
    	    f.setLocationRelativeTo(null);
    	    CenterPanel cp = new CenterPanel(strech);
    	    f.setContentPane(cp);
    	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    f.setVisible(true);
    	    cp.show(p);
    	}
      public static void showPanel(JPanel p) {
    	    showPanel(p,0.85);
    	}  
}
