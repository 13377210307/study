package com.netty.byteBuffer;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * @Author: w
 * @Date: 2021/6/8 22:59
 */
public class ByteBufferMethods {

    public static void main(String[] args) {
        byteBufferAllocate();
    }

    // 设置byteBuffer容量
    private static void byteBufferAllocate() {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());

        /**
         * class java.nio.HeapByteBuffer   -java堆内存：读写效率较低，受到GC的影响
         * class java.nio.DirectByteBuffer  --直接内存，读写效率高（少一次拷贝），不受GC影响
         */
    }

    // 向buffer中写入数据  1：采用channel的read方法   2：采用buffer自己的put方法
    private static void write() {
       
    }
}
