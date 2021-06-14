package com.netty.chat.server.session;

import java.nio.channels.Channel;
import java.util.List;
import java.util.Set;

/**
 * @Author: w
 * @Date: 2021/6/9 22:16
 * 聊天组会话接口
 */
public interface GroupSession {

    /**
     * 创建一个聊天组，不存在才能创建成功，否则返回false
     */
    Group createGroup(String name, Set<String> members);

    /**
     * 加入聊天组
     */
    Group joinMember(String name,String member);

    /**
     * 移除组成员
     */
    Group removeMember(String name,String member);

    /**
     * 移除聊天组
     */
    Group removeGroup(String name);

    /**
     * 获取组成员
     */
    Set<String> getMembers(String name);

    /**
     * 获取组成员channel集合，只有在线channel才返回
     */
    List<Channel> getMembersChannel(String name);



}
