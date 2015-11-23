package com.stock.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "consulta")
public class ConsultaAccionDTO {
	private String inversor;
	private String hostCorredor;
	private int puertoCorredor;
	private String accion;
	private String operacion;
	private String hostInversor;
	private String colaRtaInversor;
	private String programa;

	public ConsultaAccionDTO() {
		super();
	}

	public ConsultaAccionDTO(String inversor, String hostCorredor,
			int puertoCorredor, String accion, String operacion) {
		super();
		this.inversor = inversor;
		this.hostCorredor = hostCorredor;
		this.puertoCorredor = puertoCorredor;
		this.accion = accion;
		this.operacion = operacion;
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

	@XmlElement(name = "empresa")
	public void setAccion(String accion) {
		this.accion = accion;
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

	@XmlAttribute(name = "hostcorredor")
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

	public String getPrograma() {
		return programa;
	}
	@XmlAttribute
	public void setPrograma(String programa) {
		this.programa = programa;
	}

	
}
