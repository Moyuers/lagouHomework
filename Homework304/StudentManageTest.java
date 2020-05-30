package Homework304;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManageTest {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        StudentFormat sf=new StudentFormat();
        Scanner s=new Scanner(System.in);
        //页面
        while(true){
            System.out.println("-----------学生成绩管理系统-------------");
            System.out.println("1.查询学生             2.增加学生");
            System.out.println("3.修改学生             4.删除学生");
            System.out.println("5.查找学生             0.退出系统");
            int option=s.nextInt();
            Student stu;
            int id;
            String name;
            switch (option){
                case 1:
                    sf.showStudent(students);
                    break;
                case 2:
                    while(true){
                        System.out.println("请输入增加学生的信息（学号 姓名 年龄）：");
                        stu=new Student(s.nextInt(),s.next(),s.nextInt());
                        boolean is=sf.addStudent(students,stu);
                        if (true==is) break;
                    }
                    break;
                case 3:
                    System.out.println("请输入修改学生的id：");
                    id=s.nextInt();
                    System.out.println("请输入修改学生的信息（姓名 年龄）：");
                    stu=new Student(id,s.next(),s.nextInt());
                    sf.changeStudent(students,id,stu);
                    break;
                case 4:
                    System.out.println("请输入要删除学生的id：");
                    id=s.nextInt();
                    sf.deleteStudent(students,id);
                    break;
                case 5:
                    System.out.println("请选择：1.按姓名查找；2.按id查找");
                    int choice=s.nextInt();
                    if(choice==1){
                        System.out.println("请输入查找的姓名：");
                        name=s.next();
                        sf.searchStudent(students,name);
                    }else{
                        System.out.println("请输入查找的id：");
                        id=s.nextInt();
                        sf.searchStudent(students,id);
                    }
                    break;
                case 0:
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
