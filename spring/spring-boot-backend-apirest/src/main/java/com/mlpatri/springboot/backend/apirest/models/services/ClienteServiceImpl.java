package com.mlpatri.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mlpatri.springboot.backend.apirest.models.dao.IClienteDao;
import com.mlpatri.springboot.backend.apirest.models.entity.Cliente;

public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		

		return (List<Cliente>) clienteDao.findAll();
	}

}
