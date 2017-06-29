import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.*;
import java.util.zip.CRC32;

/**
 * Created by Mtime on 2016/12/16.
 */
public class Count {

    public static class Test{
        int a;
        int b;

        public Test(int a ,int b){
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    public enum TestEnum{
        a,b;
    }

    private static List<Test> sort(){
        List<Test> list = Lists.<Test>newArrayList(new Test(1,2),new Test(2,3),new Test(3,4),new Test(4,5));
        Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.getA() > o2.getA() ? 1 : -1;
            }
        });
        return list;
    }
    public static void main(String [] args){

        System.out.println(System.currentTimeMillis());

        List<String> lists = Lists.newArrayList();
        lists.add("a_1");
        lists.add("a_2");
        lists.add("a3");
        lists.add("a4");

        List<String> newList = Lists.newArrayList(Lists.newArrayList(Collections2.filter(lists,new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.contains(111+"");
            }
        })));
        newList.forEach(System.out::println);

        CRC32 crc32 = new CRC32();
        crc32.update("mtime-live/586e37b375b625198b278aa4_500k_323.mp4".getBytes());
        System.out.println(crc32.getValue());

        List<Test> sss = sort();
        sss.forEach(e -> {
            System.out.println(e.getA());
        });


        List<String> replayNames;// = Lists.newArrayList();
        List<String>  s1 = Lists.newArrayList();
        s1.add("s");
        replayNames= Lists.transform(s1, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "a";
            }
        });
//        replayNames.add("b");
//        replayNames.forEach(System.out::println);

        try {
            System.out.println(URLEncoder.encode("http://114.251.245.25:8064/streamCallback/convert","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new Date(1483507146000l).toLocaleString());
        System.out.println(String.valueOf(TestEnum.a));
        String path ="http://pili-media.test-live.mtime.com/recordings/z1.demo-room01.58650cd375b625345709df27/58650cd375b625345709df27_307.m3u8";
        if(path.contains("http://")) {
            path = path.replace("http://", "");
        }
        System.out.println(path.substring(path.indexOf("/")+1,path.length()));
        System.out.println(path.substring(0,path.lastIndexOf(".")));
        System.out.println(Boolean.valueOf("true") == false);
        StringBuffer sb = new StringBuffer("asdadasd;");
        System.out.println(sb.substring(0,sb.length()-1));
        Map<String,String> map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("C1","C");
        System.out.println("目前金山只支持单个清晰度转换--"+map.toString());
        Map<TestEnum,Object> map1 = new HashMap();
        map1.put(TestEnum.a,TestEnum.a);
        map1.put(TestEnum.b,"b");
        map1.keySet().forEach((e) -> System.out.println("map1:"+e));
//        map.keySet().forEach(System.out::println);
       Set s =  map1.keySet();

//       System.out.println(map1.get("a"));
//       System.out.println(map1);
        Joiner j = Joiner.on("&");
        System.out.println("test-------"+j.join(map1.entrySet()));
        String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
        System.out.println(joinResult);
//        int uid = 111111141;
//        String u = Integer.toBinaryString(uid);
//        System.out.println(u);
//        System.out.println(u.length());
//        System.out.println(u.substring(0,24));
//        System.out.println(uid2IP(uid));
//        Splitter.fixedLength(8).split(u).forEach(System.out::println);
//        u = Integer.toBinaryString(Integer.parseInt(u,2) << 24-u.length());
//        System.out.println(u);
//        System.out.println(u.substring(u.indexOf("0")) + u.substring(0,u.indexOf("0")));
    }

    private static String uid2IP(int uid){

        String uidBinary= Integer.toBinaryString(uid);

        if(uidBinary.length() <= 16){

            uidBinary = Integer.toBinaryString(Integer.parseInt(uidBinary,2) << (24 - uidBinary.length()));
            uidBinary = uidBinary.substring(uidBinary.indexOf("0")) + uidBinary.substring(0,uidBinary.indexOf("0"));
        }else if (uidBinary.length() > 24){

            uidBinary = uidBinary.substring( uidBinary.length() - 24 , uidBinary.length());
        }

        Iterable it = Splitter.fixedLength(8).split(uidBinary);

        Joiner joiner = Joiner.on(".").skipNulls();

        List<Integer> newIp = Lists.newArrayList(10);

        it.forEach((e) ->
                newIp.add(Ints.tryParse(String.valueOf(e)) % 255));

        return joiner.join(newIp);
    }

}
