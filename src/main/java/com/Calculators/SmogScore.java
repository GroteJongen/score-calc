package com.Calculators;

import com.counter.CountingService;

public class SmogScore {

  public double calculateScore(String text) {
    double sentences = CountingService.countSentencesInText(text);
    return 1.043 * Math.sqrt(CountingService.countPolySyllables(text) * (30 / sentences)) + 3.1291;
  }
}
