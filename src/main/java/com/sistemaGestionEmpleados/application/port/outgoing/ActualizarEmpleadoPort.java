package com.sistemaGestionEmpleados.application.port.outgoing;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ActualizarEmpleadoPort {
	boolean actualizarEmpleado(Empleado empleado);

}
