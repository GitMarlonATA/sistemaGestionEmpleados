package com.sistemaGestionEmpleados.application.port.incoming;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ObtenerEmpleadoUseCase {
	Empleado obtenerEmpleado(String tipoidentificacion, String numeroidentificacion);

}
