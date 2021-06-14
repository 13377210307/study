package com.netty.channel.demo;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: w
 * @Date: 2021/6/7 23:00
 */
public class FileChannelReadData {

    public static void main(String[] args) {
        try {
            File file = new File("E:/ownspace/study/netty/src/main/resources/data.txt");
            FileChannel channel = new FileInputStream(file).getChannel();
            // 准备缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            // 从channel中读取数据，向buffer写入
            while (true) {
                int len = channel.read(byteBuffer); // 读取完之后len会变为-1
                if (len == -1) {
                    break;
                }
                // 打印buffer的内容
                byteBuffer.flip(); // 切换读模式、
                while (byteBuffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte b = byteBuffer.get(); // 读数据
                    System.out.println((char) b);
                }

                // 切换写模式
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
