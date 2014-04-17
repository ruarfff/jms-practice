package jms;

import java.util.Scanner;

import jms.model.Notification;
import jms.producer.Producer;
import jms.receiver.SyncReceiver;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {
	
	@Autowired
	private Producer producer;

	@Autowired
	private SyncReceiver syncReceiver;

	public static void main(String[] args) {
		Main main = new Main();
        new ApplicationContextLoader().load(main, "/jms/config/app-config.xml", "/jms/config/jms-config.xml");
	           
		Notification notification = new Notification("1", "this is a message");
		System.out.println("Sendign message \n" + notification.toString()); 
		main.producer.convertAndSendMessage(notification);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
			System.exit(1);
		}

		Notification receivedNotification = main.syncReceiver.receive();
		System.out.println("Receiving Message\n");
		System.out.println(receivedNotification.toString());

		String whatever;

		System.out.println("Press enter to exit....\n");
		Scanner scanIn = new Scanner(System.in);
		whatever = scanIn.nextLine();

		scanIn.close();
		System.exit(0);

	}
}
