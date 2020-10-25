package com.demo.work;

import com.demo.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列
 * 轮询方式
 */
public class Send2 {


    private static final String QUEUE_NAME = "test_work_queue";


    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {

        //创建链接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列,并开启消息持久化
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //限制每次发送的数量
        channel.basicQos(1);
        //发送消息
        for (int i = 1; i <=10 ; i++) {
            String message = "hello rabbmitMQ "+i;
            System.out.println("Send msg:"+message);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }

        channel.close();
        connection.close();


    }


}
