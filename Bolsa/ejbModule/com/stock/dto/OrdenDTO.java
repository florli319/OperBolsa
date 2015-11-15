package com.stock.dto;

public class OrdenDTO {

	private int identificador;
	private String empresa;
	private int cantidad;
	private Double valor;
	private String operacion;
	private int idCorredor;
	private int idInversor;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public int getIdCorredor() {
		return idCorredor;
	}
	public void setIdCorredor(int idCorredor) {
		this.idCorredor = idCorredor;
	}
	public int getIdInversor() {
		return idInversor;
	}
	public void setIdInversor(int idInversor) {
		this.idInversor = idInversor;
	}
	
}
