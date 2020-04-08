package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Category;
import service.CategoryService;

public class CategoryModel implements TableModel{
       String columnNames[]=new String[] {"分类名称","消费次数"};
       public List<Category> cs=new CategoryService().list();
     
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		  
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// 为什么？
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Category c=cs.get(rowIndex);
		//第一列
		if(0==columnIndex) {
			return c.name;
		}
		//返回第二列的消费次数
		if(columnIndex==1)return c.recordNumber;
		return null;
	     
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
