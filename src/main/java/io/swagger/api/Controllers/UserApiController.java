package io.swagger.api.Controllers;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.Ticket.GravityEnum;
import io.swagger.model.Ticket.StatusEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.UserApi;
import io.swagger.api.Repositories.ProjectRepository;
import io.swagger.api.Repositories.TicketRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Project> addProject(@RequestParam String name, @RequestParam String description) {

        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        projectRepository.save(project);
        return new ResponseEntity<Project>(HttpStatus.CREATED);
    }

    public ResponseEntity<Ticket> addTicket(@RequestParam String name, @RequestParam String description, @RequestParam String deadLine, @RequestParam boolean urgency, @RequestParam GravityEnum gravity, @RequestParam String supervisor,@RequestParam StatusEnum status, @RequestParam Integer Project_id) {

        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setDescription(description);
        ticket.setDeadLine(deadLine);
        ticket.setUrgency(urgency);
        ticket.gravity(gravity);
        ticket.setSupervisor(supervisor);
        ticket.status(status);
        ticket.setIsRequest(false);
        ticket.setIsIssue(false);
        ticket.setProject_id(Project_id);
        ticketRepository.save(ticket);
        return new ResponseEntity<Ticket>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteTicket(@RequestParam Integer id) {
        
        ticketRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    public @ResponseBody Iterable<Project> getProjects() {
        
        
        return projectRepository.findAll();
    }

    public @ResponseBody Iterable<Ticket> getTicketById(@RequestParam Integer Project_id, @RequestParam Integer id) {


        return ticketRepository.findTicketsById(Project_id, id);
    }

    public @ResponseBody Iterable<Ticket> getTickets(@RequestParam Integer Project_id) {
        
        return ticketRepository.findTicketsOfAProject(Project_id);
    }

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> updateTicket(@RequestParam Integer id,@RequestParam Integer Project_id , @RequestParam String name) {
        
        ticketRepository.UpdateTicketsById(name, id, Project_id);
        return new ResponseEntity<Ticket>(HttpStatus.ACCEPTED);
    }
    //description, urgency, supervisor, deadLine, gravity,status,
    //, @RequestParam String description, @RequestParam String deadLine, @RequestParam boolean urgency, @RequestParam GravityEnum gravity, @RequestParam String supervisor,@RequestParam StatusEnum status
}
