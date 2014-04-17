package jms.receiver;
import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.MessageConsumer;
public class AsyncReceiver implements MessageListener, MessageConsumer {

	public AsyncReceiver(){
		
	}
	@Override
	public void onMessage(Message message){
		
	}
	
	
	
	@Override
	public MessageListener getMessageListener(){
		return null;
	}
	
	 /* start of Unimplemented block */
	@Override
	public void close(){
		
	}
	@Override
	public String getMessageSelector(){
		return null;
	}
	
	@Override
	public Message receive(){
		return null;
	}
	
	@Override
	public Message receive(long timeout){
		
		return null;
	}
	
	public Message receiveNoWait(){
		return null;
	}
	/*end of unimplemented block*/
	@Override
	public void setMessageListener(MessageListener listener){
		
	}
}
