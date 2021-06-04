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
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Validated
@Api(value = "helpdesk", description = "the helpdesk API")
@RequestMapping(value = "")
public interface HelpdeskApi {

    @ApiOperation(value = "Delete ticket by ID", nickname = "deleteTicketHelpdesk", notes = "For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ticket was deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTicketHelpdesk(@Min(1L)@ApiParam(value = "ID of the ticket that needs to be deleted",required=true) @PathVariable("ticketId") Long ticketId);


    @ApiOperation(value = "Get all users that are admins", nickname = "getAdmins", notes = "Gets a list of all admins users", response = Admin.class, tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Admin.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/admins",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Admin> getAdmins();


    @ApiOperation(value = "Get all clients", nickname = "getClients", notes = "Gets a list of all clients", response = Client.class, tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Client.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/clients",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Client> getClients();


    @ApiOperation(value = "Get all projects", nickname = "getProjectsHelpdesk", notes = "Gets a list of all the projects", response = Project.class, tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Project.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/projects",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Project> getProjectsHelpdesk();


    @ApiOperation(value = "Update ticket to be an issue or a request", nickname = "getTicketByIdHelpdesk", notes = "This can only be done by the logged in admin with the role of helpdesk.", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ticket supplied"),
        @ApiResponse(code = 404, message = "Ticket not found") })
    @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> getTicketByIdHelpdesk(@ApiParam(value = "ticket that need to be updated to be an issue or a request",required=true) @PathVariable("ticketId") String ticketId,@ApiParam(value = "Updated ticket object" ,required=true )  @Valid @RequestBody Ticket body);


    @ApiOperation(value = "Get tickets", nickname = "getTicketsHelpdesk", notes = "Gets a list of all the ticket", response = Ticket.class, tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/project/tickets",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ticket> getTicketsHelpdesk();


    @ApiOperation(value = "Get all users", nickname = "getUsers", notes = "Gets a list of all clients", response = User.class, tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/helpdesk/users",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUsers();


    @ApiOperation(value = "Logs out current logged in helpdesk session", nickname = "logoutHelpdesk", notes = "", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/helpdesk/logout",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutHelpdesk();


    @ApiOperation(value = "find ticket by ID", nickname = "updateHelpdesk", notes = "This can only be done by the logged in admin with the role of helpdesk.", tags={ "helpdesk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ticket supplied"),
        @ApiResponse(code = 404, message = "Ticket not found") })
    @RequestMapping(value = "/helpdesk/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> updateHelpdesk(@ApiParam(value = "ticket that need to be updated to be an issue or a request",required=true) @PathVariable("ticketId") String ticketId,@ApiParam(value = "Updated ticket object" ,required=true )  @Valid @RequestBody Ticket body);

}
