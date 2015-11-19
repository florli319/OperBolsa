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
	ArrayList<Accion> accionesList;

	public Inversor() {
		super();
	}

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

	@Override
	public String toString() {
		return "Inversor [nombre=" + nombre + ", puertoCorredor="
				+ puertoCorredor + ", hostCorredor=" + hostCorredor + "]";
	}

}
