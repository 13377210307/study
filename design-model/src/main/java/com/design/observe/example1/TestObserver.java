package com.design.observe.example1;

/**
 * @Author: w
 * @Date: 2021/5/19 9:04
 */
public class TestObserver {

    public static void main(String[] args) {
        // 设置被观察者数据
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setName("天气观测站1号");
        weatherStation.setTemperature(100);
        weatherStation.setPress(100);
        weatherStation.setHumidity(100);

        // 初始化观察者
        Observer phone = new Phone(weatherStation);
        Observer computer = new Computer(weatherStation);

        // 将观察者加入到观察者集合中
        weatherStation.addObservers(phone);
        weatherStation.addObservers(computer);

        // 通知观察者更新信息
        weatherStation.noticeAllObservers();
    }
}
