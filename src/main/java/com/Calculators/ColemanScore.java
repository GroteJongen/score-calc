package com.Calculators;

import com.counter.CountingService;

public class ColemanScore {

  public double calculateScore(String text) {
    double characters = CountingService.countCharactersInText(text);
    double words = CountingService.countWordsInText(text);
    double sentences = CountingService.countSentencesInText(text);
    double l = characters / words * 100;
    double s = sentences / words * 100;
    return (0.0588 * l) - 0.296 * s - 15.8;
  }
}
