package com.sistemaGestionEmpleados.application.port.incoming;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface AgregarEmpleadoUseCase {
	boolean agregarEmpleado(Empleado empleado);
}
