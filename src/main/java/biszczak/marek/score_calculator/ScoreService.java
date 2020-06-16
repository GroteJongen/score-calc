package biszczak.marek.score_calculator;

import lombok.AllArgsConstructor;
import biszczak.marek.score_calculator.calculators.AriIndexScore;
import biszczak.marek.score_calculator.calculators.ColemanScore;
import biszczak.marek.score_calculator.calculators.FleschKincaidScore;
import biszczak.marek.score_calculator.calculators.SmogScore;

@AllArgsConstructor
public class ScoreService {
  private SmogScore smogScore;
  private FleschKincaidScore fleschKincaidScore;
  private ColemanScore colemanScore;
  private AriIndexScore ariIndexScore;

  public Score calculateScoresFromText(String text) {
    return new Score.ScoreBuilder()
        .ariScore(ariIndexScore.calculateScore(text))
        .clScore(colemanScore.calculateScore(text))
        .fkScore(fleschKincaidScore.calculateScore(text))
        .smogScore(smogScore.calculateScore(text))
        .build();
  }
}
