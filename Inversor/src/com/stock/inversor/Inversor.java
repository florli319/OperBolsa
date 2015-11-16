package com.stock.inversor;
import java.util.ArrayList;

public class Inversor {
	private String nombre;
	private String puertoCorredor;
	private String hostCorredor;
	private String nombreArchivo;
	ArrayList<Accion> accionesList;
	
	public Inversor(String nombre, String puertoCorredor, String hostCorredor,
			String nombreArchivo) {
		super();
		this.nombre = nombre;
		this.puertoCorredor = puertoCorredor;
		this.hostCorredor = hostCorredor;
		this.nombreArchivo = nombreArchivo;
	}
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuertoCorredor() {
		return puertoCorredor;
	}

	public void setPuertoCorredor(String puertoCorredor) {
		this.puertoCorredor = puertoCorredor;
	}

	public String getHostCorredor() {
		return hostCorredor;
	}

	public void setHostCorredor(String hostCorredor) {
		this.hostCorredor = hostCorredor;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	

	public ArrayList<Accion> getAccionesList() {
		return accionesList;
	}

	public void setAccionesList(ArrayList<Accion> accionesList) {
		this.accionesList = accionesList;
	}

	@Override
	public String toString() {
		return "Inversor [nombre=" + nombre + ", puertoCorredor="
				+ puertoCorredor + ", hostCorredor=" + hostCorredor
				+ ", nombreArchivo=" + nombreArchivo + "]";
	}

	

}
