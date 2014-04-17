package jms.receiver;
import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
public class AsyncReceiver implements MessageListener {

	public AsyncReceiver(){
		
	}
	@Override
	public void onMessage(Message message){
		if(message instanceof TextMessage){
			TextMessage tm = (TextMessage) message;
			try{
				System.out.println("this is the response "+tm.getText());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
