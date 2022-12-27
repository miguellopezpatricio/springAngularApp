package com.mlpatri.springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mlpatri.springboot.backend.apirest.models.entity.Cliente;
import com.mlpatri.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" }) // permitimos a la app front en angular el acceso al backend
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	private List<Cliente> clientes = new ArrayList<>();

	@GetMapping("/clientes")
	public List<Cliente> index() {

		clientes = clienteService.findAll();

		return clientes;
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
		cliente = clienteService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "ERROR AL REALIZAR EL ACCESO A LA BBDD.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		if (cliente == null) {
			response.put("mensaje", "ERROR: No existe un cliente con ese id.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

		}


	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		
		Cliente newCliente = null;
		Map<String, Object> response = new HashMap<>();
		
		// el objeto result es para validar posibles errores
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo"+ err.getField() + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}



		try {
			newCliente = clienteService.save(cliente);
		}catch(DataAccessException e) {
			response.put("mensaje", "ERROR AL REALIZAR EL INSERTADO EN LA BBDD.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El registro de cliente ha sido creado con éxito.");
		response.put("cliente",newCliente);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {

		Cliente clienteActual = clienteService.findById(id);
		Cliente updatedClient = null;
		Map<String, Object> response = new HashMap<>();
		
	if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo"+ err.getField() + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
	
	
		if (clienteActual == null) {
			response.put("mensaje", "ERROR: No existe un cliente con ese id.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setCreateAt(cliente.getCreateAt());
		

		 updatedClient = clienteService.save(clienteActual);
		 
		}catch(DataAccessException e){
			response.put("mensaje", "ERROR AL ACTUALIZAR EN LA BBDD.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		response.put("mensaje", "El registro de cliente ha sido actualizado con éxito.");
		response.put("cliente",updatedClient);

		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);


	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();

		try {
		clienteService.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "ERROR AL ELIMINAR EL REGISTRO EN LA BBDD.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El registro de cliente ha sido eliminado con éxito.");
	
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

	}

}
