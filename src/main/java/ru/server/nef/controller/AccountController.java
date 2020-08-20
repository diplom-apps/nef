package ru.server.nef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.server.nef.entity.User;
import ru.server.nef.repositories.UserRepository;

import java.util.Optional;

@RestController
public class AccountController {

    private UserRepository userRepository;

    @Autowired
    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/registration")
    public @ResponseBody String registration(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
            ){
        System.out.println(email);
        System.out.println(password);

        if (userRepository.findByEmail(email).isPresent()){
            System.out.println(userRepository.findByEmail(email).isPresent());
            return "registration_error";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "registration_success";
    }

    @PostMapping(value = "/authorization")
    public @ResponseBody String authorization(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ){
        System.out.println(email);
        System.out.println(password);

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()){
            return "email_error";
        }
        User user = userOptional.get();
        if (!user.getPassword().equals(password)){
            return "password_error";
        }
        return "auth_success";
    }
}
