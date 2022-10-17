package com.example.ecom.service;

import com.example.ecom.dto.user.ResponseDto;
import com.example.ecom.dto.user.SignupDto;
import com.example.ecom.exceptions.CustomException;
import com.example.ecom.model.User;
import com.example.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseDto signUp(SignupDto signupDto) {
        if(Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            throw new CustomException("user already present");
        }
        String password = signupDto.getPassword();
        try {
            password = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        User user = new User(signupDto.getFirst_name(), signupDto.getLast_name(), signupDto.getEmail(), password);
        userRepository.save(user);

        ResponseDto responseDto = new ResponseDto("success", "dummy response");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }
}
