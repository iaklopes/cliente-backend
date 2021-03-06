package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmail;
	
	@Column(nullable = false)
	private String email;

}
