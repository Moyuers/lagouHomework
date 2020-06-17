package Homework405;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 6666);
            System.out.println("连接服务器成功");
            //运行接收和发送消息两个线程
            ClientSendThread send=new ClientSendThread(s);
            ClientReceiveThread receive=new ClientReceiveThread(s);
           // ClientReceiveFileThread fileReceive=new ClientReceiveFileThread(s);
            //接收线程设为守护线程，方便在用户选择退出后结束整个客户端
            receive.setDaemon(true);
            //fileReceive.setDaemon(true);
            send.start();
            receive.start();
            //fileReceive.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
