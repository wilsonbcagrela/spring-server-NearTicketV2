package io.swagger.api.Repositories;

// import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

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

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1 ORDER BY a.id DESC")
    @ResponseBody Iterable<Ticket> findTicketsOfAProject(@RequestParam Integer Project_id);

    @Query(value ="SELECT a FROM Ticket a WHERE a.Project_id =?1 AND a.id = ?2")
    @ResponseBody Iterable<Ticket> findTicketsById(@RequestParam Integer Project_id, @RequestParam Integer id);

    //Issue queries --------------------------------------------------------------------------------------
    @Query(value ="SELECT a FROM Ticket a WHERE a.isIssue = 1 AND a.isRequest = 0 AND a.Project_id =?1 ORDER BY a.id DESC")
    @ResponseBody Iterable<Ticket> findIssueTickets(@RequestParam Integer Project_id);
    
    @Query(value ="SELECT a FROM Ticket a WHERE a.isIssue = 1 AND a.isRequest = 0 AND a.Project_id =?1 AND a.id = ?2")
    @ResponseBody Iterable<Ticket> findIssueTicketsById(@RequestParam Integer Project_id, @RequestParam Integer id);
    
    //Request queries-------------------------------------------------------------------------------------
    @Query(value ="SELECT a FROM Ticket a WHERE a.isIssue = 0 AND a.isRequest = 1 AND a.Project_id =?1 ORDER BY a.id DESC")
    @ResponseBody Iterable<Ticket> findRequestTickets(@RequestParam Integer Project_id);
    
    @Query(value ="SELECT a FROM Ticket a WHERE a.isIssue = 0 AND a.isRequest = 1 AND a.Project_id =?1 AND a.id = ?2")
    @ResponseBody Iterable<Ticket> findRequestTicketsById(@RequestParam Integer Project_id, @RequestParam Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE Ticket a SET a.name =?1, a.description = ?2, a.urgency=?3, a.deadLine =?4, a.gravity =?5 WHERE a.id = ?6 AND a.Project_id = ?7")
    void UpdateTicketsById(String name, String description, boolean urgency, Date deadLine, GravityEnum gravity, Integer id, Integer Project_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE Ticket a SET a.isRequest =?1, a.isIssue = ?2  WHERE a.id = ?3 AND a.Project_id = ?4")
    void UpdateTicketsToBeRequestOrIssue(Boolean isRequest, Boolean isIssue, Integer id, Integer Project_id);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE Ticket a SET a.status =?1, a.supervisor = ?2  WHERE a.isIssue = 1 AND a.isRequest = 0 AND a.id = ?3 AND a.Project_id = ?4")
    void UpdateTicketsTechnician(StatusEnum status, String supervisor, Integer id, Integer Project_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE Ticket a SET a.status =?1, a.supervisor = ?2  WHERE a.isIssue = 0 AND a.isRequest = 1 AND a.id = ?3 AND a.Project_id = ?4")
    void UpdateTicketsConsultant(StatusEnum status, String supervisor, Integer id, Integer Project_id);

    @Transactional
    @Modifying
    @Query(value ="DELETE FROM Ticket a WHERE a.id = ?1 AND a.Project_id = ?2")
    void DeleteTicket(Integer id, Integer Project_id);
}