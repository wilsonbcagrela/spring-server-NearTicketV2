/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Admin;
import io.swagger.model.Client;
import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.User;
import io.swagger.model.Admin.RoleEnum;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Validated
@Api(value = "helpdesk", description = "the helpdesk API")
@RequestMapping(value = "")
public interface HelpdeskApi {

    @ApiOperation(value = "Delete ticket by ID", nickname = "deleteTicketHelpdesk", notes = "For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors", tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "Ticket was deleted successfully"),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.DELETE)
    @DeleteMapping("/helpdesk/project/ticket/{ticketId}")
    ResponseEntity<Void> deleteTicketHelpdesk(@RequestParam Integer id);


    @ApiOperation(value = "Get all users that are admins", nickname = "getAdmins", notes = "Gets a list of all admins users", response = Admin.class, tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Admin.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/admins",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/admins")
    public @ResponseBody Iterable<Admin> getAdmins();


    @ApiOperation(value = "Get all clients", nickname = "getClients", notes = "Gets a list of all clients", response = Client.class, tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Client.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/clients",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/clients")
    @ResponseBody Iterable<Client> getClients();


    @ApiOperation(value = "Get all projects", nickname = "getProjectsHelpdesk", notes = "Gets a list of all the projects", response = Project.class, tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Project.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/projects",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/projects")
    @ResponseBody Iterable<Project> getProjectsHelpdesk(@RequestParam Integer id);

    @ApiOperation(value = "Update ticket to be an issue or a request", nickname = "getTicketByIdHelpdesk", notes = "This can only be done by the logged in admin with the role of helpdesk.", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 202, message = "Accepted operation"),
        @ApiResponse(code = 400, message = "Invalid ticket supplied"),
        @ApiResponse(code = 404, message = "Ticket not found") })
    @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
        ResponseEntity<Void> updateHelpdesk(@RequestParam Boolean isRequest,@RequestParam Boolean isIssue,@RequestParam Integer id,@RequestParam Integer Project_id);


    @ApiOperation(value = "Get tickets", nickname = "getTicketsHelpdesk", notes = "Gets a list of all the ticket", response = Ticket.class, tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/project/tickets",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/project/tickets")
    @ResponseBody Iterable<Ticket> getTicketsHelpdesk(@RequestParam Integer Project_id);


    @ApiOperation(value = "Get all users", nickname = "getUsers", notes = "Gets a list of all clients", response = User.class, tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = User.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/helpdesk/users",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/users")
    @ResponseBody Iterable<User> getUsers(@RequestParam Integer Client_id);


    @ApiOperation(value = "Logs out current logged in helpdesk session", nickname = "logoutHelpdesk", notes = "", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/helpdesk/logout",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutHelpdesk();


    @ApiOperation(value = "find ticket by ID", nickname = "updateHelpdesk", notes = "This can only be done by the logged in admin with the role of helpdesk.", tags={ "helpdesk", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation"),
    //     @ApiResponse(code = 400, message = "Invalid ticket supplied"),
    //     @ApiResponse(code = 404, message = "Ticket not found") })
    // @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/helpdesk/project/ticket/{ticketId}")
    @ResponseBody Iterable<Ticket> getTicketByIdHelpdesk(@RequestParam Integer id,@RequestParam Integer Project_id);
    
    @PostMapping(path="/helpdesk/createAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam Integer phone,@RequestParam RoleEnum role);
    
    // @PostMapping(path="/helpdesk/teste")
    // void manytomanytest(@RequestParam Integer id);
}
