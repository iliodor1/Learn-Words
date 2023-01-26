package com.eldarstudy.learnwords.controllers;

import com.eldarstudy.learnwords.models.Card;
import com.eldarstudy.learnwords.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardRepo;

    @GetMapping("/new")
    public String showAddForm() {
        return "newCard";
    }

    @ModelAttribute(name = "card")
    public Card card() {
        return new Card();
    }

    @PostMapping("/new")
    public String processRegistration(Card card) {
        Card card1 = cardRepo.save(card);
        log.info(card1.getFrontSide());
        return "redirect:/";
    }

    @GetMapping("/learn")
    public String showLearnPage(Model model) {
        Card card = cardRepo.findAll()
                            .stream()
                            .findFirst()
                            .orElseThrow();

        log.info(card.getFrontSide());
        model.addAttribute("cardFront", card.getFrontSide());
        model.addAttribute("cardBack", card.getBackSide());

        return "/learn";
    }

}
