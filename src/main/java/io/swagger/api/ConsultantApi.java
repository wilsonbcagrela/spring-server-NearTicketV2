/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Project;
import io.swagger.model.Ticket;
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
@Api(value = "consultant", description = "the consultant API")
@RequestMapping(value = "")
public interface ConsultantApi {

    @ApiOperation(value = "Delete ticket by ID", nickname = "deleteTicketConsultant", notes = "For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors", tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ticket was deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/consultant/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTicketConsultant(@Min(1L)@ApiParam(value = "ID of the ticket that needs to be deleted",required=true) @PathVariable("ticketId") Long ticketId);


    @ApiOperation(value = "Get all projects", nickname = "getProjectsConsultant", notes = "Gets a list of all the projects", response = Project.class, tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Project.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/consultant/projects",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Project> getProjectsConsultant();


    @ApiOperation(value = "Get tickets that are requests", nickname = "getRequest", notes = "Gets a list of all the tickets that are requests", response = Ticket.class, tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/consultant/project/tickets",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ticket> getRequest();


    @ApiOperation(value = "Find request tickets by ID", nickname = "getRequestTicketById", notes = "For valid response try integer IDs with value >= 1 and <= 10.         Other values will generated exceptions", response = Ticket.class, tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Ticket.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") })
    @RequestMapping(value = "/consultant/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ticket> getRequestTicketById(@Min(1L) @Max(10L) @ApiParam(value = "ID of ticket that needs to be fetched",required=true) @PathVariable("ticketId") Long ticketId);


    @ApiOperation(value = "Logs out current logged in consultant session", nickname = "logoutConsultant", notes = "", tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/consultant/logout",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutConsultant();


    @ApiOperation(value = "Update a request", nickname = "updateConsultant", notes = "This can only be done by the logged in admin with the role of consultant.", tags={ "consultant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ticket supplied"),
        @ApiResponse(code = 404, message = "Ticket not found") })
    @RequestMapping(value = "/consultant/project/ticket/{ticketId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateConsultant(@ApiParam(value = "request that need to be updated",required=true) @PathVariable("ticketId") String ticketId,@ApiParam(value = "Updated ticket object" ,required=true )  @Valid @RequestBody Ticket body);

}
