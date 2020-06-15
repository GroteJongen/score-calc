package com.Calculators;

import com.counter.CountingService;

public class AriIndexScore {

  public double calculateScore(String text) {
    if (text.isEmpty()) {
      return 0.0;
    }
    double characters = CountingService.countCharactersInText(text);
    double words = CountingService.countWordsInText(text);
    double sentences = CountingService.countSentencesInText(text);
    return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
  }
}
