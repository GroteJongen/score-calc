package com.Calculators;

import com.counter.CountingService;

public class FleschKincaidScore {

  public double calculateScore(String text) {
    double words = CountingService.countWordsInText(text);
    double sentences = CountingService.countSentencesInText(text);
    double syllables = CountingService.countSyllables(text);
    return 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
  }
}
