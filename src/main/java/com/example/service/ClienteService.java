package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Cliente;

@Service
public interface ClienteService {
	
	public List<Cliente> listarCliente();
	
	public Cliente listarClientePorId(Long id);
	
	public Cliente acionarCliente(Cliente cliente);
	
	public boolean deleteCliente(Long id);
	
	public Cliente atualizar(Cliente cliente);
	
	
}
