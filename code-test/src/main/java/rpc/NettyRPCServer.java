package rpc;


import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * Created by xijingbo on 2016-09-29.
 */
public class NettyRPCServer implements  RPCServer{

    public static void main(String [] args){
        NettyRPCServer nettyRPCServer = new NettyRPCServer(8000);
        nettyRPCServer.start();
    }

    private int port;
    public NettyRPCServer(int port) {
        this.port = port;
    }

    public void start(){
        // Server服务启动器
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        // 设置一个处理客户端消息和各种消息事件的类(Handler)
        bootstrap
                .setPipelineFactory(new ChannelPipelineFactory() {
                    @Override
                    public ChannelPipeline getPipeline()
                            throws Exception {
                        return Channels
                                .pipeline(new HelloServerHandler());
                    }
                });
        // 开放8000端口供客户端访问。
        bootstrap.bind(new InetSocketAddress(port));
    }

    public void destory(){

    }

    private static class HelloServerHandler extends
            SimpleChannelHandler {

        /**
         * 当有客户端绑定到服务端的时候触发，打印"Hello world, I'm server."
         *
         * @alia OneCoder
         * @author lihzh
         */
        public void channelConnected(
                ChannelHandlerContext ctx,
                ChannelStateEvent e) {
            System.out.println("Hello world, I'm server.");
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            super.messageReceived(ctx, e);
            Object o = e.getMessage();
            System.out.println(o.toString());
        }
    }
}
