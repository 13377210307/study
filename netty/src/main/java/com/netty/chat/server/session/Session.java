package com.netty.chat.server.session;

import java.nio.channels.Channel;

/**
 * @Author: w
 * @Date: 2021/6/9 22:04
 * 会话管理接口
 */
public interface Session {

    /**
     * 绑定会话：channel与用户绑定
     */
    void bind(Channel channel,String username);

    /**
     * 解绑会话
     */
    void unbind(Channel channel);

    /**
     * 获取属性
     */
    Object getAttribute(Channel channel,String name);

    /**
     * 设置属性
     */
    void setAttribute(Channel channel,String name,Object value);

    /**
     * 根据用户名获取channel
     */
    Channel getChannel(String username);

}
