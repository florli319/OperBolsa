package com.stock.inversor;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement(name = "inversor")
public class Inversor {
	private String nombre;
	private int puertoCorredor;
	private String hostCorredor;
	private int efectivo;
	private String hostInversor;
	private String colaRtaInversor;

	ArrayList<Accion> accionesList;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuertoCorredor() {
		return puertoCorredor;
	}

	public void setPuertoCorredor(int puertoCorredor) {
		this.puertoCorredor = puertoCorredor;
	}

	public String getHostCorredor() {
		return hostCorredor;
	}

	public void setHostCorredor(String hostCorredor) {
		this.hostCorredor = hostCorredor;
	}

	public int getEfectivo() {
		return efectivo;
	}

	@XmlElement(name = "efectivo")
	public void setEfectivo(int efectivo) {
		this.efectivo = efectivo;
	}

	public String getHostInversor() {
		return hostInversor;
	}

	public void setHostInversor(String hostInversor) {
		this.hostInversor = hostInversor;
	}

	public String getColaRtaInversor() {
		return colaRtaInversor;
	}
	
	public void setColaRtaInversor(String colaRtaInversor) {
		this.colaRtaInversor = colaRtaInversor;
	}
	
	
	
	public ArrayList<Accion> getAccionesList() {
		return accionesList;
	}

	@XmlElementWrapper(name = "acciones")
	@XmlElement(name = "accion")
	public void setAccionesList(ArrayList<Accion> accionesList) {
		this.accionesList = accionesList;
	}

	public void consultarPortafolio() {
		System.out.println("Efectivo = " + this.efectivo);
		System.out.println("Detalle de las acciones:");
		for (int i = 0; i < this.accionesList.size(); i++) {
			Accion accion = this.accionesList.get(i);
			System.out.println(accion.getEmpresa() + "\t"
					+ accion.getCantidad());
		}
	}

	public void actualizarPortafolio(String operacion, String accion,
			int cantidad, int precio) {
		if ("compra".equalsIgnoreCase(operacion)) {
			this.efectivo = this.efectivo - (cantidad * precio);
		}
		if ("venta".equalsIgnoreCase(operacion)) {
			this.efectivo = this.efectivo + (cantidad * precio);
		}

	}

	@Override
	public String toString() {
		return "Inversor [nombre=" + nombre + ", puertoCorredor="
				+ puertoCorredor + ", hostCorredor=" + hostCorredor + "]";
	}

}
