package Homework403;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyDirectoryTest {
    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        copyFolder("E:/src","E:/srcCopy",es);
        es.shutdown();
    }
    public static void copyFolder(String srcPath, String destPath,ExecutorService es){

        File srcFolder = new File(srcPath);
        File destFolder = new File(destPath);
        //源文件夹不存在
        if(!srcFolder.exists())
            return;
        //源文件夹不是一个文件夹
        if(!srcFolder.isDirectory())
            return;
        //目标文件夹是一个文件
        if(destFolder.isFile())
            return;
        //目标文件夹不存在
        if(!destFolder.exists())
            destFolder.mkdirs();

        //遍历源文件夹
        File[] files=  srcFolder.listFiles();
        for (File srcFile : files) {
            //如果是文件，就复制
            if(srcFile.isFile()){
                File newDestFile = new File(destFolder,srcFile.getName());
                es.execute(new CopyFileTask(srcFile,newDestFile));
            }
            //如果是文件夹，就递归
            if(srcFile.isDirectory()){
                File newDestFolder = new File(destFolder,srcFile.getName());
                copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath(),es);
            }
        }
    }
}
