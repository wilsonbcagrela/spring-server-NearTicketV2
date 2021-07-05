package io.swagger.api.Controllers;

import io.swagger.model.Admin;
import io.swagger.model.Client;
import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.User;
import io.swagger.model.Admin.RoleEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.HelpdeskApi;
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

import javax.servlet.http.HttpServletRequest;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class HelpdeskApiController implements HelpdeskApi {

    private static final Logger log = LoggerFactory.getLogger(HelpdeskApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    // @Autowired
    // private ProjectRepository projectRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public HelpdeskApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteTicketHelpdesk(@RequestParam Integer id) {
        ticketRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    public @ResponseBody Iterable<Admin> getAdmins() {

        return adminRepository.findAll();
    }

    public @ResponseBody Iterable<Client> getClients() {
        

        return clientRepository.findAll();
    }

    public @ResponseBody Iterable<Project> getProjectsHelpdesk(@RequestParam Integer id) {
        
        return adminRepository.findAdminById(id).getProjects();
    }

    public @ResponseBody Iterable<Ticket> getTicketByIdHelpdesk(@RequestParam Integer id,@RequestParam Integer Project_id) {
        
        return ticketRepository.findTicketsById(Project_id, id);
    }

    public @ResponseBody Iterable<Ticket> getTicketsHelpdesk(@RequestParam Integer Project_id) {

        return ticketRepository.findTicketsOfAProject(Project_id);
    }

    public @ResponseBody Iterable<User> getUsers(@RequestParam Integer Client_id) {

        return userRepository.findAllUserOfClient(Client_id);
    }

    public ResponseEntity<Void> logoutHelpdesk() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateHelpdesk(@RequestParam Boolean isRequest,@RequestParam Boolean isIssue,@RequestParam Integer id,@RequestParam Integer Project_id) {
        
        ticketRepository.UpdateTicketsToBeRequestOrIssue(isRequest, isIssue, id, Project_id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    public ResponseEntity<Admin> addAdmin(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam Integer phone,@RequestParam RoleEnum role) {
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setPhone(phone);
        admin.setIsAdmin(true);
        admin.setIsEmailConfirmed(false);
        admin.role(role);
        adminRepository.save(admin);
        return new ResponseEntity<Admin>(HttpStatus.CREATED);
    }
    public ResponseEntity<Project> addProjectToAdmin(@RequestParam Integer id,@RequestParam Integer Project_id){
        //cuidado se o criador do projeto adcionar-se a si proprio pode dar problemas
     
        Project project = projectRepository.findOne(Project_id);
        adminRepository.findOne(id).getProjects().add(project);

        projectRepository.save(project);
        return new ResponseEntity<Project>(HttpStatus.ACCEPTED);
    }
    // public void manytomanytest(@RequestParam Integer id){
        
    //     Project project = new Project();
    //     project.setName("name");
    //     project.setDescription("description");
        

    //     project.getAdmin().add(adminRepository.findAdminById(id));
    //     adminRepository.findAdminById(id).getProjects().add(project);

    //     // adminRepository.save(admin);
    //     projectRepository.save(project);
    // }
}
