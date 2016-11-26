package kryo;

import kryo.model.ZookeeperTest;
import kryo.util.ObjectAndByte;

/**
 * Created by xijingbo on 2016-09-06.
 */
public class SerializerTest {
    String filePath = "kryo.json";
    public static void main(String [] args){

    }

    private static void writeSerializer(){
        ZookeeperTest zt = new ZookeeperTest();
        zt.setName("test");
        byte[] ibs = ObjectAndByte.toByteArray(zt);

    }
}
