package biszczak.marek.score_calculator.calculators;

import static biszczak.marek.score_calculator.counter.CountingService.*;

public class SmogScore {

  public double calculateScore(String text) {
    double sentences = countSentencesInText(text);
    final double s = 30 / sentences;
    final int polySyllables = countPolySyllables(text);

    return calculateByFormula(s, polySyllables);
  }

  private double calculateByFormula(double s, int polySyllables) {
    return 1.043 * Math.sqrt(polySyllables * s) + 3.1291;
  }
}
