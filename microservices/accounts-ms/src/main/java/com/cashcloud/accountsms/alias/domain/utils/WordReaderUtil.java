package com.cashcloud.accountsms.alias.domain.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class WordReaderUtil {
    public static final String WORDS_FILE_PATH = "words.txt";

    private final List<String> words;

    public WordReaderUtil() {
        this.words = readWords();
    }
    private List<String> readWords(){
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(WORDS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                words.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }


    public String generateRandomWord() {
        var randomIndex = ThreadLocalRandom.current().nextInt(0, words.size()-1);
        return words.get(randomIndex);
    }
}
