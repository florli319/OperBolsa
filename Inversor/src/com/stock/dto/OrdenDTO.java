package com.stock.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "orden")
public class OrdenDTO {
	private String inversor;
	private String hostCorredor;
	private int puertoCorredor;
	private String operacion;
	private String accion;
	private int cantidad;
	private int precio;
	private String hostInversor;
	private String colaRtaInversor;

	public String getOperacion() {
		return operacion;
	}

	@XmlElement
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getAccion() {
		return accion;
	}

	@XmlElement(name = "empresa")
	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getCantidad() {
		return cantidad;
	}

	@XmlElement
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	@XmlElement
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getInversor() {
		return inversor;
	}

	@XmlAttribute
	public void setInversor(String inversor) {
		this.inversor = inversor;
	}

	public String getHostCorredor() {
		return hostCorredor;
	}

	@XmlAttribute
	public void setHostCorredor(String hostCorredor) {
		this.hostCorredor = hostCorredor;
	}

	public int getPuertoCorredor() {
		return puertoCorredor;
	}

	@XmlAttribute
	public void setPuertoCorredor(int puertoCorredor) {
		this.puertoCorredor = puertoCorredor;
	}

	public String getHostInversor() {
		return hostInversor;
	}

	@XmlAttribute
	public void setHostInversor(String hostInversor) {
		this.hostInversor = hostInversor;
	}

	public String getColaRtaInversor() {
		return colaRtaInversor;
	}

	@XmlAttribute
	public void setColaRtaInversor(String colaRtaInversor) {
		this.colaRtaInversor = colaRtaInversor;
	}

}
