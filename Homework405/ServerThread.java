package Homework405;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerThread implements Runnable{
    private Socket s=null;
    private List<ServerThread> clients=null;
    private boolean flag=true;
    private BufferedReader br=null;
    private PrintStream ps=null;
    private DataInputStream dis=null;
    private DataOutputStream dos=null;
    private BufferedInputStream bis,bisf=null;
    private BufferedOutputStream bos,bosf=null;
    public ServerThread(Socket s,List<ServerThread> clients) {
        setS(s);
        this.clients=clients;
        clients.add(this);
        try {
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps=new PrintStream(s.getOutputStream());
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            bis=new BufferedInputStream(s.getInputStream());
            bos=new BufferedOutputStream(s.getOutputStream());
        } catch (IOException e) {
            flag=false;
            clients.remove(this);
            e.printStackTrace();
        }
    }


    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("客户端"+s.getPort()+"连接成功");
        while(flag){
            int choice= 0;
            try {
                choice = dis.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(choice==1){
                String message=receive();
                sendAll(message);
            }else if(choice==2){
                try {
                    String fileName=br.readLine();
                    System.out.println("收到文件"+fileName);
                    File f=new File("E:/tempServe/"+fileName);
                    f.getParentFile().mkdirs();
                    receiveFile(f);
                    sendFileAll(fileName,f);
                    f.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }else if(choice==3){
                clients.remove(this);
                System.out.println("客户端"+s.getPort()+"断开连接");
            }
        }
    }
    //接收消息
    public String receive(){
        String str="";
        try {
            str=br.readLine();
            System.out.println(s.getPort()+"发来消息"+str);
            str=s.getPort()+":"+str;
            return str;
        } catch (IOException e) {
            flag=false;
            clients.remove(this);
            e.printStackTrace();
        }
        return str;
    }
    //给一个客户端发送消息
    public void send(String str){
        if (null==str) return;
        try {
            dos.writeInt(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ps.println(str);
    }
    //给所有客户端发送消息
    public void sendAll(String str){
        for(ServerThread each:clients){
            if (each==this){
                continue;
            }else {
                each.send(str);
            }
        }
    }
}
