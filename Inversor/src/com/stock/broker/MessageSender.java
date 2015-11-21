package com.stock.broker;

import java.io.File;
import java.io.FileInputStream;

import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class MessageSender {

	public void sendMessage(String host, int puerto, String queue_name,
			String pathFile) throws java.io.IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(puerto);
		//factory.setUsername("admin");
		//factory.setPassword("admin");
		//factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(queue_name, false, false, false, null);
		File file = new File(pathFile);
		channel.basicPublish("", queue_name, null, getBytes(file));
		channel.close();
		connection.close();
	}

	private byte[] getBytes(File file) {
		byte[] bFile = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			for (int i = 0; i < bFile.length; i++) {
				//System.out.print((char) bFile[i]);
			}
			//System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}
}