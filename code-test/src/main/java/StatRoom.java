import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.lang.UncheckException;
import lombok.Data;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.StopWatch;
import util.DelayObject;
import util.Signal;
import util.Signals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mtime on 2016/12/16.
 */
public class StatRoom {

@Data
public static class JsonTest{
    List<Map<String,String>> test;
}

    public static void main(String [] args) throws InterruptedException {
        System.out.println(DateUtils.addDays(new Date(), 30).toLocaleString());
        System.out.println(DateUtils.addDays(new Date(), 30).toGMTString());

        StopWatch stopWatch = new StopWatch("test");
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();;
        System.out.println(stopWatch.shortSummary());
        Map<String,String> test = new HashMap();

        test.put("a","b");
        test.put("a1","b1");
        test.put("a2","b2");
        test.put("a3","b3");
        JsonTest jsonTest = new JsonTest();
        List list = Lists.newArrayList();
        list.add(test);
        jsonTest.setTest(list);
        System.out.println(JSONObject.toJSONString(jsonTest));

        DelayQueue<DelayObject<String>> q = new DelayQueue<DelayObject<String>>();
        q.offer(new DelayObject<>("hehe",3000));
        q.offer(new DelayObject<>("hehe1",2000));
        q.offer(new DelayObject<>("hehe2",1000));
        try {
            System.out.println(q.peek().getItem());
            System.out.println(q.take().getItem());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        q.remove("hehe");
        System.out.println(q.size());
//        long nanoTime = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MILLISECONDS);
//        System.out.println(nanoTime);
//        Signals signals = JSONObject.parseObject(s, Signals.class);
//        System.out.println(signals.getSignals());
//        JSONArray signals = JSONObject.parseArray(s);
//        System.out.println(signals.get(0).toString());
//        Signal signal = JSONObject.parseObject(signals.get(0).toString(),Signal.class);
//        Object jo = JSONObject.parseObject(signals.get(0).toString()).get("cmdParams");
//        Map<String,String> r = JSONObject.parseObject(jo.toString(),Map.class);
//        System.out.println(r.size());
//        OnSignalRequest request = new OnSignalRequest();
//        OnSignalMessage data  = new OnSignalMessage();
//        Map<String,String> map = Maps.newHashMap();
//        map.put("a","a");
//        data.setCmdParams(map);
//        for (Map.Entry<String, String> entry : data.getCmdParams().entrySet()) {
//            CmdParam param = new CmdParam();
//            param.setKey(entry.getKey());
//            param.setValue(entry.getValue());
//            request.addCmdParams(param);
//        }
//        CmdParam param = new CmdParam();
//        param.setKey("b");
//        param.setValue("b");
//        request.addCmdParams(param);
//        System.out.println(request);

//        Map<String,String> testMap = Maps.newHashMap();
//        testMap.put("test","msgId");
//        System.out.println(testMap.isEmpty());
//        System.out.println(testMap.keySet().toArray()[0]);
//        readFiles("d:/log");
    }


    public static void readFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file2 : files) {
            readFileByLines(file2);
        }
    }

    public static void readFileByLines(File tf) {
        File file = tf;
        System.out.println("stat room :"+tf.getName());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            RoomData roomData =  new RoomData(Sets.newHashSet(),Sets.newHashSet());
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if(!tempString.contains("|")){
                    continue;
                }
                String [] ts = tempString.split(" ");
                String content = ts[7];
                String [] data = content.split("\\|");
                if(!data[2].equals("16121310673idc")){
                    continue;
                }
                roomData.put(data[1],data[0]);
            }
            System.out.println("all clientId:"+roomData.getRoomUserClient().size());
            System.out.println("userId:"+roomData.getRoomUserId().size());
            System.out.println("----------------------------------------");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }


    public static class RoomData{

        Set<String> roomUserId;

        Set<String> roomUserClient;

        public RoomData(Set<String> roomUserId, Set<String> roomUserClient) {
            this.roomUserId = roomUserId;
            this.roomUserClient = roomUserClient;
        }

        public void put(String userId,String userClientId){
            roomUserClient.add(userClientId);
            roomUserId.add(userId);
        }

        public Set<String> getRoomUserId() {
            return roomUserId;
        }

        public void setRoomUserId(Set<String> roomUserId) {
            this.roomUserId = roomUserId;
        }

        public Set<String> getRoomUserClient() {
            return roomUserClient;
        }

        public void setRoomUserClient(Set<String> roomUserClient) {
            this.roomUserClient = roomUserClient;
        }
    }
}
