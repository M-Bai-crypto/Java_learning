package com.learn.homework.another;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/5
 */
public class AnotherProgram {
    // 查看发送端是否已经关闭
    public static boolean isSender = false;
    // 访问共享变量使用同步锁
    public static Object lock = new Object();

    public static void main(String[] args) throws SocketException, UnknownHostException {
        // 定义接收和发送对象
        DatagramSocket datagramSocket = new DatagramSocket(5051);
        String ipStr = "127.0.0.1";
        int port = 1728;

        Sender sender = new Sender(datagramSocket,ipStr,port);
        Receive receive = new Receive(datagramSocket);
        new Thread(sender).start();
        new Thread(receive).start();
    }
}
