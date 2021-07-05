package io.swagger.api.Controllers;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.Ticket.StatusEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.ConsultantApi;
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
public class ConsultantApiController implements ConsultantApi {

    private static final Logger log = LoggerFactory.getLogger(ConsultantApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AdminRepository adminRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public ConsultantApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteTicketConsultant(@RequestParam Integer id) {
        ticketRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    public @ResponseBody Iterable<Project> getProjectsConsultant(@RequestParam Integer id) {
        

        return adminRepository.findAdminById(id).getProjects();
    }

    public @ResponseBody Iterable<Ticket> getRequest(@RequestParam Integer Project_id) {
        

        return ticketRepository.findRequestTickets(Project_id);
    }

    public @ResponseBody Iterable<Ticket> getRequestTicketById(@RequestParam Integer id, @RequestParam Integer Project_id) {
        

        return ticketRepository.findRequestTicketsById(Project_id, id);
    }

    public ResponseEntity<Void> logoutConsultant() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateConsultant(@RequestParam StatusEnum status,@RequestParam String supervisor,@RequestParam Integer id,@RequestParam Integer Project_id) {
        
        ticketRepository.UpdateTicketsConsultant(status, supervisor, id, Project_id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
