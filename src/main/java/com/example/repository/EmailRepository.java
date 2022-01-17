package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
