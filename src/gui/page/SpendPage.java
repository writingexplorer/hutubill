package gui.page;

public class SpendPage {
     public String monthSpend;//月消费
     public String daySpend;
     public String dayAvergeSpend;//日均消费
     public String thisMonthLeft;//本月剩余
     public String dayAvergeAvailable;//日均可用
     public String dayMonthLeft;//距离月末    
     public int usagePercentage;
 	//是否超支
 	public boolean isOverSpend = false;
 	public SpendPage(int monthSpend,int daySpend,int dayAvergeSpend,int thisMonthLeft
 			,int dayAvergeAvailable,int dayMonthLeft,int usagePercentage) {
 		this.monthSpend="¥"+monthSpend;
 		this.daySpend="¥"+daySpend;
 		this.dayAvergeSpend="¥"+dayAvergeSpend;
 		this.dayMonthLeft=dayMonthLeft+"天";
 		this.usagePercentage=usagePercentage;
 		if(thisMonthLeft<0) {
 			isOverSpend=true;
 		}
 		if(!isOverSpend) {
 			this.dayAvergeAvailable="¥"+dayAvergeAvailable;
 			this.thisMonthLeft="¥"+thisMonthLeft;
 		}
 		else {
 			this.thisMonthLeft="¥"+0;
 			this.dayAvergeAvailable="超支"+(0-thisMonthLeft);
 		}
 		
 	}
}
