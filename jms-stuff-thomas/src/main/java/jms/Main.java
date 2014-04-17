package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import jms.producer.*;
import jms.receiver.*;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Message;
@Configuration
public class Main {
	private static int sendMessage=1,receiveMessage=2;
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	ApplicationContext context=new ClassPathXmlApplicationContext("");
    	
    	try{
	    	if(Integer.parseInt(args[0])==sendMessage){
	    		JmsTemplate producer =(JmsTemplate) context.getBean("jmsTemplate");
	    		
	    		String Message="";
	    		String sendNewMessage ="y";
	    		boolean cont=true;
	    		while(cont){
	    			System.out.println("Please enter a message");
	    			Message=scan.nextLine();
	    			producer.send(new MessageCreator(){
	    				public Message createMessage(Session session) throws JMSException{
	    					TextMessage tm = session.createTextMessage();
	    					tm.setText("this is a message");
	    					return tm;
	    				}
	    			});
	    			
	    			System.out.println("message sent");
	    			System.out.println("send a new message? (y/n)");
	    		
	    			cont = scan.hasNext()? (scan.next().equals(sendNewMessage)? true:false ): false;
	    			//clearScanner(scan);
	    		}
	    	}else if(Integer.parseInt(args[0])==receiveMessage){
	    		
	    	}
	    	else{
	    		usage();
	    	}
    	}catch(NumberFormatException e){
    		usage();
    	}
    }
    
    private static void clearScanner(Scanner scan){
    	while(scan.hasNext()){scan.next();}
    }
    private static void usage(){
    	System.out.println("Enter 1 for message Sender \n Enter 2 for message receiver");
    }

}
