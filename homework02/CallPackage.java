package Homework02;

/**
 * 通话套餐类的实现
 */
public class CallPackage extends Package implements CallSever{
    private int callTime;//通话时长
    private int smsNum;//短信条数

    public CallPackage() {
        System.out.println("无参构造通话套餐类");
    }

    public CallPackage(int perMonCost, int callTime, int smsNum) {
        super(perMonCost);
        setCallTime(callTime);
        setSmsNum(smsNum);
        System.out.println("有参构造通话套餐类");
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        if(callTime>=0){
            this.callTime = callTime;
        }else {
            System.out.println("通话时长不合理。");
        }
    }

    public int getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(int smsNum) {
        if(smsNum>=0){
            this.smsNum = smsNum;
        }else{
            System.out.println("短信条数不合理");
        }
    }

    @Override
    public void show() {
        System.out.println("通话套餐信息如下：");
        System.out.println("通话时长："+getCallTime());
        System.out.println("短信条数："+getSmsNum());
        System.out.println("每月资费："+getPerMonCost());
    }

    @Override
    public void callSever(int callTime, Sims s) {
        System.out.println("实现通话服务接口");
    }
}
