package com.sistemaGestionEmpleados.application.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(EmpleadoPK.class)
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String tipoidentificacion;
	@Id
	private String numeroidentificacion;
	@Column
	private String primernombre;
	@Column
	private String primerapellido;
	@Column
	private String segundoapellido;
	@Column
	private String otrosnombres;
	@Column
	private String email;
	@Column
	private String paisempleo;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaingreso;
	@Column
	private String area;
	@Column
	private String estado;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechahoraregistro;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechahoraedicion;
	
	public Empleado() {
		super();
	}

	public Empleado(String tipoidentificacion, String numeroidentificacion, String primernombre, String primerapellido,
			String segundoapellido, String otrosnombres, String email, String paisempleo, Date fechaingreso,
			String area, String estado, Date fechahoraregistro,Date fechahoraedicion) {
		super();
		this.tipoidentificacion = tipoidentificacion;
		this.numeroidentificacion = numeroidentificacion;
		this.primernombre = primernombre;
		this.primerapellido = primerapellido;
		this.segundoapellido = segundoapellido;
		this.otrosnombres = otrosnombres;
		this.email = email;
		this.paisempleo = paisempleo;
		this.fechaingreso = fechaingreso;
		this.area = area;
		this.estado = estado;
		this.fechahoraregistro = fechahoraregistro;
		this.fechahoraedicion = fechahoraedicion;
	}

	public String getTipoidentificacion() {
		return tipoidentificacion;
	}

	public void setTipoidentificacion(String tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}

	public String getNumeroidentificacion() {
		return numeroidentificacion;
	}

	public void setNumeroidentificacion(String numeroidentificacion) {
		this.numeroidentificacion = numeroidentificacion;
	}

	public String getPrimernombre() {
		return primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public String getPrimerapellido() {
		return primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getOtrosnombres() {
		return otrosnombres;
	}

	public void setOtrosnombres(String otrosnombres) {
		this.otrosnombres = otrosnombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaisempleo() {
		return paisempleo;
	}

	public void setPaisempleo(String paisempleo) {
		this.paisempleo = paisempleo;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechahoraregistro() {
		return fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getFechahoraedicion() {
		return fechahoraedicion;
	}

	public void setFechahoraedicion(Date fechahoraedicion) {
		this.fechahoraedicion = fechahoraedicion;
	}
	
	
}
