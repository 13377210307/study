package com.study.newDesignModel.bridge.newVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/3 8:52
 */
@Data
public abstract class Pay {

    private PayType payType;

    abstract String payMoney();
}
