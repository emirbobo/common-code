package zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created by Mtime on 2017/3/17.
 */
public class ZKTest {

    static CuratorFramework client = null;
    static {

        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.10.197:2181")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        System.out.println("start session.");
        client.start();
    }

    public static void main(String [] args) throws Exception {
        init1();
        watcher();
//        init1();
    }

    private static void init1(){
        try {
            client.delete()
                    .guaranteed()
                    .deletingChildrenIfNeeded()
                    .withVersion(-1)
                    .forPath("/mtime-chat");
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath("/mtime-chat" );
            watcher();
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/mtime-chat/chat-00" );
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/mtime-chat/chat-01");

            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void watcher() throws Exception {
        final PathChildrenCache childrenCache = new PathChildrenCache(client, "/mtime-chat", true);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener(
                new PathChildrenCacheListener() {
                    @Override
                    public void childEvent(CuratorFramework client, PathChildrenCacheEvent event)
                            throws Exception {
                        switch (event.getType()) {
                            case CHILD_ADDED:
                                System.out.println("CHILD_ADDED: " + event.getData().getPath());
                                break;
                            case CHILD_REMOVED:
                                System.out.println("CHILD_REMOVED: " + event.getData().getPath());
                                break;
                            case CHILD_UPDATED:
                                System.out.println("CHILD_UPDATED: " + event.getData().getPath());
                                break;
                            default:
                                break;
                        }
                    }
                }
        );

    }
}
