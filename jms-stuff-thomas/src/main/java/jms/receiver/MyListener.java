package jms.receiver;

import jms.model.Notification;

import org.apache.activemq.Message;

public class MyListener {
	
	public void handleMessage(Notification message){
		System.out.println("Message received in delgate listener");
		System.out.println("Message id: "+message.getId()+" Message value: "+message.getMessage());
	}
}
