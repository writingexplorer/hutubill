package util;
import java.io.*;
public class MysqlUtil {
    public static void backup(String mysqlPath,String backupfile) throws IOException {
    	 String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
    	 
         String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.passport, DBUtil.port,
                 DBUtil.database, backupfile);
         Runtime.getRuntime().exec(command);
    }
   
    	 public static void recover(String mysqlPath, String recoverfile) {
    	        try {
    	            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
    	            String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.passport,
    	                    DBUtil.database);
    	 
    	            Process p = Runtime.getRuntime().exec(command);
    	            OutputStream out = p.getOutputStream();
    	            String strs;
    	            String str;
    	            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
    	            StringBuffer sb=new StringBuffer("");
    	            while((strs=br.readLine())!=null){
    	            	sb.append(strs+"\r\n");
    	            }
    	            str=sb.toString();
    	            OutputStreamWriter writer=new OutputStreamWriter(out,"utf8");
    	            writer.write(str);
    	            writer.flush();
    	            out.close();
    	            br.close();
    	            writer.close();
    	        }catch(IOException e) {
    	        	e.printStackTrace();
    	        }
    	       
    }
    	 public static void main(String[] args) throws IOException {
    	        String mysqlPath = "C:/Program Files (x86)/MySQL/MySQL Server 5.5";
    	        String file = "D:/MySql/hutubill1.sql";
    	 
    	        // backup(mysqlPath, file);
    	        // restore();
    	        // recover(mysqlPath, file);
    	        // recover(file);
    	        recover(mysqlPath, file);
    	 
    	    }
}
