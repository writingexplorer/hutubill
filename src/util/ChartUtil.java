package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import entity.Record;

public class ChartUtil {
    //ģ����������
	public static double[] sampleValues(List<Record> rs) {
        double[] sampleValues = new double[rs.size()];
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = rs.get(i).spend;
        }
 
        return sampleValues;
    }
	//�������������µ�����
	private static String[] sampleLabels(List<Record> rs){
		String[] sample=new String[rs.size()];
		for(int i=0;i<sample.length;i++) {
			if(i%5==0) sample[i]=String.valueOf(i+1+"��");
			
		}
		return sample;
	}
	public static int max(double[] sampleValues) {
		int max=0;
		for(double v:sampleValues) {
			if(v>max)max=(int)v;
		}
		return max;
	}
	public static Image getImage(List<Record> rs,int width, int height) {
		//ģ����������
		 double sampleValues[]=sampleValues(rs);
		//�·���ʾ������
		 String sampleLabels[]=sampleLabels(rs);
		 int max=max(sampleValues);
		 BarChart chart=new BarChart();
		 chart.setSampleCount(sampleValues.length);
		 chart.setSampleValues(0, sampleValues);
		 chart.setSampleLabels(sampleLabels);
		 Color color[]=new Color[] {ColorUtil.blueColor};
		 chart.setSampleColors(color);
		 //��������ȡֵ��Χ
		 chart.setRange(0,max*1.2);
		 //���ñ�������
		 chart.setValueLinesOn(true);
		 //��ʾ����
		 chart.setSampleLabelsOn(true);
		 chart.setSampleLabelStyle(Chart.BELOW);
		 //����
		 chart.setFont("rangeLabelFont",new Font("Arial",Font.BOLD,12));
		 //ͼ��˵��
		 chart.setLegendOn(true);
		 chart.setLegendPosition(Chart.LEFT);
		 chart.setLegendLabels(new String[] {"�����ѱ���"});
		 chart.setFont("legendFont",new Font("Dialog",Font.BOLD,13));
		 chart.setFont("sampleLabelFont",new Font("Dialog",Font.BOLD,13));
		 chart.setChartBackground(Color.white);
		 chart.setBackground(ColorUtil.backgroundColor);
		 Image im=chart.getImage(width,height);
		 return im;
	}
	public static void main(String[] args) {
		
	}
}
