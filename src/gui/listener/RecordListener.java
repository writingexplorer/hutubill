package gui.listener;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
 
import javax.swing.JOptionPane;
 
import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;
 
public class RecordListener implements ActionListener {
 
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel p  =RecordPanel.instance;
        if(0==p.cbModel.combos.size()){
            JOptionPane.showMessageDialog(p, "�������ѷ��࣬�޷���ӣ������������ѷ���");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
         
        if(!GUIUtil.checkZero(p.tfSpend1,"���ѽ��"))
            return;
        int spend = Integer.parseInt(p.tfSpend1.getText());
        Category c = p.getSelectedCategory();
        String comment = p.tfbeizhu.getText();
        Date d = p.datePick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "��ӳɹ�");
         
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
         
    }
 
}
