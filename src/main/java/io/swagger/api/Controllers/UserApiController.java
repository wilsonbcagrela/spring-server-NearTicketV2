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

    public ResponseEntity<Void> deleteTicket(@Min(1L)@ApiParam(value = "ID of the ticket that needs to be deleted",required=true) @PathVariable("ticketId") Long ticketId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> getProjects() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> getTicketById(@Min(1L) @Max(10L) @ApiParam(value = "ID of ticket that needs to be fetched",required=true) @PathVariable("ticketId") Long ticketId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("<ticket>  <id>123456789</id>  <name>issue with a part of the code</name>  <description>explains in detail what the issue is</description>  <deadLine>deadline to fix the issue</deadLine>  <urgency>true</urgency>  <gravity>aeiou</gravity>  <supervisor>aeiou</supervisor>  <status>aeiou</status>  <isRequest>true</isRequest>  <isIssue>true</isIssue></ticket>", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{  \"urgency\" : true,  \"isRequest\" : false,  \"gravity\" : \"mild\",  \"name\" : \"issue with a part of the code\",  \"description\" : \"explains in detail what the issue is\",  \"isIssue\" : false,  \"id\" : 0,  \"deadLine\" : \"deadline to fix the issue\",  \"supervisor\" : \"supervisor\",  \"status\" : \"not initiated\"}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> getTickets() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> updateTicket(@Min(1L)@ApiParam(value = "ID of the ticket that needs to be updated",required=true) @PathVariable("ticketId") Long ticketId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{  \"urgency\" : true,  \"isRequest\" : false,  \"gravity\" : \"mild\",  \"name\" : \"issue with a part of the code\",  \"description\" : \"explains in detail what the issue is\",  \"isIssue\" : false,  \"id\" : 0,  \"deadLine\" : \"deadline to fix the issue\",  \"supervisor\" : \"supervisor\",  \"status\" : \"not initiated\"}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("<ticket>  <id>123456789</id>  <name>issue with a part of the code</name>  <description>explains in detail what the issue is</description>  <deadLine>deadline to fix the issue</deadLine>  <urgency>true</urgency>  <gravity>aeiou</gravity>  <supervisor>aeiou</supervisor>  <status>aeiou</status>  <isRequest>true</isRequest>  <isIssue>true</isIssue></ticket>", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

}
