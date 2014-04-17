package jms.producer;


import javax.jms.JMSException;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {
	
	JmsTemplate template;
	public  void produceMessage(String messagecontent){
		System.out.println(messagecontent);
		template.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				TextMessage tm = session.createTextMessage();
				tm.setText("MY TEST MESSAGE");
				return (Message) tm;
			}
		});
	}
	
	public Producer(JmsTemplate template){
		this.template=template;
		
	}
}
