package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;

import util.DBUtil;

public class CategoryDAO {

	   public int getTotal() {
		   int total=0;
		   try(Connection c=DBUtil.getConnection();
				   Statement s=c.createStatement();)
		   {
			   String sql="select count(*) from Category";
			   ResultSet rs=s.executeQuery(sql);
			   if(rs.next()) {
				   total=rs.getInt(1);
			   }
			   
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		   return total;
	   }
	   public void add(Category category) {
		   String sql="insert into category values(null,?)";
		   try(Connection c=DBUtil.getConnection();
				   PreparedStatement ps=c.prepareStatement(sql);)
		   {
			   ps.setString(1,category.name);		
			   ps.execute();
	           ResultSet rs = ps.getGeneratedKeys();
	           // 为什么要返回id?
	           if (rs.next()) {
	               int id = rs.getInt(1);
	               category.id = id;
	           }
			   
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   public void update(Category category) {
		   String sql="update category set name= ? where id= ?";
		   try(Connection c=DBUtil.getConnection();
				   PreparedStatement ps=c.prepareStatement(sql);)
		   {
			   ps.setString(1,category.name);			  
			   ps.setInt(2, category.id);
			   ps.execute();	    
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		 
	   }  
	   public void delete(int id){
		String sql="delete from category where id="+id;
		try(Connection c=DBUtil.getConnection();
				   Statement s=c.createStatement();)
		   {
			s.execute(sql);
			   
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   public Category get(int id) {
		   Category category=new Category();
		   String sql="select * from category where id="+id;
		   try(Connection c=DBUtil.getConnection();
				  Statement ps=c.createStatement();)
		   {
			   ResultSet rs=ps.executeQuery(sql);
			   if(rs.next()) {
				   category.name=rs.getString(1);		
				   category.id=id;
			   }		             
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		   return category;
	   }
	   public List<Category> list(int start,int count){
		   List<Category> cs=new ArrayList<>();
		   String sql="select * from category limit "+start+","+count;
		   try(Connection c=DBUtil.getConnection();
					  Statement s=c.createStatement();
				      PreparedStatement ps=c.prepareStatement(sql);)
			   {
				   ResultSet rs=s.executeQuery(sql);
				   while(rs.next()) {
					  Category category=new Category();
					  category.id=rs.getInt("id");
				
					  category.name=rs.getString("name");
					  cs.add(category);
				   }		             
			   }catch(SQLException e) {
				   e.printStackTrace();
			   }
		   return cs;
	   }
	   public List<Category> list(){
		   return list(0,Short.MAX_VALUE);
	   }
	   
}
