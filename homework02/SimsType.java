package Homework02;

/**
 * 手机卡类型枚举类
 */
public enum SimsType {
    BIG("大卡"),SMALL("小卡"),MICRO("微型卡");
    private String name;
    private SimsType(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}