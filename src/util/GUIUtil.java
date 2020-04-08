package util;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import javax.swing.*;
import gui.panel.CenterPanel;
public class GUIUtil {
	//检验输入框内容是否为空
      public static boolean checkEmpty(JTextField tf,String input) {
               String str=tf.getText().trim();
               if(str.length()==0) {
            	   JOptionPane.showMessageDialog(null,input+"不能为空");
            	   tf.grabFocus();
            	   return false;
               }
             return true;
      }
      //校验一个组件内容是否是数字格式
      public static boolean checkNumber(JTextField tf,String input) {
    	  if (!checkEmpty(tf, input))
    	        return false;
    	  String str=tf.getText().trim();
    	  try {
    		  Integer.parseInt(str);
    		  return true;
    	  }catch(NumberFormatException e) {
    		  e.printStackTrace();
    		  JOptionPane.showMessageDialog(null, input+"必须是整数");
    		  tf.grabFocus();
    		  return false;
    	  }
      }
      //检验一个组件的内容是否是零
      public static boolean checkZero(JTextField tf,String input) {
    	  if(!checkNumber(tf,input)) {
    		  return false;
    	  }
    	  String str=tf.getText().trim();
    	  if(Integer.parseInt(str)==0) {
    		  JOptionPane.showMessageDialog(null, input+"不能为零");
    		  tf.grabFocus();
    		  return false;
    	  }
    	  return true;
      }
      //给多个窗体设置前景色
      public static void setColor(Color color,JComponent...cs) {
    	  for(JComponent c:cs) {
    		  c.setForeground(color);
    	  }
      }
     
      //给按钮设置图标以及提示文字
      private static String imageFolder = "d:/java测试/img";
      public static void setImageIcon(JButton b,String Filename,String tip) {
    	  ImageIcon i=new ImageIcon(new File(imageFolder,Filename).getAbsolutePath());
    	  b.setIcon(i);
    	  b.setPreferredSize(new Dimension(61,81));
    	  //设置鼠标在Label上停留时显示提示信息的
    	  b.setToolTipText(tip);
    	  //设置标签的文本相对其图像的垂直位置,JButton.Bottom即为底部
    	  b.setVerticalTextPosition(JButton.BOTTOM);
    	  //设置标签的文本相对其图像的水平位置,center为正中间
    	  b.setHorizontalTextPosition(JButton.CENTER);
    	  //设置按钮文字
    	  b.setText(tip);
      }
      //使用水晶皮肤
      public static void useLNF() {
     try 
      { javax.swing.UIManager.setLookAndFeel(
    		  "com.birosoft.liquid.LiquidLookAndFeel");   	 
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      }
      //快速显示一个面板的内容，根据前面章节的学习，我们知道，本项目会规划一个一个的独立的面板Panel。 
      //但是面板本身不能独立显示出来，所以准备这么一个showPanel方法，就可以很方便的显示这些面板了。 
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
