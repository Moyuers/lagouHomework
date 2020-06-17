package Homework404;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        Socket s= null;
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try {
            s = new Socket("127.0.0.1",8888);
            System.out.println("连接服务器成功");
            //从控制台输入用户名和密码
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入用户名：");
            String userName=sc.next();
            System.out.println("请输入密码：");
            String password=sc.next();
            //创建User和UserMessage对象
            User u=new User(userName,password);
            UserMessage us=new UserMessage("check",u);
            //对象流向服务器发送
            oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(us);
            //接收服务器反馈消息
            ois=new ObjectInputStream(s.getInputStream());
            us= (UserMessage) ois.readObject();
            //判断反馈消息并打印出结果
            if(us.getType().equals("success")){
                System.out.println("用户登录成功");
            }else if(us.getType().equals("fail")){
                System.out.println("用户名或密码错误，登录失败");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null!=ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
