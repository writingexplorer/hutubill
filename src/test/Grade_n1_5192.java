package test;

public class Grade_n1_5192 {
         public static void main(String args[]) {
        	 //一个班40人的成绩
             int a[]= {73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,100};
             int levelE=0;//不及格
             int levelD=0;//及格
             int levelC=0;//中
             int levelB=0;//良
             int levelA=0;//优秀
             //统计成绩的循环
             for(int i=0;i<a.length;i++) {
            	 if(a[i]<60)levelE++;
            	 else if(a[i]<70)levelD++;
            	 else if(a[i]<80)levelC++;
            	 else if(a[i]<90)levelB++;
            	 else levelA++;
             }
             System.out.format("不及格人数：%d,及格人数：%d,成绩中等人数:%d,成绩良人数:%d.成绩优秀人数:%d",levelE,levelD,levelC,levelB,levelA);
             System.out.println();
             //计算成绩的平均值
             float averge;
             int total=0;
             for(int i=0;i<a.length;i++) {
            	 total+=a[i];
             }
             averge=total/40;
             System.out.println("平均成绩为"+averge);
             //求最高分
             int max=0;
             for(int i=0;i<a.length;i++) {
            	 if(a[i]>max) {
            		 max=a[i];
            	 }
             }
             System.out.println("最高分为"+max);
         }
}
