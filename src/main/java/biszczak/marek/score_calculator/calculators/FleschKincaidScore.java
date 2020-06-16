package biszczak.marek.score_calculator.calculators;

import static biszczak.marek.score_calculator.counter.CountingService.*;

public class FleschKincaidScore {

  public double calculateScore(String text) {
    double words = countWordsInText(text);
    double sentences = countSentencesInText(text);
    double syllables = countSyllables(text);
    final double s = words / sentences;
    final double l = syllables / words;

    return calculateByFormula(s, l);
  }

  private double calculateByFormula(double s, double l) {
    return 0.39 * s + 11.8 * l - 15.59;
  }
}
