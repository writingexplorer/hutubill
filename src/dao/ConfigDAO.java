package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Config;
import util.DBUtil;
import java.util.*;

public class ConfigDAO {
	
   public int getTotal() {
	   int total=0;
	   try(Connection c=DBUtil.getConnection();
			   Statement s=c.createStatement();)
	   {
		   String sql="select count(*) from config";
		   ResultSet rs=s.executeQuery(sql);
		   if(rs.next()) {
			   total=rs.getInt(1);
		   }
		   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return total;
   }
   public void add(Config config) {
	   String sql="insert into config values(null,?,?)";
	   try(Connection c=DBUtil.getConnection();
			   PreparedStatement ps=c.prepareStatement(sql);)
	   {
		   ps.setString(1,config.key);
		   ps.setString(2, config.value);
		   ps.execute();
           ResultSet rs = ps.getGeneratedKeys();
           // 为什么要返回id?
           if (rs.next()) {
               int id = rs.getInt(1);
               config.id = id;
           }
		   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
   public void update(Config config) {
	   String sql="update config set key_= ?, value=? where id = ?";
	   try(Connection c=DBUtil.getConnection();
			   PreparedStatement ps=c.prepareStatement(sql);)
	   {
		   ps.setString(1,config.key);
		   ps.setString(2, config.value);
		   ps.setInt(3, config.id);
		   ps.execute();
    
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	 
   }  
   public void delete(int id){
	String sql="delete from config where id="+id;
	try(Connection c=DBUtil.getConnection();
			   Statement s=c.createStatement();)
	   {
		s.execute(sql);
		   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
   public Config get(int id) {
	   Config config=new Config();
	   String sql="select * from config where id="+id;
	   try(Connection c=DBUtil.getConnection();
			  Statement ps=c.createStatement();)
	   {
		   ResultSet rs=ps.executeQuery(sql);
		   if(rs.next()) {
			   config.key=rs.getString(1);
			   config.value=rs.getString(2);
			   config.id=id;
		   }		             
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return config;
   }
   public List<Config> list(int start,int count){
	   List<Config> cs=new ArrayList<>();
	   String sql="select * from config limit "+start+","+count;
	   try(Connection c=DBUtil.getConnection();
				  Statement s=c.createStatement();
			      PreparedStatement ps=c.prepareStatement(sql);)
		   {
			   ResultSet rs=s.executeQuery(sql);
			   while(rs.next()) {
				  Config config=new Config();
				  config.id=rs.getInt("id");
				  config.key=rs.getString(2);
				  config.value=rs.getString(3);
				  cs.add(config);
			   }		             
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   return cs;
   }
   public Config getByKey(String key) {
	   Config config=null;
	   String sql="select * from config where key_=?";
	   try(Connection c=DBUtil.getConnection();
				 
			      PreparedStatement ps=c.prepareStatement(sql);)
		   {
		       ps.setString(1,key);
			   ResultSet rs=ps.executeQuery();
			   
			  if(rs.next()) {
				  config=new Config();
				  config.id=rs.getInt("id");
				  config.key=key;
				  config.value=rs.getString("value");
				
			   }		             
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   return config;
   }
   public List<Config> list(){
	   return list(0,Short.MAX_VALUE);
   }
}
