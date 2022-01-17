package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(nullable = false)
	@Length(min = 3, max = 100)
	private String nome;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Endereco endereco;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<Telefone> telefoneList = new ArrayList<Telefone>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<Email> emailList = new ArrayList<Email>(0);

}
	

