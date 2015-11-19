package com.stock.dto;
import javax.xml.bind.annotation.*;

@XmlRootElement (name= "orden" )
public class OrdenDTO {
	private String inversor;
	private String hostCorredor;
	private int puertoCorredor;
	private String operacion;
	private String accion;
	private int cantidad;
	private int precio;
	
	
	public OrdenDTO() {
		super();
	}

	public OrdenDTO(String inversor, String hostCorredor, int puertoCorredor,
			String operacion, String accion, int cantidad, int precio) {
		super();
		this.inversor = inversor;
		this.hostCorredor = hostCorredor;
		this.puertoCorredor = puertoCorredor;
		this.operacion = operacion;
		this.accion = accion;
		this.cantidad = cantidad;
		this.precio = precio;
	}


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

	@XmlElement(name= "empresa" )
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
	
}
