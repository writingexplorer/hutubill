package test;

public class Grade_n1_5192 {
         public static void main(String args[]) {
        	 //һ����40�˵ĳɼ�
             int a[]= {73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,
            		 100,73,90,40,39,44,80,69,22,55,100};
             int levelE=0;//������
             int levelD=0;//����
             int levelC=0;//��
             int levelB=0;//��
             int levelA=0;//����
             //ͳ�Ƴɼ���ѭ��
             for(int i=0;i<a.length;i++) {
            	 if(a[i]<60)levelE++;
            	 else if(a[i]<70)levelD++;
            	 else if(a[i]<80)levelC++;
            	 else if(a[i]<90)levelB++;
            	 else levelA++;
             }
             System.out.format("������������%d,����������%d,�ɼ��е�����:%d,�ɼ�������:%d.�ɼ���������:%d",levelE,levelD,levelC,levelB,levelA);
             System.out.println();
             //����ɼ���ƽ��ֵ
             float averge;
             int total=0;
             for(int i=0;i<a.length;i++) {
            	 total+=a[i];
             }
             averge=total/40;
             System.out.println("ƽ���ɼ�Ϊ"+averge);
             //����߷�
             int max=0;
             for(int i=0;i<a.length;i++) {
            	 if(a[i]>max) {
            		 max=a[i];
            	 }
             }
             System.out.println("��߷�Ϊ"+max);
         }
}
