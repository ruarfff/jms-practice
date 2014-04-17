package jms;

import org.apache.activemq.broker.Connection;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import jms.model.Notification;
import jms.producer.*;
import jms.receiver.*;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Message;


@Configuration
public class Main {
	private static int sendMessage=1,receiveMessage=2;
	private final static String XMLCONTEXT="jms/config/app-config.xml"; 
	private Producer producer;
	private AsyncReceiver receiver;
	public static void main(String[] args) {
		Main main = new Main();
		
    	//main.producer.produceMessage("my test message");
		main.producer.produceMessage(new Notification(((Double)Math.rint(30)).toString(),"my test message"));
		main.producer.produceMessage(new Notification(((Double)Math.rint(30)).toString(),"my test message 2"));
		
    }
    
    private static void usage(){
    	System.out.println("Enter 1 for message Sender \n Enter 2 for message receiver");
    }
    
    public Main(){
    	ApplicationContext context=new ClassPathXmlApplicationContext(XMLCONTEXT);
    	this.producer = (Producer)context.getBean("myProducer");
    	producer.produceMessage(new Notification(((Double)Math.rint(30)).toString(),"my test message 2"));
    	this.receiver=(AsyncReceiver)context.getBean("AsyncReceiver");
    }
}
