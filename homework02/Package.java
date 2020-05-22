package Homework02;

/**
 * 套餐类的实现
 */
public abstract class Package {
    private int perMonCost;//每月资费

    public Package() {
        System.out.println("无参构造套餐类");
    }

    public Package(int perMonCost) {
        setPerMonCost(perMonCost);
        System.out.println("有参构造套餐类");
    }

    public int getPerMonCost() {
        return perMonCost;
    }

    public void setPerMonCost(int perMonCost) {
        if(perMonCost>=0){
            this.perMonCost = perMonCost;
        }else {
            System.out.println("每月资费不合理。");
        }
    }

    public abstract void show();//显示所有套餐信息的抽象方法
}
