package com.company;

import com.Calculators.*;
import lombok.AllArgsConstructor;

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
