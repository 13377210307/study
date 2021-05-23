package com.design.observe.example2;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/23 18:51
 * 报社
 */
@Data
public class NewsStation {

    // 报社名称
    private String name;

    // 报社出版文章
    private String article;

    // 读者
    private List<ReaderObserver> readers = new ArrayList<>();

    // 增加新读者
    public void addReader(ReaderObserver readerObserver) {
        this.readers.add(readerObserver);
    }

    // 移除读者
    public void removeReader(ReaderObserver readerObserver) {
        this.readers.remove(readerObserver);
    }

    // 通知读者
    public void notifyAllReaders() {
        if (CollectionUtil.isNotEmpty(readers)) {
            for (ReaderObserver reader : readers) {
                reader.getArticle();
            }
        }
    }


}
