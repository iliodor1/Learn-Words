package com.eldarstudy.learnwords.repositories;

import com.eldarstudy.learnwords.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
