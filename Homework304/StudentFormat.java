package Homework304;

import java.util.List;

/**
 * 增删改查遍历方法类
 */

public class StudentFormat {
    //增方法
    public boolean addStudent(List<Student> students,Student stu){
        for (Student each:students){
            if (each.getId()==stu.getId()){
                System.out.println("学号冲突,请重新输入：");
                return false;
            }
        }
        students.add(stu);
        System.out.println("添加成功");
        return true;
    }
    //删方法
    public void deleteStudent(List<Student>students,int id){
        for(Student each:students){
            if (each.getId()==id){
                students.remove(each);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("找不到指定id的学生信息");
    }
    //改方法
    public void changeStudent(List<Student> students,int id,Student s){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,s);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("找不到指定id的学生信息");
    }
    //查方法
    public void searchStudent(List<Student> students,int id){
        for (Student each:students){
            if(each.getId()==id){
                System.out.println(each);
                return;
            }
        }
        System.out.println("未查找到指定id的学生信息");
    }//按id查找
    public void searchStudent(List<Student> students,String name){
        int count=0;
        for(Student each:students){
            if(each.getName().equals(name)){
                System.out.println(each);
                count++;
            }
        }
        if (count==0){
            System.out.println("未查找到指定姓名的学生信息");
        }
    }//按姓名查找
    //遍历
    public void showStudent(List<Student> students){
        if(students.size()==0){
            System.out.println("暂无学生信息");
            return;
        }
        for (int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }
}
