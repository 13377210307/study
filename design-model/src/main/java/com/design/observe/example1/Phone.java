package com.design.observe.example1;

/**
 * @Author: w
 * @Date: 2021/5/19 8:58
 */
public class Phone implements Observer {

    private WeatherStation weatherStation;

    public Phone(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void updateData() {
        System.out.println("手机端接收到"+weatherStation.getName()+"的天气信息为：{温度："+weatherStation.getTemperature()
                +"；湿度："+weatherStation.getHumidity()+"；气压："+weatherStation.getPress()+"}");
    }
}
