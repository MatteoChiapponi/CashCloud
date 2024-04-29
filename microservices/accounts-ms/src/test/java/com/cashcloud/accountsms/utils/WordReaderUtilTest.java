package com.cashcloud.accountsms.utils;

import com.cashcloud.accountsms.alias.domain.utils.WordReaderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordReaderUtilTest {

    @Autowired
    private WordReaderUtil wordReaderUtil;

    @Test
    void randomWord() {
        System.out.println(wordReaderUtil.generateRandomWord());
    }
}