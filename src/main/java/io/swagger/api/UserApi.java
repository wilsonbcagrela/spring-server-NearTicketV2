/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.model.Ticket.GravityEnum;
import io.swagger.model.Ticket.StatusEnum;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Validated
@Api(value = "user", description = "the user API")
@RequestMapping(value = "")
public interface UserApi {

    @ApiOperation(value = "Add a project", nickname = "addProject", notes = "Here you can create a new project", response = Project.class, tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Project.class),
    //     @ApiResponse(code = 400, message = "Invalid ticket") })
    // @RequestMapping(value = "/user/project",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.POST)
    @PostMapping(path="/user/project")
    ResponseEntity<Project> addProject(@RequestParam String name, @RequestParam String description);


    @ApiOperation(value = "Add a ticket to a project", nickname = "addTicket", notes = "Here you can add a ticket to an a existing project", response = Ticket.class, tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
    //     @ApiResponse(code = 400, message = "Invalid ticket") })
    // @RequestMapping(value = "/user/project/ticket",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.POST)
    @PostMapping(path="/user/project/ticket")
    ResponseEntity<Ticket> addTicket(@RequestParam String name, @RequestParam String description, @RequestParam String deadLine, @RequestParam boolean urgency, @RequestParam GravityEnum gravity, @RequestParam String supervisor,@RequestParam StatusEnum status, @RequestParam Integer Project_id);


    @ApiOperation(value = "Delete ticket by ID", nickname = "deleteTicket", notes = "For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors", tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "Ticket was deleted successfully"),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/user/project/ticket/{ticketId}",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.DELETE)
    @DeleteMapping("/user/project/ticket/{ticketId}")
    ResponseEntity<Void> deleteTicket(@RequestParam Integer id);


    @ApiOperation(value = "Returns all projects associated with the user", nickname = "getProjects", notes = "Returns projects", tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation"),
    //     @ApiResponse(code = 404, message = "Projects not found") })
    // @RequestMapping(value = "/user/projects",
    //     produces = { "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/user/projects")
    @ResponseBody Iterable<Project> getProjects();


    @ApiOperation(value = "Find ticket by ID", nickname = "getTicketById", notes = "For valid response try integer IDs with value >= 1 and <= 10.         Other values will generated exceptions", response = Ticket.class, tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found") })
    // @RequestMapping(value = "/user/project/ticket/{ticketId}",
    //     produces = { "application/xml", "application/json" }, 
    //     method = RequestMethod.GET)
        @GetMapping(path="/user/project/ticket/{ticketId}")
        @ResponseBody Iterable<Ticket> getTicketById(@RequestParam Integer Project_id, @RequestParam Integer id);


    @ApiOperation(value = "Returns tickets associated with the project by status", nickname = "getTickets", notes = "Returns a map of status", tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "successful operation"),
    //     @ApiResponse(code = 404, message = "tickets not found") })
    // @RequestMapping(value = "/user/project/tickets",
    //     produces = { "application/json" }, 
    //     method = RequestMethod.GET)
    @GetMapping(path="/user/project/tickets")
    @ResponseBody Iterable<Ticket> getTickets(@RequestParam Integer Project_id);


    @ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user/logout",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutUser();


    @ApiOperation(value = "Update an existing ticket", nickname = "updateTicket", notes = "", response = Ticket.class, tags={ "user", })
    // @ApiResponses(value = { 
    //     @ApiResponse(code = 200, message = "ticket updated successfully", response = Ticket.class),
    //     @ApiResponse(code = 400, message = "Invalid ID supplied"),
    //     @ApiResponse(code = 404, message = "ticket not found"),
    //     @ApiResponse(code = 405, message = "Validation exception") })
    // @RequestMapping(value = "/user/project/ticket/{ticketId}",
    //     produces = { "application/json", "application/xml" }, 
    //     consumes = { "application/json", "application/xml" },
    //     method = RequestMethod.PUT)
    @PutMapping(path="/user/project/ticket/{ticketId}")
    ResponseEntity<Ticket> updateTicket(@RequestParam Integer id,@RequestParam Integer Project_id , @RequestParam String name);
        //, @RequestParam String description, @RequestParam String deadLine, @RequestParam boolean urgency, @RequestParam GravityEnum gravity, @RequestParam String supervisor,@RequestParam StatusEnum status
}
