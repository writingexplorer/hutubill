package gui.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Hutumain {
         public static void main(String args[]) {
        	 JFrame f=new JFrame();
        	 f.setLayout(new BorderLayout());
        	 f.setSize(500,400);
        	f.setLocation(200, 200);
        	JToolBar tb=new JToolBar();
        	JButton bSpend=new JButton("����һ��");
        	JButton bRecord =new JButton("���Ѽ�¼");
        	JButton bCategory=new JButton("���ѷ���");
        	JButton bMonthSpend=new JButton("�����ѱ���");
        	JButton bSet=new JButton("����");
        	JButton bBackup=new JButton("����");
        	JButton bRecover=new JButton("�ָ�");
        	
        	tb.add(bSpend);
        	tb.add(bRecord);
        	tb.add(bCategory);
        	tb.add(bMonthSpend);
        	tb.add(bSet);
        	tb.add(bBackup);
        	tb.add(bRecover);
        	f.add(tb,BorderLayout.NORTH);
        	f.add(new JPanel(),BorderLayout.CENTER);
        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	f.setVisible(true);
        	bSpend.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bRecord.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bCategory.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bMonthSpend.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bSet.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bBackup.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	bRecover.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			
        		}
        	});
        	
         
         
         
         
         
            
         
         
         }
         
           
}
