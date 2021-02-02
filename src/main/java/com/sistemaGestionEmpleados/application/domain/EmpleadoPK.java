package com.sistemaGestionEmpleados.application.domain;

import java.io.Serializable;

public class EmpleadoPK implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String tipoidentificacion;
	private String numeroidentificacion;
	
	
	public EmpleadoPK() {
		super();
	}

	public EmpleadoPK(String tipoidentificacion, String numeroidentificacion) {
		super();
		this.tipoidentificacion = tipoidentificacion;
		this.numeroidentificacion = numeroidentificacion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroidentificacion == null) ? 0 : numeroidentificacion.hashCode());
		result = prime * result + ((tipoidentificacion == null) ? 0 : tipoidentificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoPK other = (EmpleadoPK) obj;
		if (numeroidentificacion == null) {
			if (other.numeroidentificacion != null)
				return false;
		} else if (!numeroidentificacion.equals(other.numeroidentificacion))
			return false;
		if (tipoidentificacion == null) {
			if (other.tipoidentificacion != null)
				return false;
		} else if (!tipoidentificacion.equals(other.tipoidentificacion))
			return false;
		return true;
	}

}
