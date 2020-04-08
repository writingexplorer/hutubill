package test;

public class Student_n1_5192 {	
   static class Student{
	   int number;//学号
    	int age;//年龄
    	String name;//名字
    	public String toString() {
    		String l=String.format("学号=%d,名字=%s,年龄=%d",number,name,age);
    		return l;
    	}
    }     
     public static void main(String args[]) {
    	Student a[]=new Student[40]; 
    	System.out.println("导入的初始信息显示：");
       for(int i=0;i<20;i++) {
    	   Student e=new Student();
    	   e.number=5100+i;
    	   e.name="Student"+String.valueOf(i);
    	   e.age=14+(int)(10*Math.random());
    	   a[i]=e;    	  
    	   System.out.println(a[i]);
       }
        for(int i=0;i<20;i++) {
        	a[i].age=a[i].age+1;
        }
       System.out.println("年龄加1后信息的显示：");
       for(int i=0;i<20;i++) {
    	   System.out.println(a[i]);
       }	
       for(int i=0;i<20;i++) {
    	   if(a[i].age>20) {
    	   System.out.println("年龄大于20的："+a[i]);
    	   }
       }      
     }
}
