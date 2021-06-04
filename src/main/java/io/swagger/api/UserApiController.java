package io.swagger.api;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Project> addProject(@ApiParam(value = "Project been created" ,required=true )  @Valid @RequestBody Project body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("<project>  <id>123456789</id>  <name>my project</name>  <description>This projects is about collecting tickets</description></project>", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("{  \"name\" : \"my project\",  \"description\" : \"This projects is about collecting tickets\",  \"id\" : 0}", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> addTicket(@ApiParam(value = "Ticket been placed" ,required=true )  @Valid @RequestBody Ticket body) {
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
