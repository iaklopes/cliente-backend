package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cliente;
import com.example.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
		
	/*Listar clientes*/
	@CrossOrigin(origins = "http://localhost:8081/", allowedHeaders = "*")
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteService.listarCliente();
	}
	
	/*Listar clientes especifico*/
	@CrossOrigin(origins = "http://localhost:8081/", allowedHeaders = "*")
	@GetMapping("/cliente/{id}")
	public Cliente listarClientePoId(@PathVariable Long id) {
		return clienteService.listarClientePorId(id);
	}
	
	/*Criar cliente*/
	@CrossOrigin(origins = "http://localhost:8081/", allowedHeaders = "*")
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteService.acionarCliente(cliente);		
	}
	
	/*Remover cliente*/
	@CrossOrigin(origins = "http://localhost:8081/", allowedHeaders = "*")
	@DeleteMapping("/cliente/{id}")
	public boolean deleteCliente(@PathVariable Long id) {
		return clienteService.deleteCliente(id);		
	}
	
	/*Atualiza cadastro cliente*/
	@CrossOrigin(origins = "http://localhost:8081/", allowedHeaders = "*")
	@PutMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		if(cliente.getIdCliente() == null) {
			return new ResponseEntity<String>("ID do registro deve ser informado.", HttpStatus.OK);
		}
		Cliente clienteNew = clienteService.atualizar(cliente);
		
		return new ResponseEntity<Cliente>(clienteNew, HttpStatus.OK);		
	}
	
	

}
