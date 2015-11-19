package com.stock.inversor;
import java.util.*;
import java.util.concurrent.TimeoutException;
import java.io.IOException;

import com.stock.dto.*;
import com.stock.util.*;
import com.stock.broker.*;

public class InversorApp {
	private Inversor inversor;
	final Map<String, List<String>> params = new HashMap<>();
	private final static String archivolog =  "C:\\OperBolsa\\logs\\invesorlogsalida.xml";

	public static void main(String[] args) {
		if (args.length != 8) {
			System.out.println("Número de argumentos no válido");
			System.exit(0);
		}
		InversorApp inversorApp = new InversorApp();
		try {
			inversorApp.leerLineaComandos(args);
			inversorApp.iniciarInversor();
			
			MessageReceiver mr = new MessageReceiver("pruebarespuesta");
			Thread consumerThread = new Thread(mr);
			consumerThread.start();
			
			String comando = null;
			inversorApp.imprimirMenu();
			do {
				comando = inversorApp.leerComando();
				inversorApp.ejecutarComando(comando);

			} while (!"Q".equalsIgnoreCase(comando));

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void leerLineaComandos(String[] args) {
		List<String> options = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].charAt(0) == '-') {
				options = new ArrayList<>();
				params.put(args[i].substring(1), options);
			} else if (options != null) {
				options.add(args[i]);
			} else {
				return;
			}
		}
	}

	private void iniciarInversor() {
		inversor = XmlUtil.unmarshallXmlToObject(Inversor.class, params
				.get("a").get(0));
		inversor.setNombre(params.get("n").get(0));
		inversor.setHostCorredor(params.get("h").get(0));
		inversor.setPuertoCorredor(Integer.parseInt(params.get("p").get(0)));
	}

	public void imprimirMenu() {
		System.out.println("Para salir, presione \'Q\'");
	}

	public String leerComando() {
		String input = System.console().readLine();
		return input;
	}

	public void ejecutarComando(String comando) {
		try {
			String[] infoComando = comando.split(" ");
			if ("compra".equalsIgnoreCase(infoComando[0])
					|| "venta".equalsIgnoreCase(infoComando[0])
					|| "nocompra".equalsIgnoreCase(infoComando[0])
					|| "noventa".equalsIgnoreCase(infoComando[0])) {
				if (infoComando.length != 4) {
					System.out.println("Comando no válido");
				}
				OrdenDTO orden = new OrdenDTO();
				String operacion = infoComando[0];
				String accion = infoComando[1];
				int cantidad = Integer.parseInt(infoComando[2]);
				int precio = Integer.parseInt(infoComando[3]);
				orden.setOperacion(operacion);
				orden.setAccion(accion);
				orden.setCantidad(cantidad);
				orden.setPrecio(precio);
				orden.setInversor(inversor.getNombre());
				orden.setHostCorredor(inversor.getHostCorredor());
				orden.setPuertoCorredor(inversor.getPuertoCorredor());
				XmlUtil.marshallObtjectToXml(orden,archivolog);
				MessageSender ms = new MessageSender();
				ms.sendMessage(inversor.getHostCorredor(), inversor.getPuertoCorredor(), inversor.getNombre(),archivolog);
			} else if ("consulta".equalsIgnoreCase(infoComando[0])) {
				if (infoComando.length != 2) {
					System.out.println("Comando no válido");
				}
				ConsultaAccionDTO consulta = new ConsultaAccionDTO();
				String operacion = infoComando[0];
				String accion = infoComando[1];
				consulta.setOperacion(operacion);
				consulta.setAccion(accion);
				consulta.setInversor(inversor.getNombre());
				consulta.setHostCorredor(inversor.getHostCorredor());
				consulta.setPuertoCorredor(inversor.getPuertoCorredor());
				XmlUtil.marshallObtjectToXml(consulta,archivolog);
			} else if ("portafolio".equalsIgnoreCase(infoComando[0])) {
				if (infoComando.length != 1) {
					System.out.println("Comando no válido");
				}
				inversor.consultarPortafolio();
			} else if ("q".equalsIgnoreCase(infoComando[0])) {
				System.exit(0);
			} else {
				System.out.println("Comando no válido");
			}
		} catch (IOException | TimeoutException ie) {
			ie.printStackTrace();
		}
	}

}
