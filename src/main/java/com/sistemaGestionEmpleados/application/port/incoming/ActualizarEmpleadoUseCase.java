package com.sistemaGestionEmpleados.application.port.incoming;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ActualizarEmpleadoUseCase {
	boolean actualizarEmpleado(Empleado empleado);
}
