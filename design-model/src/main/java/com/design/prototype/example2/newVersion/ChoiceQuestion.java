package com.design.prototype.example2.newVersion;

import lombok.Data;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/1 22:47
 */
@Data
public class ChoiceQuestion {

    private String name;                 // 题目
    private Map<String, String> option;  // 选项；A、B、C、D
    private String key;                  // 答案；B

    public ChoiceQuestion() {
    }

    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }
}
