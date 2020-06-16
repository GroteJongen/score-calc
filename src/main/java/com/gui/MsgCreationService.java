package com.gui;

import com.Calculators.*;
import com.company.Score;
import lombok.AllArgsConstructor;

import java.text.DecimalFormat;

import static com.display.Messages.*;
import static com.display.Messages.CL_METHOD_NAME;

@AllArgsConstructor
public class MsgCreationService {
  private ClassifyService classifyService;

  private double getAriAge(Score score) {
    return classifyService.classify(ARI_METHOD_NAME, score.getAriScore()).getValue();
  }

  private double getClAge(Score score) {
    return classifyService.classify(CL_METHOD_NAME, score.getClScore()).getValue();
  }

  private double getSmogAge(Score score) {
    return classifyService.classify(FK_METHOD_NAME, score.getSmogScore()).getValue();
  }

  private double getFkAge(Score score) {
    return classifyService.classify(SMOG_METHOD_NAME, score.getFkScore()).getValue();
  }

  String prepareMsg(Score score) {
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    final String yearsMsg = " years old";
    final String rowSplitter = " | ";
    final String whitespace = " ";
    String ariResult =
        GuiMessages.ARI_MSG
            + decimalFormat.format(score.getAriScore())
            + whitespace
            + getAriAge(score)
            + yearsMsg;
    String fkResult =
        GuiMessages.FK_MSG
            + decimalFormat.format(score.getFkScore())
            + whitespace
            + getFkAge(score)
            + yearsMsg;
    String smogResult =
        GuiMessages.SMOG_MSG
            + decimalFormat.format(score.getSmogScore())
            + whitespace
            + getSmogAge(score)
            + yearsMsg;
    String clResult =
        GuiMessages.COLEMAN_MSG
            + decimalFormat.format(score.getClScore())
            + whitespace
            + getClAge(score)
            + yearsMsg;

    return ariResult + rowSplitter + fkResult + rowSplitter + smogResult + rowSplitter + clResult;
  }
}
