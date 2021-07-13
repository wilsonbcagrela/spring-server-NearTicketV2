package io.swagger.api.Repositories;

import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
}