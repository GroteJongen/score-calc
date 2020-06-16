package biszczak.marek.score_calculator.calculators;
import static biszczak.marek.score_calculator.counter.CountingService.*;

public class AriIndexScore {

  public double calculateScore(String text) {
    if (text.isEmpty()) {
      return 0.0;
    }
    double characters = countCharactersInText(text);
    double words = countWordsInText(text);
    double sentences = countSentencesInText(text);
    final double s = characters / words;
    final double l = words / sentences;

    return calculateByFormula(s,l);
  }
  private double calculateByFormula(double s, double l){
    return 4.71 * s + 0.5 * l - 21.43;
  }
}
