package io.swagger.api.Controllers;
import io.swagger.model.Admin;
import io.swagger.model.Client;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.API.LoginApi;
import io.swagger.api.Repositories.AdminRepository;
import io.swagger.api.Repositories.ClientRepository;
import io.swagger.api.Repositories.UserRepository;

// import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class LoginApiController implements LoginApi {

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public @ResponseBody Iterable<Client> loginClient(@RequestParam String email, @RequestParam String password) {
        
        return clientRepository.findClientByEmailAndPassword(email, password);
    }
    public @ResponseBody Iterable<User> loginUser(@RequestParam String email, @RequestParam String password) {
        
        return userRepository.findUserByEmailAndPassword(email, password);
    }
    public @ResponseBody Iterable<Admin> loginAdmin(@RequestParam String email, @RequestParam String password) {
        
        return adminRepository.findAdminByEmailAndPassword(email, password);
    }

}
