package Homework402;

import java.io.File;
import java.io.IOException;

public class DeleteDirectoryTest {
    public static void main(String[] args) {
       /* //创建一个含内容的文件夹方便删除测试
        createFile(new File("E:/a/b/c1/a.txt"));
        createFile(new File("E:/a/b/c1/yuer.java"));
        createFile(new File("E:/a/b/c1/akb.mp4"));
        createFile(new File("E:/a/b2/c1/akb.mp4"));
        createFile(new File("E:/a/b/c2/aa.jpg"));
        createFile(new File("E:/a/ee/898.doc"));*/
        //删除E:/a文件夹
        File f=new File("E:/a");
        System.out.println(deleteFolder(f)?"删除目录成功":"删除目录失败");
    }
    //删除整个文件夹方法
    public static boolean deleteFolder(File f){
        //文件夹不存在
        if(!f.exists()){
            System.out.println("该目录不存在");
            return false;
        }
        //是目录
        if(f.isDirectory()){
            File[] files=f.listFiles();
            for(File each:files){
                boolean success=deleteFolder(each);
                if(!success) return false;
            }
        }
        //是文件或遍历结束后的空目录
        if(f.delete()){
            System.out.println("文件"+f.getAbsolutePath()+"删除成功");
            return true;
        }else{
            System.out.println("文件"+f.getAbsolutePath()+"删除失败");
        }
        return false;
    }
    //创建文件
    public static void createFile(File f){
        f.getParentFile().mkdirs();
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
