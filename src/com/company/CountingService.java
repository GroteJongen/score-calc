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

    public int countSyllables(String word) {
        int syllablesCount = 0;

        String processedWord = word;
        if (processedWord.endsWith("e")) {
            processedWord = processedWord.substring(0, processedWord.length() - 1);
        }

        Pattern doubleVowelPattern = Pattern.compile("[ayeiou]{2}[ayeiou]*");
        Matcher doubleVowelMatcher = doubleVowelPattern.matcher(processedWord);
        while (doubleVowelMatcher.find()) {
            syllablesCount++;
        }
        processedWord = processedWord.replaceAll(doubleVowelPattern.pattern(), "");

        Pattern singleVowelPattern = Pattern.compile("[ayeiou]");
        Matcher singleVowelMatcher = singleVowelPattern.matcher(processedWord);
        while (singleVowelMatcher.find()) {
            syllablesCount++;
        }
        return syllablesCount == 0 ? 1 : syllablesCount;
    }


    public int countPolySyllables(String[] worden) {
        int counter = 0;
        for (String s : worden) {
            String word = s.toLowerCase();
            if (countSyllables(word) >= 2) {
                counter++;
            }
        }
        return counter;
    }
}
