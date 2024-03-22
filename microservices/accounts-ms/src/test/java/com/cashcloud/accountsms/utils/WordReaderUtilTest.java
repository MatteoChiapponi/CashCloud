package com.cashcloud.accountsms.utils;

import com.cashcloud.accountsms.alias.domain.utils.IRandomWordGenerator;
import com.cashcloud.accountsms.alias.domain.utils.WordReaderUtil;
import org.junit.jupiter.api.Test;

class WordReaderUtilTest {
    private final IRandomWordGenerator randomWordGenerator = WordReaderUtil.getInstance();

    @Test
    void randomWord() {
        System.out.println(randomWordGenerator.generateRandomWord());
    }
}