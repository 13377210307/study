package com.design.publishSubscribe.example1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: w
 * @Date: 2021/5/24 16:08
 * 报社抽象类
 */
@Data
public abstract class News {

    // 报社名称
    private String name;

    // 发布文章
    private String articles;

    // 关注读者
    private List<Reader> readers = new ArrayList<>();

    // 抽象方法：读者关注
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // 抽象方法：读者取消关注
    public void removeReader(Reader reader) {
        readers.remove(reader);
    }

    // 抽象方法：通知读者发布文章
    public void notifyAllReaders() {
        for (Reader reader : readers) {
            reader.updateData();
        }
    }

}
