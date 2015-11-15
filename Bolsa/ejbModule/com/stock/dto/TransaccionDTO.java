package com.stock.dto;

public class TransaccionDTO {

	private String accion;
	private OrdenDTO ordenVenta;
	private OrdenDTO ordenCompra;
	private int remanente;
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public OrdenDTO getOrdenVenta() {
		return ordenVenta;
	}
	public void setOrdenVenta(OrdenDTO ordenCVenta) {
		this.ordenVenta = ordenCVenta;
	}
	public OrdenDTO getOrdenCompra() {
		return ordenCompra;
	}
	public void setOrdenCompra(OrdenDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	public int getRemanente() {
		return remanente;
	}
	public void setRemanente(int remanente) {
		this.remanente = remanente;
	}
	
}
