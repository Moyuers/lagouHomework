package Homework02;

/**
 * 实现用户消费信息类
 */
public class AccountCostInf {
    private int callTimeSum;//统计通话时长
    private double dataSum;//统计上网流量
    private int perMonthCost;//每月消费金额

    public AccountCostInf() {
        System.out.println("无参构造用户消费信息类");
    }

    public AccountCostInf(int callTimeSum, double dataSum, int perMonthCost) {
        setCallTimeSum(callTimeSum);
        setDataSum(dataSum);
        setPerMonthCost(perMonthCost);
        System.out.println("有参构造用户消费信息类");
    }

    public int getCallTimeSum() {
        return callTimeSum;
    }

    public void setCallTimeSum(int callTimeSum) {
        this.callTimeSum = callTimeSum;
    }

    public double getDataSum() {
        return dataSum;
    }

    public void setDataSum(double dataSum) {
        this.dataSum = dataSum;
    }

    public int getPerMonthCost() {
        return perMonthCost;
    }

    public void setPerMonthCost(int perMonthCost) {
        this.perMonthCost = perMonthCost;
    }
}
