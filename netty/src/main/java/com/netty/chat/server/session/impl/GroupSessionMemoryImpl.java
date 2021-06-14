package com.netty.chat.server.session.impl;

import com.netty.chat.server.session.Group;
import com.netty.chat.server.session.GroupSession;

import java.nio.channels.Channel;
import java.util.List;
import java.util.Set;

/**
 * @Author: w
 * @Date: 2021/6/9 22:24
 *
 */
public class GroupSessionMemoryImpl implements GroupSession {
    @Override
    public Group createGroup(String name, Set<String> members) {
        return null;
    }

    @Override
    public Group joinMember(String name, String member) {
        return null;
    }

    @Override
    public Group removeMember(String name, String member) {
        return null;
    }

    @Override
    public Group removeGroup(String name) {
        return null;
    }

    @Override
    public Set<String> getMembers(String name) {
        return null;
    }

    @Override
    public List<Channel> getMembersChannel(String name) {
        return null;
    }
}
