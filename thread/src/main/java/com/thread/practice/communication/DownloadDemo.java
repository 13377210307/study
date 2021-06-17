package com.thread.practice.communication;

import com.thread.utils.DownLoadUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/17 22:58
 * 下载案例：一个线程执行下载操作；另一个线程获取下载后的结果
 */
@Slf4j
public class DownloadDemo {

    // 线程1等待线程2下载结果
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(() -> {
            log.debug("等待结果...");
            // 等待结果
            List<String> result = (List<String>)guardedObject.getResult();
            log.debug("结果为：{}", result.size());
        }, "waitResult").start();
        new Thread(() -> {
            log.debug("执行下载...");
            // 产生结果
            try {
                List<String> download = DownLoadUtil.download();
                guardedObject.complete(download);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }, "download").start();
    }
}

class GuardedObject {

    // 结果
    private Object response;

    // 获取结果
    public Object getResult() {
        synchronized (this) {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    // 生成结果
    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
