package Homework405;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTest {
    public static void main(String[] args) {
        ServerSocket ss= null;
        Socket s= null;
        ExecutorService es= Executors.newCachedThreadPool();
        List<ServerThread> clients=new ArrayList<ServerThread>();
        try {
            ss = new ServerSocket(6666);
            System.out.println("服务器启动");
            while(true){
                System.out.println("客户端正在连接");
                s = ss.accept();
                ServerThread st=new ServerThread(s,clients);
                new Thread(st).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

