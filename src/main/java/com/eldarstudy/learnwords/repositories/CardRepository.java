package com.eldarstudy.learnwords.repositories;

import com.eldarstudy.learnwords.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
