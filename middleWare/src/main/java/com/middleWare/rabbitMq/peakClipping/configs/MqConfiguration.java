package com.middleWare.rabbitMq.peakClipping.configs;

import com.middleWare.rabbitMq.peakClipping.enums.MqEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/18 9:17
 */
@Configuration
public class MqConfiguration {

    // 设置交换机
    @Bean
    public DirectExchange peakExchange() {
        return new DirectExchange(MqEnum.PEAK_EXCHANGE.name);
    }

    // 设置队列
    @Bean
    public Queue peakQueue() {
        //设置队列的初始化参数
        Map<String, Object> map = new HashMap<>();
        //指定消息队列的长度
        map.put("x-max-length", 500);
        //当队列满时，多余的消息直接拒绝接收，多余的消息被丢弃
        map.put("x-overflow", "reject-publish");
        /*
         * 参数1：队列的名字
         * 参数2：是否为持久队列，及时rabbitmq服务停机，之后在开机该队列也存在  一般队列默认都是持久的
         * 参数3：是否为排他队列，是否只能由自己可见（admin），其他用户看不到该队列
         * 参数4：是否在不适用该队列是删除该队列
         * 参数5：队列初始化的参数
         */
        return new Queue(MqEnum.PEAK_QUEUE.name,true,false,false,map);
    }

    // 绑定
    @Bean
    public Binding peakBinding() {
        return BindingBuilder.bind(peakQueue()).to(peakExchange()).with(MqEnum.PEAK_ROUTING_KEY.name);
    }
}
