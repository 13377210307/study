package com.netty.chat.client;

import com.netty.chat.message.LoginRequestMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * @Author: w
 * @Date: 2021/6/9 22:28
 */
public class ChatClient {

    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast();
                    socketChannel.pipeline().addLast("client handler", new ChannelInboundHandlerAdapter() {

                        // 建立连接之后触发active事件
                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            // 创建新的线程，接收用户输入账号、密码，向服务器发送消息
                            new Thread(() -> {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("请输入用户名...");
                                String username = scanner.nextLine();
                                System.out.println("请输入密码...");
                                String password = scanner.nextLine();
                                // 构造消息对象
                                LoginRequestMessage message = new LoginRequestMessage(username, password);
                                // 发送消息
                                ctx.writeAndFlush(message);

                            },"system in").start();
                        }
                    });
                }
            });
            Channel channel = bootstrap.connect("localhost",8088).sync().channel();
            channel.closeFuture().sync();
        }catch (Exception e) {
            System.out.println("客户端连接错误");
        }finally {
            group.shutdownGracefully();
        }
    }
}
