package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingService {


     public int countWordsInText(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.split(" ");
        return words.length;
    }

    public int countCharactersInText(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        return text.replace(" ", "").length();
    }

    public int countSentencesInText(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] sentences = text.split("\\.");
        return sentences.length;
    }

    public  int countSyllables(String s) {
        final Pattern p = Pattern.compile("([ayeiou])");
        final Pattern correcting = Pattern.compile("([ayeiou][ayeiou])");
        final String lowerCase = s.toLowerCase();
        final Matcher m = p.matcher(lowerCase);
        final Matcher killer = correcting.matcher(lowerCase);
        int count = 0;
        while (m.find())
            count++;
        if (lowerCase.endsWith("e"))
            count--;
        while (killer.find())
            count--;
        count--;
        return count < 0 ? 1 : count;
    }

    public  int countPolySyllables(String[] worden) {
        int counter = 0;
        for (String s : worden) {
            String word = s.toLowerCase();
            if (countSyllables(word) > 1) {
                counter++;
            }
        }
        return counter;
    }
}
