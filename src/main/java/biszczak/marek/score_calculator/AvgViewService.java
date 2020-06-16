package biszczak.marek.score_calculator;

import biszczak.marek.score_calculator.calculators.ClassifyService;
import biszczak.marek.score_calculator.display.Messages;
import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
class AvgViewService {
  ClassifyService classifyService;

  AvgView createFromScore(Score score) {
    double ariAge = classifyService.classify(Messages.ARI_METHOD_NAME, score.getAriScore()).getValue();

    double fkAge = classifyService.classify(Messages.FK_METHOD_NAME, score.getFkScore()).getValue();

    double smogAge = classifyService.classify(Messages.SMOG_METHOD_NAME, score.getSmogScore()).getValue();

    double clAge = classifyService.classify(Messages.CL_METHOD_NAME, score.getClScore()).getValue();

    double avg =
        Stream.of(ariAge, fkAge, smogAge, clAge)
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);

    return new AvgView(ariAge, fkAge, smogAge, clAge, avg);
  }
}
