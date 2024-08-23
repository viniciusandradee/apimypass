package br.com.fiap.MyPass.password;

import br.com.fiap.MyPass.password.dto.PasswordRequest;
import br.com.fiap.MyPass.password.dto.PasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pass")
public class PasswordController {
    @Autowired
    PasswordService service;

    @GetMapping
    public List<Password> findAll(){
        return  service.findAll();
    }

    @PostMapping
    public ResponseEntity<PasswordResponse> create(@RequestBody PasswordRequest passwordRequest, UriComponentsBuilder uriBuilder){
        var password = service.create(passwordRequest.toModel()); // Call toModel() on the passwordRequest object
        var uri = uriBuilder
                .path("/pass/{id}")
                .buildAndExpand(password.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(PasswordResponse.from(password));
    }

}