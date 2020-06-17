package Homework401;

import java.io.*;
import java.util.List;

/**
 * 增删改查遍历方法类
 */

public class StudentFormat {
    //增方法
    public boolean addStudent(List<Student> students, Student stu){
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
    public void deleteStudent(List<Student>students, int id){
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
    public void changeStudent(List<Student> students, int id, Student s){
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
    public void searchStudent(List<Student> students, int id){
        for (Student each:students){
            if(each.getId()==id){
                System.out.println(each);
                return;
            }
        }
        System.out.println("未查找到指定id的学生信息");
    }//按id查找
    public void searchStudent(List<Student> students, String name){
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
    //退出系统时将List信息存入文件
    public void saveStudent(List<Student> students, FileOutputStream fos){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            System.out.println("将学生信息写入文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //根据文件读取List信息
    public List<Student> readStudent(FileInputStream fis){
        ObjectInputStream ois= null;
        List<Student> students=null;
        try {
            ois = new ObjectInputStream(fis);
            students= (List<Student>) ois.readObject();
            System.out.println("读取学生信息文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null!=ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return students;
    }
}
