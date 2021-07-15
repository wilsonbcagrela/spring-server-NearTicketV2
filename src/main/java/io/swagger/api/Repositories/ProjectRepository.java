package io.swagger.api.Repositories;

import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Project;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    
}