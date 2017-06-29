package influxdb;

import passport.HttpRequestUnit;
import util.DateUtil;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mtime on 2016/12/6.
 */
public class WriteData {

    private static final String url = "http://192.168.50.85:8086/write";

    private static final String serverId = "chat03";

    public static void main(String [] args){
        try {
            readFileByLines("D:\\export\\client03.log");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println(tempString);
                System.out.println(process(tempString));            }
            reader.close();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static String process(String tempString){
        StringBuffer sb = new StringBuffer();
        try {
            String[] ts = tempString.split(" ");
            Date date = DateUtil.parseDate(ts[0] + " " + ts[1]);
            String dateStr = date.getTime() + "000000";
            sb.append(serverId).append(" ").append("value=").append(Integer.parseInt(ts[9].replace(",", ""))).append(" ").append(dateStr);
        }catch(Exception e){
            return "";
        }
        return sb.toString();
    }

}
