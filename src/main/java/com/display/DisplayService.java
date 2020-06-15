package com.display;
import static com.counter.CountingService.*;

public class DisplayService {
  //TODO convert variables to string format.
  //TODO Create Parameters class containing logic for counting words in text
  public String printAllParametersOfText(Parameters parameters) {
    String words = " Words: " + parameters.getWordsCount() + "|";
    String sentences = " Sentences: " + parameters.getSentencesCount() + "|";
    String characters = " Characters: " + parameters.getCharactersCount() + "|";
    String syllables = " Syllables: " + parameters.getSyllablesCount() + "|";
    String polySyllables =
        " Polysyllables: " + parameters.getPolySyllableCount() + "|";

    return words + sentences + characters + syllables + polySyllables;
  }
  public void printMsg(String msg) {
    System.out.println(msg);
  }
}
