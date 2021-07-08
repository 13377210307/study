package com.thread.forkJoin;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: w
 * @Date: 2021/6/28 8:36
 * 使用fork...join进行求和
 * fork...join采用的分治思想，他会将大任务分成一个个小任务，然后将这些小任务再合起来
 */
public class CalculateSumTask extends RecursiveTask<Integer> {

    private static final int THREAD_HOLD = 2;//设置分割阈值

    private List<Integer> numbers;

    public CalculateSumTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,5,7,9,11);
        CalculateSumTask calculateSumTask = new CalculateSumTask(numbers);
        Integer compute = calculateSumTask.compute();
        System.out.println(compute);
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        // 判断是否需要进行分治
        if (CollectionUtil.isEmpty(numbers)) {
            return 0;
        }
        Boolean needDivideCompute = numbers.size() > THREAD_HOLD;
        if (needDivideCompute) {
            // 采用fork...join进行分治计算
            int middle = (numbers.size()) / 2;
            CalculateSumTask left = new CalculateSumTask(numbers.subList(0,middle));
            CalculateSumTask right = new CalculateSumTask(numbers.subList(middle + 1,numbers.size()));
            //并行执行子任务
            invokeAll(left, right);
            //获取子任务结果
            int lResult = left.join();
            int rResult = right.join();
            sum = lResult + rResult;
        }else {
            // for循环进行计算
            for (Integer number : numbers) {
                sum += number;
            }
        }
        return sum;
    }
}

