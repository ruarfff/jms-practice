package jms.producer;

import jms.model.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("producer")
public class Producer {
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void convertAndSendMessage(Notification notification) {
		jmsTemplate.convertAndSend(notification);
	}

	public void convertAndSendMessage(String destination, Notification notification) {
		jmsTemplate.convertAndSend(destination, notification);
	}


}
