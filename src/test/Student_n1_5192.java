package test;

public class Student_n1_5192 {	
   static class Student{
	   int number;//ѧ��
    	int age;//����
    	String name;//����
    	public String toString() {
    		String l=String.format("ѧ��=%d,����=%s,����=%d",number,name,age);
    		return l;
    	}
    }     
     public static void main(String args[]) {
    	Student a[]=new Student[40]; 
    	System.out.println("����ĳ�ʼ��Ϣ��ʾ��");
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
       System.out.println("�����1����Ϣ����ʾ��");
       for(int i=0;i<20;i++) {
    	   System.out.println(a[i]);
       }	
       for(int i=0;i<20;i++) {
    	   if(a[i].age>20) {
    	   System.out.println("�������20�ģ�"+a[i]);
    	   }
       }      
     }
}
