package jms.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jms.model.Notification;

@Component
public class SyncReceiver {
	@Autowired
	private JmsTemplate jmsTemplate;

	public Notification receive() {
		return (Notification) jmsTemplate.receiveAndConvert("FSMA");
	}
}
