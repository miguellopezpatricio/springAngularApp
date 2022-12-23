package com.mlpatri.springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlpatri.springboot.backend.apirest.models.entity.Cliente;
import com.mlpatri.springboot.backend.apirest.models.services.IClienteService;


@CrossOrigin(origins= {"http://localhost:4200"}) // permitimos a la app front en angular el acceso al backend
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	private List <Cliente> clientes = new ArrayList<>();
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		
	clientes =  clienteService.findAll();
	
	return clientes;
	}

	
}
