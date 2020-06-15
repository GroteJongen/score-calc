package com.Calculators;

import com.counter.CountingService;

public class SmogScore implements CalculateStrategy {


  public double calculateScore(String text) {
    final String splitter = " ";
    double sentences = CountingService.countSentencesInText(text);
    return 1.043 * Math.sqrt(CountingService.countPolySyllables(text.split(splitter)) * (30 / sentences))
        + 3.1291;
  }
}
