package biszczak.marek.score_calculator.calculators;

import static biszczak.marek.score_calculator.counter.CountingService.*;

public class ColemanScore {

  public double calculateScore(String text) {
    double characters = countCharactersInText(text);
    double words = countWordsInText(text);
    double sentences = countSentencesInText(text);
    double l = characters / words * 100;
    double s = sentences / words * 100;

    return calculateByFormula(s, l);
  }

  private double calculateByFormula(double s, double l) {
    return (0.0588 * l) - 0.296 * s - 15.8;
  }
}
