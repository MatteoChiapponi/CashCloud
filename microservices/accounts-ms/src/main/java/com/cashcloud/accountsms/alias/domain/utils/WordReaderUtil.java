package com.cashcloud.accountsms.alias.domain.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class WordReaderUtil implements IRandomWordGenerator {
    public static final String wordsFilePath = "words.txt";
    private static WordReaderUtil instance;

    private final List<String> words;

    private WordReaderUtil() {
        System.out.println("se instancio un word reader");
        this.words = readWords();
    }
    private List<String> readWords(){
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(wordsFilePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                words.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static WordReaderUtil getInstance() {
        if (WordReaderUtil.instance == null)
            instance = new WordReaderUtil();

        return instance;
    }

    @Override
    public String generateRandomWord() {
        var randomIndex = ThreadLocalRandom.current().nextInt(0, words.size()-1);
        return words.get(randomIndex);
    }
}
