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
	//把SpendPanel设计为单例模式,这样监听器就可以通过单例模式的面板访问主件了
	public static SpendPanel instance=new SpendPanel();
     JLabel lMonthSpend=new JLabel("月消费");
     JLabel lTodaySpend=new JLabel("日消费");
     JLabel lPerDayAvgSpend=new JLabel("日均消费");
     JLabel lMonthLeft=new JLabel("本月剩余");
     JLabel lDayAvgAvailable=new JLabel("日均可用");
     JLabel lMonthLeftDay=new JLabel("距离月末");
     JLabel vMonthSpend=new JLabel("￥3000");
     JLabel vTodaySpend=new JLabel("￥100");
     JLabel vPerDayAvgSpend=new JLabel("￥100");
     JLabel vMonthLeft=new JLabel("￥2900");
     JLabel vDayAvgAvailable=new JLabel("￥100");
     JLabel vMonthLeftDay=new JLabel("29日");
     
     private  SpendPanel() {
    	 this.setLayout(new BorderLayout());
    	 GUIUtil.setColor(ColorUtil.grayColor,lMonthSpend, lTodaySpend, lPerDayAvgSpend, lMonthLeft,lDayAvgAvailable,
                 lMonthLeftDay, vPerDayAvgSpend, vMonthLeft, vDayAvgAvailable, vMonthLeftDay);
    	 GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
    	 vMonthSpend.setFont(new Font("微软雅黑",Font.BOLD,23));
    	 vTodaySpend.setFont(new Font("微软雅黑",Font.BOLD,23));
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
     //west()和center2()的返回值均为Component也可以是JPanel
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
