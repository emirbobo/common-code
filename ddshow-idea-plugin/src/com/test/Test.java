package com.test;

import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.codegenerator.util.MybatisConstants;
import com.intellij.openapi.project.ProjectManager;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/**
 * Created by xijingbo on 2016-02-16.
 */
public class Test {
    public static void main(String [] args) {
        String str="c1231a1asd.a";
        System.out.println(checkPackege(str));
//        String f = "file:/C:/Users/xijingbo/.IdeaIC14/config/plugins/DBNavigator/lib/DBNavigator.jar!/com/dci/intellij/dbn/codegenerator/conf/";
//        System.out.println(f.substring(f.indexOf("/")+1,f.lastIndexOf("!")));
//        System.out.println(Test.class.getClassLoader().getResource("").getFile());
//        InputStream is = Test.class.getClass().getResourceAsStream("/resources/myBatisGeneratorConfig.vm");
//        BufferedReader br=new BufferedReader(new InputStreamReader(is));
//        String s="";
//        try {
//            while((s=br.readLine())!=null) {
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
//            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPackege(String packageName){
        Pattern pattern = Pattern.compile("^([a-zA-Z]+[0-9]*\\.?)*[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(packageName);
            if(!matcher.matches()){
                return false;
            }
        return true;
    }


    public static void test(){

        Properties p = new Properties();
        p.setProperty("resource.loader", "jar");
        p.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
        p.setProperty("jar.resource.loader.path", "jar:file:C:/Users/xijingbo/.IdeaIC14/config/plugins/DBNavigator/lib/DBNavigator.jar");
//        p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "resources/");
        Velocity.init(p);
        //初始化模板
        Template template = Velocity.getTemplate("resources/"+MybatisConstants.MYBATIS_CONFIG_VM,"UTF-8");
        //初始化上下文
        VelocityContext context = new VelocityContext();
        //添加数据到上下文中
        context.put("title","我的第一个velocity模板生成页面123test");
        //生成html页面
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("src/1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        template.merge(context,pw);
        //关闭流
        pw.close();
    }

    /**
     * @param s
     * @param i
     * @param bytes
     * @return
     */
    public static short getCRC(String s, int i, byte bytes[])
    {
        CRC32 crc32 = new CRC32();
        if (s != null)
        {
            for (int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);
                crc32.update(c);
            }
        }
        crc32.update(i);
        crc32.update(i >> 8);
        crc32.update(i >> 16);
        crc32.update(i >> 24);
        for (int k = 0; k < bytes.length - 2; k++)
        {
            byte byte0 = bytes[k];
            crc32.update(byte0);
        }
        return (short) (int) crc32.getValue();
    }

    /**
     * @param biginteger
     * @return String
     */
    public static String encodeGroups(BigInteger biginteger)
    {
        BigInteger beginner1 = BigInteger.valueOf(0x39aa400L);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; biginteger.compareTo(BigInteger.ZERO) != 0; i++)
        {
            int j = biginteger.mod(beginner1).intValue();
            String s1 = encodeGroup(j);
            if (i > 0)
            {
                sb.append("-");
            }
            sb.append(s1);
            biginteger = biginteger.divide(beginner1);
        }
        return sb.toString();
    }

    /**
     * @param i
     * @return
     */
    public static String encodeGroup(int i)
    {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 5; j++)
        {
            int k = i % 36;
            char c;
            if (k < 10)
            {
                c = (char) (48 + k);
            }
            else
            {
                c = (char) ((65 + k) - 10);
            }
            sb.append(c);
            i /= 36;
        }
        return sb.toString();
    }

    /**
     * @param name
     * @param days
     * @param id
     * @return
     */
    public static String MakeKey(String name, int days, int id)
    {
        id %= 100000;
        byte bkey[] = new byte[12];
        bkey[0] = (byte) 1; // Product type: IntelliJ IDEA is 1
        bkey[1] = 14; // version
        Date d = new Date();
        long ld = (d.getTime() >> 16);
        bkey[2] = (byte) (ld & 255);
        bkey[3] = (byte) ((ld >> 8) & 255);
        bkey[4] = (byte) ((ld >> 16) & 255);
        bkey[5] = (byte) ((ld >> 24) & 255);
        days &= 0xffff;
        bkey[6] = (byte) (days & 255);
        bkey[7] = (byte) ((days >> 8) & 255);
        bkey[8] = 105;
        bkey[9] = -59;
        bkey[10] = 0;
        bkey[11] = 0;
        int w = getCRC(name, id % 100000, bkey);
        bkey[10] = (byte) (w & 255);
        bkey[11] = (byte) ((w >> 8) & 255);
        BigInteger pow = new BigInteger("89126272330128007543578052027888001981", 10);
        BigInteger mod = new BigInteger("86f71688cdd2612ca117d1f54bdae029", 16);
        BigInteger k0 = new BigInteger(bkey);
        BigInteger k1 = k0.modPow(pow, mod);
        String s0 = Integer.toString(id);
        String sz = "0";
        while (s0.length() != 5)
        {
            s0 = sz.concat(s0);
        }
        s0 = s0.concat("-");
        String s1 = encodeGroups(k1);
        s0 = s0.concat(s1);
        return s0;
    }

    public static void main1(String[] args)
    {
//        if (args.length == 0)
//        {
//            System.err.printf("*** Usage: %s name%n", Test.class.getCanonicalName());
//            System.exit(1);
//        }
        Random r = new Random();
        System.out.println(MakeKey("emirbobo", 0, r.nextInt(100000)));
    }
}
