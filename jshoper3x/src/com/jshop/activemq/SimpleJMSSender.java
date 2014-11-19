package com.jshop.activemq;

import org.springframework.jms.core.JmsTemplate;

public class SimpleJMSSender {

	public JmsTemplate jmsTemplate;

	/**
	 * send message
	 */
	public void sendMessage() {
		jmsTemplate.convertAndSend("hello jms!");
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

}
