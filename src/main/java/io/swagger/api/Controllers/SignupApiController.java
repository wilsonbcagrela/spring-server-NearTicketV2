package io.swagger.api.Controllers;

import io.swagger.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.SignupApi;
import io.swagger.api.Repositories.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class SignupApiController implements SignupApi {

    private static final Logger log = LoggerFactory.getLogger(SignupApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ClientRepository clientRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public SignupApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public @ResponseBody String registerClient(@RequestParam String name,@RequestParam String password, @RequestParam String email, @RequestParam Integer phone, @RequestParam Boolean isEmailConfirmed) {
        // String accept = request.getHeader("Accept");
        Client n = new Client();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        n.setPhone(phone);
        n.setIsEmailConfirmed(isEmailConfirmed);
        
        clientRepository.save(n);
        return "saved";
    }
}
