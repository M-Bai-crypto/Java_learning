package com.learn.homework.one;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/5
 */
public class Receive implements Runnable{
    // 定义接收端数据
    // DatagramPacket(byte[] buf, int offset, int length)
    // 构造 DatagramPacket，用来接收长度为 length 的包，在缓冲区中指定了偏移量。
    private DatagramSocket receiveSocket;

    // 防止自循环时编译器报错
    private boolean flag = true;

    public Receive(DatagramSocket receiveSocket){
        this.receiveSocket = receiveSocket;
    }

    @Override
    public void run() {
        // 接收数据
        try {
            while (true){
                // 定义接收数据报包
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
                // 接收数据
                receiveSocket.receive(datagramPacket);
                // 业务逻辑处理消息
                String s = new String(datagramPacket.getData(),datagramPacket.getOffset(),datagramPacket.getLength());
                System.out.println("接收到来自" + datagramPacket.getAddress() + "/" + datagramPacket.getPort() + ": " +s);
                if ("exit".equals(s)) {
                    System.out.println("接收端退出");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 在receive中同一关闭资源
            while (flag){
                synchronized (OneProgram.lock){
                    if (OneProgram.isSender){
                        break;
                    }
                }
                // 防止过度请求
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            receiveSocket.close();
        }
    }
}
