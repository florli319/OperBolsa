package com.stock.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name= "ordenRta" )
public class OrdenRtaDTO {
	private String operacion;
	private String resultado;
	private String accion;
	private int cantidad;
	private int precio;
	public String getOperacion() {
		return operacion;
	}
	@XmlElement(name= "operacion" )
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getResultado() {
		return resultado;
	}
	@XmlElement(name= "resultado" )
	public void setResultado(String resultado) {
		this.resultado = resultado;
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
	@XmlElement(name= "cantidad" )
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	@XmlElement(name= "precio" )
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "OrdenRtaDTO [operacion=" + operacion + ", resultado="
				+ resultado + ", accion=" + accion + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}

}
