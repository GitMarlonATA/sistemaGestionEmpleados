package com.sistemaGestionEmpleados.adapters.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaGestionEmpleados.application.domain.Empleado;
import com.sistemaGestionEmpleados.application.port.incoming.ActualizarEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.AgregarEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.ListarUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.ObtenerEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.outgoing.ObtenerEmpleadosPort;
@CrossOrigin
@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {
	
	private final ListarUseCase listarUseCase;
	private final AgregarEmpleadoUseCase agregarEmpleadoUseCase;
	private final ObtenerEmpleadoUseCase obtenerEmpleadoUseCase;
	private final ActualizarEmpleadoUseCase actualizarEmpleadoUseCase;
	
	public EmpleadoController(ListarUseCase listarUseCase, AgregarEmpleadoUseCase agregarEmpleadoUseCase,
			ObtenerEmpleadoUseCase obtenerEmpleadoUseCase,ActualizarEmpleadoUseCase actualizarEmpleadoUseCase) {
		super();
		this.listarUseCase = listarUseCase;
		this.agregarEmpleadoUseCase = agregarEmpleadoUseCase;
		this.obtenerEmpleadoUseCase = obtenerEmpleadoUseCase;
		this.actualizarEmpleadoUseCase = actualizarEmpleadoUseCase;
	}
	
	@PutMapping
	ResponseEntity<String> agregarEmpleado(@RequestBody Empleado empleado)
	{
		Empleado empleadoE = obtenerEmpleadoUseCase.obtenerEmpleado(empleado.getTipoidentificacion(), empleado.getNumeroidentificacion());
		if(empleadoE==null)
		{
			boolean res = agregarEmpleadoUseCase.agregarEmpleado(empleado);
			if(res)
				return new ResponseEntity<>("El empleado se ha agregado correctamente",HttpStatus.OK);
			else
				return new ResponseEntity<>("El empleado no se ha agregado correctamente",HttpStatus.OK);
		}
		return new ResponseEntity<>("{ \"respuesta\": \"El empleado con el tipo de identificación [" + empleado.getTipoidentificacion() +
		"] y el número de identificación [" + empleado.getNumeroidentificacion() + "] ya existe en el sistema\" }",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping
	ResponseEntity<String> actualizarEmpleado(@RequestBody Empleado empleado,@RequestParam(name="tipoidentificacion") String tipoidentificacion,@RequestParam(name = "numeroidentificacion") String numeroidentificacion)
	{
		Empleado empleadoE = obtenerEmpleadoUseCase.obtenerEmpleado(tipoidentificacion, numeroidentificacion);
		if(empleadoE!=null)
		{
			boolean res = agregarEmpleadoUseCase.agregarEmpleado(empleado);
			if(res)
				return new ResponseEntity<>("El empleado se ha actualizado correctamente",HttpStatus.OK);
			else
				return new ResponseEntity<>("El empleado no se ha actualizado correctamente",HttpStatus.OK);
		}
		return new ResponseEntity<>("{ \"respuesta\": \"El empleado con el tipo de identificación [" + empleado.getTipoidentificacion() +
		"] y el número de identificación [" + empleado.getNumeroidentificacion() + "] no existe en el sistema\" }",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	List<Empleado> obtenerEmpleados(){
		return listarUseCase.listar();
	}

}
