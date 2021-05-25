package com.design.publishSubscribe.example2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/24 17:39
 */
@Data
public abstract class News {

    // 报社名称
    private String name;

    // 文章
    private String articles;

    // 关注读者
    private List<RealReader> readers = new ArrayList<>();

    // 读者关注

}
