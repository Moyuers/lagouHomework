package Homework405;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端发送消息线程
 */

public class ClientSendThread extends Thread{
    private Socket s=null;
    private PrintStream ps=null;
    private DataOutputStream dos=null;
    private BufferedOutputStream bos=null;
    private BufferedInputStream bis=null;
    public ClientSendThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        //不断发送消息
        while (true){
            Scanner sc=new Scanner(System.in);
            System.out.println("请选择：1.聊天 2.传输文件 3.退出");
            try {
                dos=new DataOutputStream(s.getOutputStream());
                int choice=sc.nextInt();
                dos.writeInt(choice);
                if(choice==1){
                    System.out.println("请发送聊天内容：");
                    String str=sc.next();
                    ps=new PrintStream(s.getOutputStream());
                    ps.println(str);
                }else if(choice==2){
                    System.out.println("请输入文件路径：");
                    String path=sc.next();
                    sendFile(path);
                    ps=new PrintStream(s.getOutputStream());
                    String fileName=new File(path).getName();
                    ps.println(fileName);
                }else if(choice==3){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
        System.out.println("客户端"+s.getPort()+"断开连接");
    }
    public void sendFile(String path){
        try {
            File f=new File(path);
            bos=new BufferedOutputStream(s.getOutputStream());
            bis=new BufferedInputStream(new FileInputStream(f));
            System.out.println("正在传输文件"+path+",文件大小："+f.length());
            byte[] bArr=new byte[1024];
            int res=0;
            while((res=bis.read(bArr))!=-1){
                bos.write(bArr,0,res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
