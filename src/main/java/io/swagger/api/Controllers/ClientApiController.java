package io.swagger.api.Controllers;

import java.util.*;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.User;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.ClientApi;
import io.swagger.api.Repositories.TicketRepository;
import io.swagger.api.Repositories.UserRepository;

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

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class ClientApiController implements ClientApi {

    private static final Logger log = LoggerFactory.getLogger(ClientApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public ClientApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createUser(@RequestParam String userName, @RequestParam String email,@RequestParam String password, @RequestParam Integer phone,  @RequestParam Integer Client_id, @RequestParam String firstName, @RequestParam String lastName) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setIsEmailConfirmed(false);
        user.setPhone(phone);
        user.setClient_id(Client_id);

        userRepository.save(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> createUsersWithArrayInput(@ApiParam(value = "List of user object" ,required=true )  @Valid @RequestBody List<User> body) {
        // String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createUsersWithListInput(@ApiParam(value = "List of user object" ,required=true )  @Valid @RequestBody List<User> body) {
        // String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username) {
        // String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public @ResponseBody List<Set<Project>> getProjectsClient(@RequestParam Integer Client_id) {
        
        List<Set<Project>> projectsClient = new Stack<Set<Project>>();
        for (User user : userRepository.findAllUserOfClient(Client_id)) {
            projectsClient.add(user.getProject());
            
        }
        
        return projectsClient;
    }

    public @ResponseBody Iterable<Ticket> getTicketsClient(@RequestParam Integer Project_id) {
        // String accept = request.getHeader("Accept");
        return ticketRepository.findTicketsOfAProject(Project_id);
    }

    public @ResponseBody User getUserById(@RequestParam Integer id, @RequestParam Integer Client_id) {
        
        return userRepository.findUserById(id, Client_id);

    }
    public @ResponseBody Iterable<User> getUsersClient(@RequestParam Integer Client_id) {

        return userRepository.findAllUserOfClient(Client_id);
    }

    public ResponseEntity<Void> logoutClient() {
        // String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateUser(@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body) {
        // String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
