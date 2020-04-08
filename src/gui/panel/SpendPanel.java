package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;

import gui.page.SpendPage;
import service.SpendService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

public class SpendPanel extends WorkingPanel{
	static {
    	 GUIUtil.useLNF();
     }
	//��SpendPanel���Ϊ����ģʽ,�����������Ϳ���ͨ������ģʽ��������������
	public static SpendPanel instance=new SpendPanel();
     JLabel lMonthSpend=new JLabel("������");
     JLabel lTodaySpend=new JLabel("������");
     JLabel lPerDayAvgSpend=new JLabel("�վ�����");
     JLabel lMonthLeft=new JLabel("����ʣ��");
     JLabel lDayAvgAvailable=new JLabel("�վ�����");
     JLabel lMonthLeftDay=new JLabel("������ĩ");
     JLabel vMonthSpend=new JLabel("��3000");
     JLabel vTodaySpend=new JLabel("��100");
     JLabel vPerDayAvgSpend=new JLabel("��100");
     JLabel vMonthLeft=new JLabel("��2900");
     JLabel vDayAvgAvailable=new JLabel("��100");
     JLabel vMonthLeftDay=new JLabel("29��");
     
     private  SpendPanel() {
    	 this.setLayout(new BorderLayout());
    	 GUIUtil.setColor(ColorUtil.grayColor,lMonthSpend, lTodaySpend, lPerDayAvgSpend, lMonthLeft,lDayAvgAvailable,
                 lMonthLeftDay, vPerDayAvgSpend, vMonthLeft, vDayAvgAvailable, vMonthLeftDay);
    	 GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
    	 vMonthSpend.setFont(new Font("΢���ź�",Font.BOLD,23));
    	 vTodaySpend.setFont(new Font("΢���ź�",Font.BOLD,23));
    	 this.add(center(),BorderLayout.CENTER);
    	 this.add(south(),BorderLayout.SOUTH);
     }
     private JPanel center() {
    	 JPanel center=new JPanel();
    	 center.setLayout(new BorderLayout());
    	 center.add(west(),BorderLayout.WEST);
    	 center.add(center2(),BorderLayout.CENTER);
    	 return center;
    	
     }
     private JPanel south() {
    	 JPanel p=new JPanel();
    	 p.setLayout(new GridLayout(2,4));
    	 p.add(lPerDayAvgSpend);
    	 p.add(lMonthLeft);
    	 p.add(lDayAvgAvailable);
    	 p.add(lMonthLeftDay);
    	 p.add(vPerDayAvgSpend);
    	 p.add(vMonthLeft);
    	 p.add(vDayAvgAvailable);
    	 p.add(vMonthLeftDay);
    	 return p;  	     	 
     }
     //west()��center2()�ķ���ֵ��ΪComponentҲ������JPanel
     private JPanel west() {
    	 JPanel p=new JPanel();
    	 p.setLayout(new GridLayout(4,1));
    	 p.add(lMonthSpend);
    	 p.add(vMonthSpend);
    	 p.add(lTodaySpend);
    	 p.add(vTodaySpend);
    	 return p;       	 
     }
    CircleProgressBar cb=new CircleProgressBar();
     private JPanel center2() { 
    	 
    	 cb.setBackgroundColor(ColorUtil.blueColor);
    	 cb.setProgress(20);
    	return cb;
       
     }
     public void addListener() {   	 
     }
     public void updateData() {
    	 SpendPage sp=new SpendService().getSpendPage();
    	 vTodaySpend.setText(sp.daySpend);
    	 vMonthSpend.setText(sp.monthSpend);
    	 vPerDayAvgSpend.setText(sp.dayAvergeSpend);
    	 vDayAvgAvailable.setText(sp.dayAvergeAvailable);
    	 vMonthLeft.setText(sp.thisMonthLeft);
    	 vMonthLeftDay.setText(sp.dayMonthLeft);
    	 cb.setProgress(sp.usagePercentage);
    	 if(sp.isOverSpend) {
    		 vMonthLeft.setForeground(ColorUtil.warningColor);
    		 vDayAvgAvailable.setForeground(ColorUtil.warningColor);
    	     vMonthSpend.setForeground(ColorUtil.warningColor);
    	 }
    	 else {
    		 vMonthLeft.setForeground(ColorUtil.blueColor);
    		 vDayAvgAvailable.setForeground(ColorUtil.blueColor);
    	     vMonthSpend.setForeground(ColorUtil.blueColor);
    	 }
    	 cb.setForegroundColor(ColorUtil.getByPercentage(sp.usagePercentage));
    	 addListener();
     }
     public static void main(String[] args) {
         
         GUIUtil.showPanel(SpendPanel.instance);
     }
}
