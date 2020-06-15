package com.gui;

import com.Calculators.*;
import com.display.Messages;
import lombok.AllArgsConstructor;

import java.text.DecimalFormat;
@AllArgsConstructor
public class MsgCreationService {
  private ClassifyService classifyService;
  private CalculateContext calculateContext;
  private AriIndexScore ariIndexScore;
  private SmogScore smogScore;
  private FleschKincaidScore fleschKincaidScore;
  private ColemanScore colemanScore;

  private double getAriAge(String text) {
    calculateContext.setCalculateStrategy(ariIndexScore);
    return classifyService.classify(
        Messages.ARI_METHOD_NAME, calculateContext.calculateScore(text));
  }

  private double getClAge(String text) {
    calculateContext.setCalculateStrategy(colemanScore);
    return classifyService.classify(Messages.CL_METHOD_NAME, calculateContext.calculateScore(text));
  }

  private double getSmogAge(String text) {
    calculateContext.setCalculateStrategy(smogScore);
    return classifyService.classify(
        Messages.SMOG_METHOD_NAME, calculateContext.calculateScore(text));
  }

  private double getFkAge(String text) {
    calculateContext.setCalculateStrategy(fleschKincaidScore);
    return classifyService.classify(Messages.FK_METHOD_NAME, calculateContext.calculateScore(text));
  }

  String prepareMsg(String text) {
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    final String yearsMsg = " years old";
    final String rowSplitter = " | ";
    calculateContext.setCalculateStrategy(ariIndexScore);
    String ariResult =
        GuiMessages.ARI_MSG
            + decimalFormat.format(calculateContext.calculateScore(text))
            + rowSplitter
            + getAriAge(text)
            + yearsMsg;
    calculateContext.setCalculateStrategy(fleschKincaidScore);
    String fkResult =
        GuiMessages.FK_MSG
            + decimalFormat.format(calculateContext.calculateScore(text))
            + rowSplitter
            + getFkAge(text)
            + yearsMsg;
    calculateContext.setCalculateStrategy(smogScore);
    String smogResult =
        GuiMessages.SMOG_MSG
            + decimalFormat.format(
                calculateContext.calculateScore(text))
            + rowSplitter
            + getSmogAge(text)
            + yearsMsg;
    calculateContext.setCalculateStrategy(colemanScore);
    String clResult =
        GuiMessages.COLEMAN_MSG
            + decimalFormat.format(calculateContext.calculateScore(text))
            + rowSplitter
            + getClAge(text)
            + yearsMsg;

    return ariResult + rowSplitter + fkResult + rowSplitter + smogResult + rowSplitter + clResult;
  }
}
