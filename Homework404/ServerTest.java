package Homework404;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) {
        ServerSocket ss= null;
        Socket s= null;
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ss = new ServerSocket(8888);
            System.out.println("等待客户端的请求");
            s=ss.accept();
            System.out.println("客户端连接成功");
            //接收客户端传来的UserMessage对象
            ois=new ObjectInputStream(s.getInputStream());
            UserMessage us= (UserMessage) ois.readObject();
            User u=us.getUserObj();
            if(u.getUserName().equals("admin")&&u.getPassword().equals("123456")){
                us.setType("success");
            }else {
                us.setType("fail");
            }
            //向客户端传输检测结果
            oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(us);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null!=oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=ois) {
                try {
                    ois.close();
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
            if (null!=ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
