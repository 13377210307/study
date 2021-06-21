package com.thread.practice.communication;

import com.thread.utils.IdGenerateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/21 17:58
 * 案例：医院打疫苗案例：
 * 需求：近期新冠肺炎疫苗接种比较火热：现在有一个线程是疫苗生产厂家，另一个线程就是疫苗接种；
 * 疫苗没了需要通知厂家生产疫苗，让接种人群进行等待
 * 疫苗生产到达一定数量需要让通知人群进行接种，并让生产厂家停止生产
 */
@Slf4j
public class Hospital {

    public static void main(String[] args) {
        // 创建疫苗箱
        VaccineBox vaccineBox = new VaccineBox(100);

        // 生产疫苗线程
        for (int i = 0; i < 50; i++) {
            Integer id = i;
            new Thread(() -> {
                long idName = IdGenerateUtil.snowflakeId();
                vaccineBox.createVaccine(new Vaccine(id, "疫苗" + idName + "号"));
                log.debug("生产疫苗：{}", idName);
            }, "厂家" + id).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 接种疫苗线程
        for (int i = 0; i < 5; i++) {
            Integer id = i;
            new Thread(() -> {
                while (true) {
                    Vaccine vaccine = vaccineBox.inoculateVaccine();
                    log.debug("接种疫苗为：{}", vaccine);
                }
            }, "接种人" + id).start();
        }

    }


}

// 疫苗箱
@Slf4j
class VaccineBox {

    // 疫苗
    private LinkedList<Vaccine> vaccines = new LinkedList<>();

    // 容量
    private Integer capcity;

    public VaccineBox(Integer capcity) {
        this.capcity = capcity;
    }

    // 生产疫苗
    public void createVaccine(Vaccine vaccine) {
        synchronized (vaccines) {
            // 当疫苗容量大于疫苗箱容量生产疫苗方法需要进行等待
            while (vaccines.size() >= capcity) {
                log.debug("生产疫苗过多，请厂家停止生产...");
                try {
                    vaccines.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 将生产的疫苗加入疫苗箱中
            vaccines.addLast(vaccine);
            // 唤醒接种疫苗
            vaccines.notifyAll();
        }
    }

    // 接种疫苗
    public Vaccine inoculateVaccine() {
        synchronized (vaccines) {
            // 当疫苗箱中疫苗已经没了就需要让接种疫苗的人群进行等待
            while (vaccines.isEmpty()) {
                log.debug("疫苗不足，请稍候进行接种...");
                try {
                    vaccines.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 将疫苗进行返回
            Vaccine vaccine = vaccines.removeFirst();
            // 唤醒生产疫苗
            vaccines.notifyAll();
            return vaccine;
        }
    }
}

// 疫苗
@Data
class Vaccine {

    private Integer id;

    private String name;

    public Vaccine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
