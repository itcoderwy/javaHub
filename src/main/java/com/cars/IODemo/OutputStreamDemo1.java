package com.cars.IODemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 字节输出流
 * @Author Wy005
 * @Date 2020/7/28 15:23
 * @Version 1.0
 **/
public class OutputStreamDemo1 {

    /**
     * 写入数据得原理:
     * java程序--->JVM(虚拟机)--->os(操作系统)--->os调用写数据得方法--->把数据写入到文件中
     */
    public static void main(String[] args) throws Exception {
        /**
         * 字节输出流得使用步骤:
         * 1,创建fileoutputStream对象,构造方法中写入数据得目的地
         * 2,调用fileoutputStream得write方法,把数据写入文件中
         * 3,流使用完了要释放资源
         */
       /* FileOutputStream fos = new FileOutputStream("C:\\Users\\Wy005\\Desktop\\IO流练习\\aa.txt");
        fos.write(97);
        fos.close();*/

       /* FileOutputStream fos1 = new FileOutputStream(new File("C:\\Users\\Wy005\\Desktop\\IO流练习\\b.txt"));
        fos1.write(97);
        fos1.write(98);
        fos1.write(96);
        fos1.write(100);
        fos.close();
        */

        FileOutputStream fos2 = new FileOutputStream("C:\\Users\\Wy005\\Desktop\\IO流练习\\aa.txt",true);
        //换行符号
        fos2.write("\r\n".getBytes());
        fos2.write("helloIO".getBytes());
        fos2.close();
    }


}
