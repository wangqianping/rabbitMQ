package com.demo.util;

import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Test {


    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(123);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
