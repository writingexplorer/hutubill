package gui.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
//专门用于居中的面板CenterPanel,并且有随JFrame拉伸的效果
/*
show(JComponent c)
使用show方法显示组件,show方法中的思路是： 先把这个容器中的组件都移出，然后把新的组件加进来，并且调用updateUI进行界面渲染。
updateUI会导致swing去调用repaint()方法。
repaint()
在repaint方法中，就会使用绝对定位的方式把组件放在中间位置。
如果strech是true，就会根据整个容器的大小，设置组件的大小，达到拉伸的效果
如果strech是false, 就使用组件的preferredSize，即非拉伸效果。*/
public class CenterPanel extends JPanel{
        private double rate;//拉伸比例
        private JComponent c;//显示的组件
        private boolean strech;//决定是否拉伸
        public CenterPanel(double rate,boolean strech) {
        	this.setLayout(null);
        	this.rate=rate;
        	this.strech=strech;
        	
        }
        public CenterPanel(double rate) {
        	this(rate,true);       	
        }
        //绝对定位函数
        public void repaint() {
        	if(c!=null) {
        		Dimension DimensionSize=this.getSize();
        		//这里是获取自定义尺寸，而不是组件动态尺寸
        		Dimension componentSize=c.getPreferredSize();
        		//为什么拉伸时不用setLocation居中？
        		if(strech) {
        			c.setSize((int)(DimensionSize.width*rate),
        					(int)(DimensionSize.height*rate));        			
        		}
        		//不拉伸时只居中
        		else {
        			c.setSize(componentSize);
        			}
        			c.setLocation((DimensionSize.width-c.getSize().width)/2,
        					(DimensionSize.height-c.getSize().height)/2);
        		
        	}
        }
        public void show(JComponent p) {
        	this.c=p;
        	Component cs[]=getComponents();
        	for(Component c:cs) {
        		remove(c);
        	}
        	add(p);
        	if(p instanceof WorkingPanel)
        		((WorkingPanel)p).updateData();
        	this.updateUI();
        }
        public static void main(String[] args) {
            JFrame f = new JFrame();
            f.setSize(200, 200);
            f.setLocationRelativeTo(null);     
            CenterPanel cp = new CenterPanel(0.85,true);
             f.add(cp);            
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            JButton b=new JButton("abc");   
             cp.show(b);
            JButton ba=new JButton("a"); 
        }
        
        
}
