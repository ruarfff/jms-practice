package jms.receiver;
import javax.jms.MessageListener;

import jms.model.Notification;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;
public class AsyncReceiver extends MessageListenerAdapter /*implements MessageListener */{
	Object delegate;
	public AsyncReceiver(Object delegate){
		this.delegate=delegate;
		setDelegate(delegate);
		setDefaultListenerMethod("handleMessage");
	}
	/*@Override
	public void onMessage(Message message){
	
		Notification nf = (Notification) message;
		System.out.println("Print Me");
		System.out.println("in onMessage");
		if(nf instanceof TextMessage){
			TextMessage tm = (TextMessage) message;
			try{
				System.out.println("this is the response "+tm.getText());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(nf instanceof Notification){
			 nf = (Notification) message;
			System.out.println("message id: "+nf.getId()+" message: "+nf.getMessage());
		}else{
			System.out.println("message received");
		}
	}*/
	public void receiveMessage(Notification notification) {
		System.out.println("my string "+notification.getMessage());
	}
}
