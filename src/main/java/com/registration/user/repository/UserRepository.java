package com.registration.user.repository;

import com.registration.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserNameAndUserPassword(String userName, String userPassword);
}
