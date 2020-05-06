//自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。 例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
import java.util.Scanner;

public class ExpandArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] array = new int[10];
        int i=0;
        while(!s.hasNext("eof")){
            if(i>=(int)(array.length*0.8)){
                int[] newArray = new int[(int)(array.length*1.5)];//建立个新的扩容数组
                System.arraycopy(array,0,newArray,0,i);//将源数组的内容拷贝给新数组
                array=newArray;//源数组指向新数组的地址，现在源数组已是扩容后的数组
            }
            array[i++]=s.nextInt();
        }
        System.out.println("现在数组的长度为"+array.length);
    }
}
