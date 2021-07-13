package io.swagger.api.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Comment;
import io.swagger.model.Ticket;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
    @Query(value ="SELECT a FROM Comment a, Ticket b WHERE a.ticket = b.id AND b.id = ?1")
    Iterable<Comment> getCommentsOfTicket(Integer ticket_id);
}