package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class ReportService {
        public int getdaySpend(List<Record> thismonth,Date d) {
        	int daySpend=0;
        	for(Record record:thismonth) {
        		if(record.date.equals(d)) {
        			daySpend+=record.spend;
        		}
        	}
        	return daySpend;
        }
        public List<Record> listThisMonthSpend(){
            RecordDAO r=new RecordDAO();
            List<Record> thisMonth=r.listThisMonth();
            int monthTotalDay=DateUtil.thisMonthTotalDay();
            List<Record> rs=new ArrayList<>();
            Date monthBegin=DateUtil.monthBegin();
            //获取日期专用类calendar
            Calendar c=Calendar.getInstance();
            for(int i=0;i<monthTotalDay;i++) {
            	Record record=new Record();
            	  c.setTime(monthBegin);
                  c.add(Calendar.DATE, i);
                  Date eachDayOfThisMonth=c.getTime() ;
                  int daySpend=getdaySpend(thisMonth,eachDayOfThisMonth);
                  record.spend=daySpend;
                  rs.add(record);
            }
            return rs;
        }
}
