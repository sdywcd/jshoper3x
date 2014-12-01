package com.jshop.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class testJsm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("初始化spring！准备开始接收！");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// SimpleJMSSender t=(SimpleJMSSender)
		// context.getBean("topicMessageSender");
		// t.sendMessage();
		//
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		for (int i = 0; i < 10; i++) {
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session)
						throws JMSException {
					TextMessage msg = session.createTextMessage();
					// 设置消息属性
					msg.setStringProperty("phrCode", "C001");
					// 设置消息内容
					msg.setText("Hello World!");
					return msg;
				}
			});
		}
	}

}
