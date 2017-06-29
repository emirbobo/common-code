package sort;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Random;

/**
 * Created by jingbo.xi on 2017/6/27.
 */
public class BitSort {

    //存放所有的Int数据
    int [] bitValus;

    /**
     * 创建100w数据
     */
    public void createData(){

    }

    int [] bits = {
            0x80000000,//10000000000000000000000000000000
            0x40000000,//01000000000000000000000000000000
            0x20000000,//00100000000000000000000000000000
            0x10000000,//00010000000000000000000000000000
            0x08000000,//00001000000000000000000000000000
            0x04000000,//00000100000000000000000000000000
            0x02000000,//00000010000000000000000000000000
            0x01000000,//00000001000000000000000000000000
            0x00800000,//00000000100000000000000000000000
            0x00400000,//00000000010000000000000000000000
            0x00200000,//00000000001000000000000000000000
            0x00100000,//00000000000100000000000000000000
            0x00080000,//00000000000010000000000000000000
            0x00040000,//00000000000001000000000000000000
            0x00020000,//00000000000000100000000000000000
            0x00010000,//00000000000000010000000000000000
            0x00008000,//00000000000000001000000000000000
            0x00004000,//00000000000000000100000000000000
            0x00002000,//00000000000000000010000000000000
            0x00001000,//00000000000000000001000000000000
            0x00000800,//00000000000000000000100000000000
            0x00000400,//00000000000000000000010000000000
            0x00000200,//00000000000000000000001000000000
            0x00000100,//00000000000000000000000100000000
            0x00000080,//00000000000000000000000010000000
            0x00000040,//00000000000000000000000001000000
            0x00000020,//00000000000000000000000000100000
            0x00000010,//00000000000000000000000000010000
            0x00000008,//00000000000000000000000000001000
            0x00000004,//00000000000000000000000000000100
            0x00000002,//00000000000000000000000000000010
            0x00000001 //00000000000000000000000000000001
    };

    public BitSort(int length){
        if(length <=0 ){
            System.out.println("length error , exit !");
            System.exit(1);
        }

        bitValus = new int[length / 32 + (length % 32 == 0 ? 0 : 1)];

    }

    public int getBitInt(int index){
        if(index <0 ){
            System.out.println("index error , exit !");
            System.exit(1);
        }

        int intValue = bitValus[ index / 32 ];//找到数值在哪个整数上
        if(intValue == 0){
            return 0;
        }
        return intValue & bits[index % 32];//找到数值在哪个位上
    }

    public void setBitValus(int index){

        if(index <=0 ){
            System.out.println("index error , exit !");
            System.exit(1);
        }

        int intValue = bitValus[ index / 32 ];//找到数值在哪个整数上
        bitValus[ index / 32 ] =   intValue | bits[index % 32];//找到数值在哪个位上并赋值
    }

    public static void main1(String [] args){
        int i =0;
        while(i< 10) {
            System.out.println((System.nanoTime()+ "").substring(7));
            i++;
        }
    }

    public static void main(String [] args){
//        createPhoneNum();
        sortPhoneNum();
    }

    private static void sortPhoneNum(){
        try {
            BitSort bitSort = new BitSort(100000000);
            // read file content from file
            StringBuffer sb= new StringBuffer("");

            FileReader reader = new FileReader("D:/phoneNumber.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while((str = br.readLine()) != null) {
                bitSort.setBitValus(Integer.parseInt(str.substring(3)));
            }
//            int bitUnit = bitSort.bitValus.length;
            for(int j = 0; j < 100000000 ; j++){
                int a = bitSort.getBitInt(j);
                if(a != 0) {
                    System.out.println("cur -> 135"+a);
                }
            }
            br.close();
            reader.close();


        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void createPhoneNum(){
        int phoneNumSize = 10;
        File file = new File("D:/phoneNumber.txt");
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            int i = 0;
            while(i < phoneNumSize){
                String num = System.nanoTime() + "";
                writer.write("135"+num.substring(7));
                writer.newLine();//换行
                i++;
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
