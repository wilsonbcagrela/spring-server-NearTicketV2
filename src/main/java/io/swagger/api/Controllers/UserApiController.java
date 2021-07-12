package io.swagger.api.Controllers;

import io.swagger.model.Admin;
import io.swagger.model.Client;
import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.User;
import io.swagger.model.Ticket.GravityEnum;
import io.swagger.model.Ticket.StatusEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.UserApi;
import io.swagger.api.Repositories.AdminRepository;
import io.swagger.api.Repositories.ClientRepository;
import io.swagger.api.Repositories.ProjectRepository;
import io.swagger.api.Repositories.TicketRepository;
import io.swagger.api.Repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;


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
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    public @ResponseBody Iterable<User> getUsersOfAClient(@RequestParam Integer Client_id){
        return userRepository.findAllUserOfClient(Client_id);
    }
    public @ResponseBody Iterable<User> getUsersOfAProject(@RequestParam Integer project_id){
        return projectRepository.findOne(project_id).getUser();
    }
    public @ResponseBody Iterable<Admin> getAdminsOfAProject(@RequestParam Integer project_id){
        return projectRepository.findOne(project_id).getAdmin();
    }
    public @ResponseBody Iterable<Client> getClientOfUser(@RequestParam Integer id){
        return clientRepository.findClient(id);
    }
    public ResponseEntity<Project> addProject(@RequestParam Integer id, @RequestParam Integer Client_id, @RequestParam String name, @RequestParam String description) {

        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        for (Admin admin : adminRepository.findAll()) {
            admin.getProjects().add(project);
        }
        
        // for (User user : userRepository.findAllUserOfClient(Client_id)) {
        //     user.getProject().add(project);
        // }
        userRepository.findUserById(id, Client_id).getProject().add(project);
        projectRepository.save(project);
        return new ResponseEntity<Project>(HttpStatus.CREATED);
    }

    public ResponseEntity<Ticket> addTicket(@RequestParam String name, @RequestParam String description, @RequestParam Date deadLine, @RequestParam boolean urgency, @RequestParam GravityEnum gravity, @RequestParam Integer Project_id, @RequestParam String owner,@RequestParam Date creationDate) {
  
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setDescription(description);
        ticket.setDeadLine(deadLine);
        ticket.setUrgency(urgency);
        ticket.gravity(gravity);
        ticket.status(StatusEnum.NOT_INITIATED);
        ticket.setIsRequest(false);
        ticket.setIsIssue(false);
        ticket.setProject_id(Project_id);
        ticket.setOwner(owner);
        ticket.setCreationDate(creationDate);
        ticketRepository.save(ticket);
        return new ResponseEntity<Ticket>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteTicket(@RequestParam Integer id) {
        
        ticketRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    public @ResponseBody Iterable<Project> getProjects(@RequestParam Integer id, @RequestParam Integer Client_id) {
        
        
        return userRepository.findUserById(id, Client_id).getProject();
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

    public ResponseEntity<Ticket> updateTicket(@RequestParam Integer id,@RequestParam Integer Project_id , @RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) String deadLine, @RequestParam(required = false) boolean urgency, @RequestParam(required = false) GravityEnum gravity, @RequestParam(required = false) String supervisor,@RequestParam(required = false) StatusEnum status) {
        
        ticketRepository.UpdateTicketsById(name,description, urgency, supervisor, deadLine, gravity,status, id, Project_id);
        return new ResponseEntity<Ticket>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Project> addProjectToUser(@RequestParam Integer Client_id, @RequestParam Integer id, @RequestParam Integer Project_id){
        //cuidado se o criador do projeto adcionar-se a si proprio pode dar problemas
        
        Project project = projectRepository.findOne(Project_id);
        userRepository.findUserById(id, Client_id).getProject().add(project);

        projectRepository.save(project);
        return new ResponseEntity<Project>(HttpStatus.ACCEPTED);
    }
}