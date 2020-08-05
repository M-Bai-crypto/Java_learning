package com.learn.homework.another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 定义发送端
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/5
 */
public class Sender implements Runnable {
    // DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
    // 定义发送端数据
    private DatagramSocket sendSocket;
    private InetAddress address;
    private int port;

    public Sender(DatagramSocket sendSocket, String address, int port) throws UnknownHostException {
        this.sendSocket = sendSocket;
        this.address = InetAddress.getByName(address);
        this.port = port;
    }

    @Override
    public void run() {
        // 发送数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        try {
            // readLine为阻塞方法，循环结果永远为true
            while (((read = br.readLine()) != null)) {
                byte[] bytes = read.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, address, port);
                sendSocket.send(sendPacket);
                // 自定义用户协议
                if ("exit".equals(read)) {
                    synchronized (AnotherProgram.lock){
                        AnotherProgram.isSender = true;
                    }
                    System.out.println("发送端已退出");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
