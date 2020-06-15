package com.counter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingService {
  private static final String SPLITTER = " ";
  private static final String EMPTY_STRING = "";

  public static int countWordsInText(String text) {
    if (text.isEmpty()) {
      return 0;
    }
    String[] words = text.split(SPLITTER);
    return words.length;
  }

  public static int countCharactersInText(String text) {
    if (text.isEmpty()) {
      return 0;
    }
    return text.replace(SPLITTER, EMPTY_STRING).length();
  }

  public static int countSentencesInText(String text) {
    if (text.isEmpty()) {
      return 0;
    }
    String[] sentences = text.split("\\.");
    return sentences.length;
  }

  public static int countSyllables(String sentence) {
    String normalizedSentence =
        sentence
            .toLowerCase()
            .replaceAll(",", EMPTY_STRING)
            .replaceAll("\"", EMPTY_STRING)
            .replaceAll(":", EMPTY_STRING)
            .replaceAll("!", EMPTY_STRING)
            .replaceAll(";", EMPTY_STRING)
            .replaceAll("\n;", EMPTY_STRING)
            .replaceAll("[.]", EMPTY_STRING);

    final String[] words = normalizedSentence.split(SPLITTER);
    int syllablesCount = 0;
    for (String word : words) {
      syllablesCount += countSyllablesInWord(word);
    }
    return syllablesCount;
  }

  private static int countSyllablesInWord(String word) {
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
    processedWord = processedWord.replaceAll(doubleVowelPattern.pattern(), EMPTY_STRING);

    Pattern singleVowelPattern = Pattern.compile("[ayeiou]");
    Matcher singleVowelMatcher = singleVowelPattern.matcher(processedWord);
    while (singleVowelMatcher.find()) {
      syllablesCount++;
    }
    return syllablesCount == 0 ? 1 : syllablesCount;
  }

  public static int countPolySyllables(String[] worden) {
    int counter = 0;
    for (String s : worden) {
      String word = s.toLowerCase();
      if (countSyllables(word) > 2) {
        counter++;
      }
    }
    return counter;
  }
}
