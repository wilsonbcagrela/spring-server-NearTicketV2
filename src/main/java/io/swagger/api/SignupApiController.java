package io.swagger.api;

import io.swagger.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Controller
public class SignupApiController implements SignupApi {

    private static final Logger log = LoggerFactory.getLogger(SignupApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SignupApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> registerClient(@RequestParam String name, @RequestParam String email,@RequestParam String password, @RequestParam String phone, @RequestParam Boolean isEmailConfirmed) {
        // String accept = request.getHeader("Accept");
        Client n = new Client();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        n.setPhone(phone);
        n.setIsEmailConfirmed(isEmailConfirmed);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
