package Homework02;

import com.lagou.com.lagou.task09.StaticOuter;

/**
 * 上网套餐类的实现
 */
public class InternetPackage extends Package implements InternetServer{
    private double data;//上网流量

    public InternetPackage() {
        System.out.println("无参构造上网套餐类");
    }

    public InternetPackage(int perMonCost, double data) {
        super(perMonCost);
        setData(data);
        System.out.println("有参构造上网套餐类");
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        if(data>=0){
            this.data = data;
        }else {
            System.out.println("上网流量不合理");
        }
    }

    @Override
    public void show() {
        System.out.println("上网套餐信息如下：");
        System.out.println("上网流量："+getData());
        System.out.println("每月资费："+getPerMonCost());
    }

    @Override
    public void internetServer(double data, Sims sims) {
        System.out.println("实现上网服务接口");
    }
}
