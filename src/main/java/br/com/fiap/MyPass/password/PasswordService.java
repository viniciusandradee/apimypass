package br.com.fiap.MyPass.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    PasswordRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Password> findAll(){
        return  repository.findAll();
    }

    public Password create(Password password){
        password.setPassword(
                passwordEncoder.encode( password.getPassword() )
        );
        return repository.save(password);
    }

}