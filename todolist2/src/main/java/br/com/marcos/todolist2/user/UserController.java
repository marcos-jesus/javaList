package br.com.marcos.todolist2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserRepository userRepository;
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var verifyUser = this.userRepository.findByUsername(userModel.getUsername());
        var verifyNome = this.userRepository.findByName(userModel.getName());

        if(verifyUser != null) {
            System.out.println("Usuário já existe com este username");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Username já existe!");
        }

        if(verifyNome != null) {
            System.out.println("Este nome já está cadastrado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este nome já existe!");
        }

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
