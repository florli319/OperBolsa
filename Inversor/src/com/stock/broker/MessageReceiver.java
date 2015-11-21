package com.stock.broker;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.stock.util.XmlUtil;
import com.stock.dto.*;
import com.stock.inversor.InversorApp;

public class MessageReceiver extends MessageQueueEndPoint implements Runnable,
		Consumer {

	private final static String archivologRta = "C:\\OperBolsa\\logs\\invesorlogrespuestas.xml";

	public MessageReceiver(String endPointName) throws IOException,
			TimeoutException {
		super(endPointName);
	}

	public void run() {
		try {
			// start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Called when consumer is registered.
	 */
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer " + consumerTag + " registered");
	}

	/**
	 * Called when new message is available.
	 */
	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		String message = new String(body, "UTF-8");
		System.out.println(" Mensaje recibido '" + message + "'");
		int resultado = message.indexOf("consulta");
		if (resultado != -1) {
			XmlUtil.stringToFile(message, archivologRta);
			ConsultaAccionRtaDTO consulta = XmlUtil.unmarshallXmlToObject(
					ConsultaAccionRtaDTO.class, archivologRta);
			System.out.println(consulta.toString());
		}
		resultado = message.indexOf("orden");
		if (resultado != -1) {
			XmlUtil.stringToFile(message, archivologRta);
			OrdenRtaDTO orden = XmlUtil.unmarshallXmlToObject(
					OrdenRtaDTO.class, archivologRta);
			System.out.println(orden.toString());
			InversorApp.inversor.actualizarPortafolio(orden.getOperacion(),
					orden.getAccion(), orden.getCantidad(), orden.getPrecio());
		}

	}

	public void handleCancel(String consumerTag) {
	}

	public void handleCancelOk(String consumerTag) {
	}

	public void handleRecoverOk(String consumerTag) {
	}

	public void handleShutdownSignal(String consumerTag,
			ShutdownSignalException arg1) {
	}

}