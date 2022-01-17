package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;

@Service
public class ClienteSeviceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente acionarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public boolean deleteCliente(Long id) {
		try {
			clienteRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cliente atualizar(Cliente cliente) {

		return clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public Cliente listarClientePorId(Long id) {
		return clienteRepository.getById(id);
	}

}
