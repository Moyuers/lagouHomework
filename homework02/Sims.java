package Homework02;

/**
 * 手机卡类的实现
 */
public class Sims {
    private SimsType type;//卡类型
    private int id;//卡号
    private String username;//用户名
    private String password;//密码
    private int balance;//账户余额
    private int callTime;//通话时长
    private double data;//流量

    public Sims() {
        System.out.println("无参构造手机卡类");
    }

    public Sims(SimsType type, int id,String username, int balance) {
        setType(type);
        setId(id);
        setUsername(username);
        setBalance(balance);
        System.out.println("有参构造手机卡类");
    }

    public String getType() {
        return type.getName();
    }

    public void setType(SimsType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public void show(){
        System.out.println("卡号："+getId()+",用户名："+getUsername()+",当前余额："+getBalance());
        System.out.println("卡类型："+getType());
    }
}
