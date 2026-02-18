package com.bajrang.unitconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bajrang.unitconverter.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
