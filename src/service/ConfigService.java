package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
     public static final String budget="budget";
     public static final String mysqlPath="mysqlPath";
     static ConfigDAO dao=new ConfigDAO();
     static {
    	 init();
     }
     public static void init() {
    	 init(budget,"500");
    	 init(mysqlPath,"");
     }
     //如果数据库为空，则初始化预算为500，更新路径为空
     public static void init(String key,String value) {
    	 Config config=dao.getByKey(key);
    	 if(config==null) {
    		 Config c=new Config();
    		 c.key=key;
    		 c.value=value;
    		 dao.add(c);
    	 }
     }
     public String get(String key) {
    	 Config c=dao.getByKey(key);
    	 return c.value;
     }
     public void update(String key,String value) {
    	 Config config=dao.getByKey(key);
    	 config.value=value;
    	 dao.update(config);
     }
     public int getIntBudget() {
    	 return Integer.parseInt(get(budget));
     }
}
