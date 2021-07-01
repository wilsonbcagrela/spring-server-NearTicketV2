package io.swagger.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.model.Ticket;
import io.swagger.model.Ticket.GravityEnum;
import io.swagger.model.Ticket.StatusEnum;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1")
    @ResponseBody Iterable<Ticket> findTicketsOfAProject(@RequestParam Integer Project_id);

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1 AND a.id = ?2")
    @ResponseBody Iterable<Ticket> findTicketsById(@RequestParam Integer Project_id, @RequestParam Integer id);
    
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE Ticket a SET a.name =?1 WHERE a.id = ?2 AND a.Project_id = ?3")
    @ResponseBody Iterable<Ticket> UpdateTicketsById(@RequestParam String name,@RequestParam Integer id, @RequestParam Integer Project_id);
}

//a.description = ?2, a.urgency=?3, a.supervisor =?4, a.deadLine =?5, a.gravity =?6, a.status =?7 
// @RequestParam String description, @RequestParam boolean urgency, @RequestParam String supervisor, @RequestParam String deadLine, @RequestParam GravityEnum gravity, @RequestParam StatusEnum status,