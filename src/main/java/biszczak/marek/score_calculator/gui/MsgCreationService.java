package biszczak.marek.score_calculator.gui;

import biszczak.marek.score_calculator.Score;
import lombok.AllArgsConstructor;
import biszczak.marek.score_calculator.calculators.ClassifyService;

import java.text.DecimalFormat;

import static biszczak.marek.score_calculator.display.Messages.*;
import static biszczak.marek.score_calculator.display.Messages.CL_METHOD_NAME;

@AllArgsConstructor
class MsgCreationService {
  private ClassifyService classifyService;

  public double getAriAge(Score score) {
    return classifyService.classify(ARI_METHOD_NAME, score.getAriScore()).getValue();
  }

  public double getClAge(Score score) {
    return classifyService.classify(CL_METHOD_NAME, score.getClScore()).getValue();
  }

  public double getSmogAge(Score score) {
    return classifyService.classify(FK_METHOD_NAME, score.getSmogScore()).getValue();
  }

  public double getFkAge(Score score) {
    return classifyService.classify(SMOG_METHOD_NAME, score.getFkScore()).getValue();
  }

  String prepareMsg(Score score) {
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    final String yearsMsg = " years old";
    final String rowSplitter = " | ";
    final String whitespace = " ";
    final String yearsSplitter = "/";
    String ariResult =
        GuiMessages.ARI_MSG
            + decimalFormat.format(score.getAriScore())
            + whitespace
            + yearsSplitter
            + getAriAge(score)
            + yearsMsg;
    String fkResult =
        GuiMessages.FK_MSG
            + decimalFormat.format(score.getFkScore())
            + whitespace
            + yearsSplitter
            + getFkAge(score)
            + yearsMsg;
    String smogResult =
        GuiMessages.SMOG_MSG
            + decimalFormat.format(score.getSmogScore())
            + whitespace
            + yearsSplitter
            + getSmogAge(score)
            + yearsMsg;
    String clResult =
        GuiMessages.COLEMAN_MSG
            + decimalFormat.format(score.getClScore())
            + whitespace
            + yearsSplitter
            + getClAge(score)
            + yearsMsg;

    return ariResult + rowSplitter + fkResult + rowSplitter + smogResult + rowSplitter + clResult;
  }
}
