package com.eldarstudy.learnwords.models;

import lombok.Data;

@Data
public class Card {
    private final Long id;
    private final String frontSide;
    private final String backSide;

}
