package Homework405;

import java.io.*;
import java.net.Socket;

/**
 * 客户端接收消息线程
 */

public class ClientReceiveThread extends Thread{
    private Socket s=null;
    private BufferedReader br=null;
    private DataInputStream dis=null;
    private BufferedInputStream bis=null;
    private BufferedOutputStream bos=null;

    public ClientReceiveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                dis=new DataInputStream(s.getInputStream());
                int choice=dis.readInt();
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                if(choice==1){
                    String str=br.readLine();
                    System.out.println("客户端"+str);
                }
                if(choice==2){
                    //获取文件名
                    String fileName=br.readLine();
                    //定义输出文件
                    File f=new File("E:/receive/"+fileName);
                    f.getParentFile().mkdirs();
                    bis=new BufferedInputStream(s.getInputStream());
                    bos=new BufferedOutputStream(new FileOutputStream(f));
                    byte[] bArr=new byte[1024];
                    int res=0;
                    while((res=bis.read(bArr))!=-1) {
                        bos.write(bArr, 0, res);
                    }
                    System.out.println("收到文件:"+fileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
