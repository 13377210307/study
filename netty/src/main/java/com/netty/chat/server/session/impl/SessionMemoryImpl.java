package com.netty.chat.server.session.impl;

import com.netty.chat.server.session.Session;

import java.nio.channels.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: w
 * @Date: 2021/6/9 22:08
 */
public class SessionMemoryImpl implements Session {

    private final Map<String,Channel> usernameChannelMap = new ConcurrentHashMap<>();

    private final Map<Channel,String> channelUsernameMap = new ConcurrentHashMap<>();

    private final Map<Channel,Map<String,Object>> channelAttributesMap = new ConcurrentHashMap<>();

    @Override
    public void bind(Channel channel, String username) {
        usernameChannelMap.put(username,channel);
        channelUsernameMap.put(channel,username);
        channelAttributesMap.put(channel,new ConcurrentHashMap<>());
    }

    @Override
    public void unbind(Channel channel) {
        String username = channelUsernameMap.remove(channel);
        usernameChannelMap.remove(username);
        channelAttributesMap.remove(channel);
    }

    @Override
    public Object getAttribute(Channel channel, String name) {
        return this.channelAttributesMap.get(channel).get(name);
    }

    @Override
    public void setAttribute(Channel channel, String name, Object value) {
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put(name,value);
        this.channelAttributesMap.put(channel,map);
    }

    @Override
    public Channel getChannel(String username) {
        return this.usernameChannelMap.get(username);
    }
}
