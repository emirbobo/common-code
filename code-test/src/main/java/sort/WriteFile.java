package sort;

import java.io.FileWriter;
import java.nio.CharBuffer;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/29.
 */
public class WriteFile
{
    public static void main(String[] args) throws Exception{

        long start = System.currentTimeMillis();
        CharBuffer buffer = CharBuffer.allocate(13);
//        int count = 100;
        int count = 10000000;
        Random random = new Random(System.currentTimeMillis());
        FileWriter writer = new FileWriter("D:/list1.txt");
        for(int i=0;i<count;i++)
        {
            buffer.clear();
            buffer.append("139");
            for(int j=0;j<8;j++)
                UtilCharBuffer.appendString(buffer, Math.abs(random.nextInt()) % 10);
            buffer.append("\r\n");
            writer.write(buffer.array(),0,buffer.position());
        }
        writer.close();
        System.out.println("Time:"+(System.currentTimeMillis()-start));
    }
}
