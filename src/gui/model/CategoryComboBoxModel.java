package gui.model;


import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;

import service.CategoryService;
//创建一个新的下拉框的类,实现ComBoxModel接口
public class CategoryComboBoxModel implements ComboBoxModel<Category>{
    public List<Category> combos=new CategoryService().list();
   Category c;
    public CategoryComboBoxModel() {
    	if(!combos.isEmpty())
    	c=combos.get(0);    	
    }
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return combos.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return combos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		if(!combos.isEmpty()) {
			return c;
		}
		else return null;
	}

	@Override
	public void setSelectedItem(Object arg0) {
	   c=(Category)arg0;
		
	}

}
