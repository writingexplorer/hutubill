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
        	JButton bSpend=new JButton("消费一览");
        	JButton bRecord =new JButton("消费记录");
        	JButton bCategory=new JButton("消费分类");
        	JButton bMonthSpend=new JButton("月消费报表");
        	JButton bSet=new JButton("设置");
        	JButton bBackup=new JButton("备份");
        	JButton bRecover=new JButton("恢复");
        	
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
