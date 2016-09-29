package kryo;

import kryo.model.ZookeeperTest;
import kryo.model.ZookeeperTest1;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

public class KryoReadClient {
    private static final String PATH = "/emirbobo";  


    public static void main(String[] args) { 
    	
    	CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")  
            .sessionTimeoutMs(30000)  
            .connectionTimeoutMs(30000)  
            .canBeReadOnly(false)  
            .retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))  
//            .namespace("/brokers")
            .defaultData(null)  
            .build();  
        try {     
            client.start();  
            Kryo  k = new Kryo ();
            byte[] b = client.getData().forPath(PATH);
            System.out.println(b.length);
            Input i = new Input(b);
            ZookeeperTest1 zt1 = k.readObject(i,ZookeeperTest1.class);
            System.out.println("新建的节点，data为:" + zt1.print()+"---"+zt1.getName());
            
//            client.setData().forPath(PATH, "I love football".getBytes());  
  
            // 由于是在background模式下获取的data，此时的bs可能为null  
//            byte[] bs2 = client.getData().forPath(PATH);  
//            System.out.println("修改后的data为" + new String(bs2 != null ? bs2 : new byte[0]));  
//            client.delete().inBackground().forPath(PATH);  
//            Stat stat = client.checkExists().forPath(PATH);  
  
//             Stat就是对zonde所有属性的一个映射， stat=null表示节点不存在！  
//            System.out.println(stat);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            CloseableUtils.closeQuietly(client);  
        }  
    }  		
}
