package com.mateo.usersms.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordReaderUtilTest {
    private final IRandomWordGenerator randomWordGenerator = WordReaderUtil.getInstance();

    @Test
    void randomWord() {
        System.out.println(randomWordGenerator.generateRandomWord());
    }
}