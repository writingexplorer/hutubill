package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
      public SpendPage getSpendPage() {
    	  RecordDAO rDao=new RecordDAO();
    	  List<Record> thisMonthRecord=rDao.listThisMonth();
    	  List<Record> todayRecord=rDao.listToday();
    	  int thisMonthDay=DateUtil.thisMonthTotalDay();
    	  
    	  int thisMonthSpend=0;
    	  int daySpend=0;
    	  int dayAvergeSpend;
    	  int thisMonthLeft;
    	  int dayAvergeAvailable;
    	  int dayMonthLeft;
    	  for(Record d:thisMonthRecord) {
    		  thisMonthSpend+=d.spend;
    	  }
    	for(Record d:todayRecord) {
    		daySpend+=d.spend;
    	}
    	dayMonthLeft=DateUtil.thisMonthLeftDay();
    	dayAvergeSpend=thisMonthSpend/(thisMonthDay-dayMonthLeft);
    	//‘§À„ø…”√Ω∂Ó
    	int budget=new ConfigService().getIntBudget();
    	thisMonthLeft=budget-thisMonthSpend;
    	int usagePercentage=thisMonthSpend*100/budget;
        dayAvergeAvailable=thisMonthLeft/dayMonthLeft;
    	return new SpendPage(thisMonthSpend,daySpend,dayAvergeSpend,thisMonthLeft,
    			dayAvergeAvailable,dayMonthLeft,usagePercentage);
      }
}
