package com.example.ecom.repository;

import com.example.ecom.model.AuthenticationToken;
import com.example.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}
