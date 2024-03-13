package com.JulioCesarCardosoDEV.payment_system.service;

import com.JulioCesarCardosoDEV.payment_system.entity.User;
import com.JulioCesarCardosoDEV.payment_system.repository.UserRepository;
import com.JulioCesarCardosoDEV.payment_system.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Este email já existe");
        }else{
            String encondedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encondedPassword);

            String randomCode = RandomString.generateRandomString(64);
            user.setVerificationCode(randomCode);
            user.setEnabled(false);

            User savedUser = userRepository.save(user);

            return savedUser;
        }
    }
}
