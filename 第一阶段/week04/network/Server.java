package com.learn.network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server接收图片文件
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/6
 */
public class Server {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket fileServer = null;
        BufferedOutputStream bos = null;
        try {
            // 创建对象并获取流
            serverSocket = new ServerSocket(7823);
            fileServer = serverSocket.accept();
            InputStream is = fileServer.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            // 接收文件
            bos = new BufferedOutputStream(new
                    FileOutputStream("copyImg.jpg"));
            int len;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1){
                bos.write(buf,0,len);
            }
            bos.flush();

            // 回复消息
            InetAddress address = fileServer.getInetAddress();
            int port = fileServer.getPort();
            System.out.println("Client:" + address + "/" + port + ": 文件已上传");
            OutputStream os = fileServer.getOutputStream();
            os.write("文件上传完成".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close
            closeQuietly(bos);
            closeQuietly(fileServer);
            closeQuietly(serverSocket);
        }
    }

    private static void closeQuietly(Closeable cl) {
        if (cl != null){
            try {
                cl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
