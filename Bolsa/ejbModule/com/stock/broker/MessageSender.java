package com.stock.broker;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class MessageSender {

	 private final static String QUEUE_NAME = "broker";

	  public static void main(String[] argv)
	      throws java.io.IOException {
		  
		  ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    String message = "Hello World!";
		    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		    System.out.println(" [x] Sent '" + message + "'");
		    
		    channel.close();
		    connection.close();
	  }
	  
}
