package io.swagger.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.model.Ticket;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1")
    @ResponseBody Iterable<Ticket> findTicketsOfAProject(@RequestParam Integer Project_id);

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1 AND a.id = ?2")
    @ResponseBody Iterable<Ticket> findTicketsById(@RequestParam Integer Project_id, @RequestParam Integer id);
}