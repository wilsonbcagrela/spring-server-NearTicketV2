package io.swagger.api.Controllers;
import io.swagger.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.LoginApi;
import io.swagger.api.Repositories.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class LoginApiController implements LoginApi {

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    // private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ClientRepository clientRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        // this.objectMapper = objectMapper;
        this.request = request;
    }

    public @ResponseBody Iterable<Client> login(@RequestParam String email, @RequestParam String password) {
        
        return clientRepository.findClientByEmailAndPassword(email, password);
    }

}
