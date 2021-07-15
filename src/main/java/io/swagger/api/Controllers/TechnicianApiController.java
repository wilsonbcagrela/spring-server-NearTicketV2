package io.swagger.api.Controllers;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.Ticket.StatusEnum;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.API.TechnicianApi;
import io.swagger.api.Repositories.AdminRepository;
import io.swagger.api.Repositories.TicketRepository;

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
public class TechnicianApiController implements TechnicianApi {

    private static final Logger log = LoggerFactory.getLogger(TechnicianApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AdminRepository adminRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public TechnicianApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteTicketTechnician(@RequestParam Integer id) {
        ticketRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    public @ResponseBody Iterable<Ticket> getIssueTicketById(@RequestParam Integer id, @RequestParam Integer Project_id) {

        return ticketRepository.findIssueTicketsById(Project_id, id);
    }

    public @ResponseBody Iterable<Ticket> getIssues(@RequestParam Integer Project_id) {
        return ticketRepository.findIssueTickets(Project_id);
    }

    public @ResponseBody Iterable<Project> getProjectsTechnician(@RequestParam Integer id) {

        return adminRepository.findAdminById(id).getProjects();
    }

    public ResponseEntity<Void> updateTechnician(@RequestParam StatusEnum status,@RequestParam String supervisor,@RequestParam Integer id,@RequestParam Integer Project_id) {
        
        ticketRepository.UpdateTicketsTechnician(status, supervisor, id, Project_id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
