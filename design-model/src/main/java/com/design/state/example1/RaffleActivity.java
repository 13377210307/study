package com.design.state.example1;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/29 11:43
 */
public class RaffleActivity {

    State state = null;
    // 奖品数量
    Integer count = 0;

    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);

    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);

    // 初始化当前活动状态：不能抽奖
    // 初始化奖品数量
    public RaffleActivity(Integer count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    // 扣积分
    public void deductMoney() {
        state.deductMoney();
    }

    // 领奖品
    public void raffle() {
        if (state.raffle()) {
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // 每领取一次奖品，数量需要减少
    public Integer getCount() {
        int curCount = count;
        count --;
        return curCount;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
