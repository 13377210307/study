package com.thread.createThread.thread.practice;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author: w
 * @Date: 2021/6/12 11:22
 * 多线程下载图片
 */
public class DownloadImages {


    public static void main(String[] args) {
        String url = "https://img14.360buyimg.com/n0/jfs/t1/146378/24/14918/28991/5fb62ddbE42a7379f/9478962430f6f10f.jpg";
        new Thread(() -> {
            webDownload(url, "mac1.jpg");
            System.out.println("线程1执行");
        },"线程1").start();
        new Thread(() -> {
            webDownload(url, "mac2.jpg");
            System.out.println("线程2执行");
        },"线程2").start();
        new Thread(() -> {
            webDownload(url, "mac3.jpg");
            System.out.println("线程3执行");
        },"线程3").start();
    }

    private static void webDownload(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("出现io异常....");
        }
    }
}
