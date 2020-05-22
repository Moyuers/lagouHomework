package Homework02;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        //手机卡类与show方法
        Sims sn=new Sims();
        System.out.println("------------------我是分割线--------------------");
        Sims s = new Sims(SimsType.BIG,1541232,"用户名",133);
        s.show();
        //套餐类＋多态
        System.out.println("------------------我是分割线--------------------");
        Package cpN=new CallPackage();
        Package ipN=new InternetPackage();
        System.out.println("------------------我是分割线--------------------");
        System.out.println("通话套餐类");
        Package cp=new CallPackage(28,4000,500);
        cp.show();
        if(cp instanceof CallPackage) {
            ((CallPackage) cp).callSever(28,s);
        }
        System.out.println("------------------我是分割线--------------------");
        System.out.println("上网套餐类");
        Package ip=new InternetPackage(128,485.27);
        ip.show();
        if(ip instanceof InternetPackage){
            ((InternetPackage) ip).internetServer(45.33,s);
        }
        //用户消费信息类
        System.out.println("------------------我是分割线--------------------");
        AccountCostInf aciN=new AccountCostInf();
        AccountCostInf aci=new AccountCostInf(2880,47.58,189);
    }
}
