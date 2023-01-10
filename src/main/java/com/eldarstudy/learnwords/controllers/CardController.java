package com.eldarstudy.learnwords.controllers;

import com.eldarstudy.learnwords.models.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cards")
public class CardController {

    @GetMapping("/new")
    public String showAddForm(){
        return "newCard";
    }

    @ModelAttribute(name="card")
    public Card card(){
        return new Card();
    }
}
