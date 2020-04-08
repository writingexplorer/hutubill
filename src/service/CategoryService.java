package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {
     CategoryDAO categoryDao=new CategoryDAO();
     RecordDAO recordDao=new RecordDAO();
     public List<Category> list(){
    	 List<Category> category=categoryDao.list();
    	 for(Category c:category) {
    		 List<Record> rs=recordDao.list(c.id);
    		 c.recordNumber=rs.size();
    	 }
    	 //category�����Ѵ���������
    	 Collections.sort(category,(c1,c2)->c2.recordNumber-c1.recordNumber);
    	 return category;
     }
     //��Ӧ���������º�ɾ��������ť
     public void add(String name) {
    	 Category c=new Category();
    	 c.name=name;
    	 categoryDao.add(c);
     }
     public void update(int id,String name) {
    	 Category c=new Category();
    	 c.name=name;
    	 c.id=id;
    	 categoryDao.update(c);
    	 
     }
     public void delete(int id) {
    	 categoryDao.delete(id);
     }
}
