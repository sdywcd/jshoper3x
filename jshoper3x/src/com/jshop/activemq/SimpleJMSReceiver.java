package com.jshop.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;

public class SimpleJMSReceiver  {

    public void receive(TextMessage message) throws JmsException, JMSException {  
        System.out.println(message.getStringProperty("phrCode"));  
        System.out.println(message.getText());  
    }  

}
