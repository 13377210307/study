package com.jdk8.lambda.compare;

/**
 * @Author: w
 * @Date: 2021/5/16 16:42
 */
public interface MyFilter<T> {

    Boolean filter(T t,Object object);
}
