package com.emirbobo.netty;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by emirbobo on 2016/10/15.
 */
public class RoomChannelManager {

    static AtomicInteger roomIdQueue = new AtomicInteger(1);

    //房间 和用户通道对应表
    static Map<Integer,List<Channel>> roomChannelRealation = new ConcurrentHashMap<Integer, List<Channel>>();

    //房间和播客关系对应表
    Map<Integer,Integer> roomAnchorRealation = new ConcurrentHashMap<Integer, Integer>();

    public static void join(Integer roomId,Channel channel){
        List<Channel> channels = roomChannelRealation.get(roomId);
        if(channels == null){
            System.out.println("this room not exist !");
            return;
        }
        channels.add(channel);
    }

    public static Integer createRoom(Channel anchorChannel){
        List<Channel> channels = new ArrayList<Channel>();
        channels.add(anchorChannel);
        Integer roomId = roomIdQueue.getAndIncrement();
        roomChannelRealation.put(roomId,channels);
        return roomId;
    }
}
