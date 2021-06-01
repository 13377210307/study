package com.design.prototype.example2.oldVersion;

import lombok.Data;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/1 22:45
 */
@Data
public class AnswerQuestion {

    private String name;  // 问题
    private String key;   // 答案

    public AnswerQuestion() {
    }

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }
}
