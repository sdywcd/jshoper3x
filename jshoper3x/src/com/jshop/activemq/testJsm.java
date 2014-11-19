package com.jshop.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testJsm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("初始化spring！准备开始接收！");  
	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
	    SimpleJMSSender t=(SimpleJMSSender) context.getBean("topicMessageSender");  
	    t.sendMessage();  
	    
	}

}
