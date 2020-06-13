package com.display;

import com.counter.CountingService;

public class DisplayService {
  private CountingService countingService;

  public DisplayService(CountingService countingService) {
    this.countingService = countingService;
  }

  public String printAllParametersOfText(String text) {
    String words = " Words: " + countingService.countWordsInText(text) + "|";
    String sentences = " Sentences: " + countingService.countSentencesInText(text) + "|";
    String characters = " Characters: " + countingService.countCharactersInText(text)+ "|";
    String syllables = " Syllables: " + countingService.countSyllables(text) + "|";
    String polySyllables = " Polysyllables: " + countingService.countPolySyllables(text.split(" ")) + "|";

    return words +
            sentences +
            characters +
            syllables +
            polySyllables;
  }

  public void printMsg(String msg) {
    System.out.println(msg);
  }
}
