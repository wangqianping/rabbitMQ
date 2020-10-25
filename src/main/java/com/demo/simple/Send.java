package com.demo.simple;

import com.demo.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式，发送
 */
public class Send {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "Hello,Simple!";
        //发送消息
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());


        System.out.println("msg send:" + msg);

        channel.close();
        connection.close();

    }


}
