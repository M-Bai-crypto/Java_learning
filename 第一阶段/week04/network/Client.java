package com.learn.network;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

/**
 * Client上传图片,路径从配置文件中读取
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/6
 */
public class Client {
    public static void main(String[] args) {
        Socket uploadImgSocket = null;
        FileInputStream fisConfig = null;
        BufferedInputStream bis = null;
        try {
            // 创建socket对象并得到输出流
            uploadImgSocket = new Socket("127.0.0.1", 7823);
            OutputStream os = uploadImgSocket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);

            // 读取配置文件中的地址
            Properties configFile = new Properties();
            fisConfig = new FileInputStream("imgSource.properties");
            configFile.load(fisConfig);
            String fileSrc = configFile.getProperty("fileSrc");

            // 传输文件,结束后关闭发送通道
            bis = new BufferedInputStream(new FileInputStream(fileSrc));
            int len;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            bos.flush();
            uploadImgSocket.shutdownOutput();

            // 获取服务器通知
            InputStream is = uploadImgSocket.getInputStream();
            len = is.read(buf);
            System.out.println(new String(buf, 0, len));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close
            closeQuietly(fisConfig);
            closeQuietly(bis);
            closeQuietly(uploadImgSocket);
        }
    }

    private static void closeQuietly(Closeable cl) {
        if (cl != null) {
            try {
                cl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
