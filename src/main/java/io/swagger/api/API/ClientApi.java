/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.API;

import java.util.List;
import java.util.Set;

import io.swagger.model.User;
import io.swagger.model.Project;
import io.swagger.model.Ticket;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Validated
@Api(value = "client", description = "the client API")
@RequestMapping(value = "")
public interface ClientApi {

    @ApiOperation(value = "Create user", nickname = "createUser", notes = "This can only be done by the logged in user.", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") 
    })
    @PostMapping(path="/client/user")
    ResponseEntity<Void> createUser(@RequestParam String userName, @RequestParam String email,@RequestParam String password, @RequestParam Integer phone,  @RequestParam Integer Client_id, @RequestParam String firstName, @RequestParam String lastName);

    @ApiOperation(value = "Delete user", nickname = "deleteUser", notes = "This can only be done by the logged in client.", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/client/user/{username}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username);


    @ApiOperation(value = "Returns all projects associated with the client", nickname = "getProjectsClient", notes = "Returns projects", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 404, message = "Projects not found") 
    })
    @GetMapping(path="/client/projects")
    Set<Set<Project>> getProjectsClient(@RequestParam Integer Client_id);
    


    @ApiOperation(value = "Returns all tickets associated with the client", nickname = "getTicketsClient", notes = "Returns projects", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 404, message = "ticket not found") 
    })
    @GetMapping(path="/client/project/tickets")
    Iterable<Ticket> getTicketsClient(@RequestParam Integer Project_id);


    @ApiOperation(value = "Get user by id", nickname = "getUserByid", notes = "", response = User.class, tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") 
    })
    @GetMapping(path="/client/user/{id}")
    User getUserById(@RequestParam Integer id, @RequestParam Integer Client_id);


    @ApiOperation(value = "Get all users", nickname = "getUsersClient", notes = "Gets a list of all users", response = User.class, tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ticket not found") 
    })
    @GetMapping(path="/client/users")
    public Iterable<User> getUsersClient(@RequestParam Integer Client_id);

    @ApiOperation(value = "Updated user", nickname = "updateUser", notes = "This can only be done by the logged in user.", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid user supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/client/user/{username}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body);

}
