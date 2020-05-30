package Homework304;

import java.util.Objects;

/**
 * 学生信息类
 */

public class Student {
    private int id;//学号
    private String name;//姓名
    private int age;//年龄


    public Student() {
    }

    public Student(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "学生id：" + id +
                ", 学生姓名：" + name +
                ", 学生年龄：" + age +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id>0){
            this.id = id;
        }else{
            System.out.println("id不合理");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0&&age<=150){
            this.age = age;
        }else {
            System.out.println("年龄不合理");
        }
    }
}
