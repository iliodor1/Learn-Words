package com.eldarstudy.learnwords.repositories;

import com.eldarstudy.learnwords.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
