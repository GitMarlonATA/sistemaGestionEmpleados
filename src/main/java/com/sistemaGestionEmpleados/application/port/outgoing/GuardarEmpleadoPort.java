package com.sistemaGestionEmpleados.application.port.outgoing;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface GuardarEmpleadoPort {
	void guardarEmpleado(Empleado empleado);
	int findByEmail(String email);
}
