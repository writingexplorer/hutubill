package gui.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
//ר�����ھ��е����CenterPanel,��������JFrame�����Ч��
/*
show(JComponent c)
ʹ��show������ʾ���,show�����е�˼·�ǣ� �Ȱ���������е�������Ƴ���Ȼ����µ�����ӽ��������ҵ���updateUI���н�����Ⱦ��
updateUI�ᵼ��swingȥ����repaint()������
repaint()
��repaint�����У��ͻ�ʹ�þ��Զ�λ�ķ�ʽ����������м�λ�á�
���strech��true���ͻ�������������Ĵ�С����������Ĵ�С���ﵽ�����Ч��
���strech��false, ��ʹ�������preferredSize����������Ч����*/
public class CenterPanel extends JPanel{
        private double rate;//�������
        private JComponent c;//��ʾ�����
        private boolean strech;//�����Ƿ�����
        public CenterPanel(double rate,boolean strech) {
        	this.setLayout(null);
        	this.rate=rate;
        	this.strech=strech;
        	
        }
        public CenterPanel(double rate) {
        	this(rate,true);       	
        }
        //���Զ�λ����
        public void repaint() {
        	if(c!=null) {
        		Dimension DimensionSize=this.getSize();
        		//�����ǻ�ȡ�Զ���ߴ磬�����������̬�ߴ�
        		Dimension componentSize=c.getPreferredSize();
        		//Ϊʲô����ʱ����setLocation���У�
        		if(strech) {
        			c.setSize((int)(DimensionSize.width*rate),
        					(int)(DimensionSize.height*rate));        			
        		}
        		//������ʱֻ����
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
