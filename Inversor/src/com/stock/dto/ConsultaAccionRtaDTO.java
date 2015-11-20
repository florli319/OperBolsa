package com.stock.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name= "consultaRta" )
public class ConsultaAccionRtaDTO {
	private String accion;
	private int precioCompra;
	private int precioVenta;
	public String getAccion() {
		return accion;
	}
	@XmlElement
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public int getPrecioCompra() {
		return precioCompra;
	}
	@XmlElement (name= "preciocompra")
	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	@XmlElement (name= "precioventa")
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override
	public String toString() {
		return "Resultado consulta [accion=" + accion + ", precioCompra="
				+ precioCompra + ", precioVenta=" + precioVenta + "]";
	}
	

}
