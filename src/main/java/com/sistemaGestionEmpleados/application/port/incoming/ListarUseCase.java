package com.sistemaGestionEmpleados.application.port.incoming;

import java.util.List;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ListarUseCase {
	List<Empleado> listar();
}
