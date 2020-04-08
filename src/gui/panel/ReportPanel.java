package gui.panel;

import java.awt.BorderLayout;
import java.awt.*;
import java.util.List;
import javax.swing.*;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel{
  static {
	  GUIUtil.useLNF();
  }
  public static ReportPanel instance=new ReportPanel();
  JLabel l=new JLabel();
  private ReportPanel() {
	  this.setLayout(new BorderLayout());
	  List<Record> rs = new ReportService().listThisMonthSpend();
	  Image i=ChartUtil.getImage(rs,350, 250);
	  ImageIcon ic=new ImageIcon(i);
	  l.setIcon(ic);
	  this.add(l);
	  addListener();
  }
  public void updateData() {
	  List<Record> rs=new ReportService().listThisMonthSpend();
	  Image i=ChartUtil.getImage(rs, 350, 250);
	  ImageIcon icon=new ImageIcon(i);
	  l.setIcon(icon);
  }
  public void addListener() {
	  
  }
  public static void main(String[] args) {
      GUIUtil.showPanel(ReportPanel.instance);
  }
}
