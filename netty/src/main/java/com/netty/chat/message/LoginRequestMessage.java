package com.netty.chat.message;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/9 22:56
 */
@Data
public class LoginRequestMessage extends Message {

    private String username;

    private String password;

    public LoginRequestMessage() {
    }

    public LoginRequestMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public int getMessageType() {
        return 1;
    }
}
