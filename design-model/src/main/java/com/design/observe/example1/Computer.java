package com.design.observe.example1;

/**
 * @Author: w
 * @Date: 2021/5/19 9:03
 */
public class Computer implements Observer {

    private WeatherStation weatherStation;

    public Computer(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void updateData() {
        System.out.println("电脑端接收到"+weatherStation.getName()+"的天气信息为：{温度："+weatherStation.getTemperature()
                +"；湿度："+weatherStation.getHumidity()+"；气压："+weatherStation.getPress()+"}");
    }
}
