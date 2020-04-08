package entity;

public class Category {
   public int id;
   public String name;
   //同一类消费的数目
   public int recordNumber;
   //若不重写toString 方法,则打印引用的对象时，打印出的是"类名+@+数字"，
     //所以ComboBoxModel下拉框不会显示字符串。
   public String toString(){
       return name;
   }
}
