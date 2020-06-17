package Homework403;

import java.io.*;

public class CopyFileTask implements Runnable {
    private File src;
    private File dest;

    public CopyFileTask(File src, File dest) {
        setSrc(src);
        setDest(dest);
    }

    public File getSrc() {
        return src;
    }

    public void setSrc(File src) {
        this.src = src;
    }

    public File getDest() {
        return dest;
    }

    public void setDest(File dest) {
        this.dest = dest;
    }

    @Override
    public void run() {
        boolean flag=copyFile(src,dest);
        if(flag){
            System.out.println("线程"+Thread.currentThread()+"复制文件"+src+"成功");
        }
    }
    //复制文件方法
    public boolean copyFile(File src,File dest){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));
            System.out.println("正在复制文件"+src);
            byte[] bArr=new byte[1024];
            int res=0;
            while((res=bis.read(bArr))!=-1){
                bos.write(bArr,0,res);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
