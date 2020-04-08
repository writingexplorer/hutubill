package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import entity.Record;
import util.DBUtil;
import util.DateUtil;
public class RecordDAO {
      public int getTotal() {
    	  int total=0;
    	  String sql="select count(*) from record";
    	  try(Connection c=DBUtil.getConnection();
    			  Statement s=c.createStatement();){
    		      ResultSet rs=s.executeQuery(sql);
    		      if(rs.next()) {
    		    	  total=rs.getInt(1);
    		      }
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return total;
      }
      public void add(Record record) {
    	  String sql="insert into record values(null,?,?,?,?)";
    	  try(Connection c=DBUtil.getConnection();
    			  PreparedStatement ps=c.prepareStatement(sql);){
    		    ps.setInt(1,record.spend);
    		    ps.setInt(2,record.cid);
    		    ps.setString(3, record.comment);
    		    ps.setDate(4,DateUtil.util2sql(record.date));
    		    ps.execute();
    		    ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    record.id = id;
                }
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
      }
      public void delete(int id) {
    	  String sql="delete from record where id="+id;
    	  try(Connection c=DBUtil.getConnection();
    			  Statement s=c.createStatement();){
    		     
    		   s.execute(sql);
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
      }
      public void update(Record record) {
    	  String sql="update record set spend=?,cid=?,comment=?,date=? where id=?";
    	  try(Connection c=DBUtil.getConnection();
    			  PreparedStatement ps=c.prepareStatement(sql);){
    		     ps.setInt(1, record.spend);
    		     ps.setInt(2, record.cid);
    		     ps.setString(3,record.comment);
    		     ps.setDate(4, DateUtil.util2sql(record.date));
    		     ps.setInt(5, record.id);
    		     ps.execute();
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
      }
      public List<Record> list(int start,int count){
    	  List<Record> cs=new ArrayList<>();
    	  String sql="select * from record order by id desc limit ?,?";
    	  try(Connection c=DBUtil.getConnection();
    			  PreparedStatement ps=c.prepareStatement(sql);){
    		    ps.setInt(1,start);
    		    ps.setInt(2,count);   		 
    		    ps.execute();
    		    ResultSet rs = ps.executeQuery();
               while (rs.next()) {
            	    Record record=new Record();
            	    record.id=rs.getInt("id");
            	    record.spend=rs.getInt("spend");
            	    record.cid=rs.getInt("cid");
            	    record.comment=rs.getString("comment");
            	    record.date=rs.getDate("date");
                    cs.add(record);   
                }
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return cs;
      }
      public List<Record> list() {
          return list(0, Short.MAX_VALUE);
      }
      public List<Record> list(Date start,Date end){
    	  List<Record> cs=new ArrayList<>();
    	  String sql="select * from record where date>=? and date<=?";
    	  try(Connection c=DBUtil.getConnection();
    			  PreparedStatement ps=c.prepareStatement(sql);){
    		     ps.setDate(1, DateUtil.util2sql(start));
    		     ps.setDate(2, DateUtil.util2sql(end));   		   
    		     ps.execute();
    		     ResultSet rs = ps.executeQuery();
                 while (rs.next()) {
              	    Record record=new Record();
              	    record.id=rs.getInt("id");
              	    record.spend=rs.getInt("spend");
              	    record.cid=rs.getInt("cid");
              	    record.comment=rs.getString("comment");
              	    record.date=rs.getDate("date");
                      cs.add(record);   
                  }
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return cs;
      }
      //返回本月的数据
      public List<Record> listThisMonth(){
          return list(DateUtil.monthBegin(),DateUtil.monthEnd());
      }
      public List<Record> list(Date day) {
          List<Record> records = new ArrayList<Record>();
          String sql = "select * from record where date =?";
          try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
              ps.setDate(1, DateUtil.util2sql(day));
   
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                  Record record = new Record();
                  int id = rs.getInt("id");
                  int cid = rs.getInt("cid");
                  int spend = rs.getInt("spend");
                   
                   String comment = rs.getString("comment");
             
                    
                   record.spend=spend;
                   record.cid=cid;
                   record.comment=comment;
                   record.date=rs.getDate("date");
                   record.id = id;
                   records.add(record);
              }
          } catch (SQLException e) {
    
              e.printStackTrace();
          }
          return records;
      }       
      //返回指标为cid的Record表
      public List<Record> list(int cid) {
          List<Record> records = new ArrayList<Record>();
    
          String sql = "select * from record where cid = ?";
    
          try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
    
              ps.setInt(1, cid);
    
              ResultSet rs = ps.executeQuery();
    
              while (rs.next()) {
                  Record record = new Record();
                  int id = rs.getInt("id");
                  int spend = rs.getInt("spend");
                   
                   String comment = rs.getString("comment");
                 
                    
                   record.spend=spend;
                   record.cid=cid;
                   record.comment=comment;
                   record.date=rs.getDate("date");
                   record.id = id;
                  records.add(record);
              }
          } catch (SQLException e) {
    
              e.printStackTrace();
          }
          return records;
      }   
      //获取今天的消费记录信息
      public List<Record> listToday(){
          return list(DateUtil.today());
      }
}
