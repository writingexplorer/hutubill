package entity;

public class Category {
   public int id;
   public String name;
   //ͬһ�����ѵ���Ŀ
   public int recordNumber;
   //������дtoString ����,���ӡ���õĶ���ʱ����ӡ������"����+@+����"��
     //����ComboBoxModel�����򲻻���ʾ�ַ�����
   public String toString(){
       return name;
   }
}
