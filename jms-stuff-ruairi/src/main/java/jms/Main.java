package jms;

import java.util.Scanner;

import jms.model.Notification;
import jms.producer.Producer;
import jms.receiver.NotificationRegistry;
import jms.receiver.SyncReceiver;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {
	
	@Autowired
	private Producer producer;

	@Autowired
	private SyncReceiver syncReceiver;
	
	@Autowired
	private NotificationRegistry registry;


	public static void main(String[] args) {
		Main main = new Main();
        new ApplicationContextLoader().load(main, "/jms/config/app-config.xml", "/jms/config/jms-config.xml");
	           
		Notification syncNotification = new Notification("1", "this is a synchronus message");
		Notification asyncNotification = new Notification("2", "this is an asynchronus message");
		System.out.println("Sendign sync message \n" + syncNotification.toString()); 
		main.producer.convertAndSendMessage(syncNotification);
		System.out.println("Sendign async message \n" + asyncNotification.toString());
		main.producer.convertAndSendMessage("FSMA", asyncNotification);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
			System.exit(1);
		}

		Notification receivedNotification = main.syncReceiver.receive();
		System.out.println("Receiving Sync Message\n");
		System.out.println(receivedNotification.toString());
		System.out.println("\nReceiving Async Message\n");
		System.out.println(main.registry.getReceivedNotifications().get(0).toString());
		

		String whatever;

		System.out.println("Press enter to exit....\n");
		Scanner scanIn = new Scanner(System.in);
		whatever = scanIn.nextLine();

		scanIn.close();
		System.exit(0);

	}
}
