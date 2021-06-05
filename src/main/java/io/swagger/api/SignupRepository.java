package io.swagger.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Client;

@Repository
public interface SignupRepository extends JpaRepository<Client, Integer>{}
