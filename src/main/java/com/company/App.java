package com.company;

import com.Calculators.*;
import com.display.DisplayService;
import com.display.Messages;
import com.display.ParameterService;
import com.input.FileReaderService;
import com.input.FormatterService;
import com.input.UserInputService;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
public class App {
  private DisplayService displayService;
  private FileReaderService fileReaderService;
  private FormatterService formatterService;
  private UserInputService userInputService;
  private ClassifyService classifyService;
  private CalculateContext calculateContext;
  private AriIndexScore ariIndexScore;
  private ParameterService parameterService;
  private SmogScore smogScore;
  private FleschKincaidScore fleschKincaidScore;
  private ColemanScore colemanScore;
  private ScoreService scoreService;

  public void runApp() {
    String formattedString =
        formatterService.formatText(Objects.requireNonNull(getStringFromConsoleOrFile()));
    displayService.printAllParametersOfText(
        parameterService.createParametersFromText(formattedString));
    Score score = scoreService.calculateScoresFromText(formattedString);
    displayService.printMsg(Messages.CHOICE_MSG);
    String method = userInputService.getInputFromUser();
    switch (method) {
      case "ARI":
        calculateContext.setCalculateStrategy(ariIndexScore);
        classifyService.classify(
            Messages.ARI_METHOD_NAME, score.getAriScore());
        break;
      case "FK":
        calculateContext.setCalculateStrategy(fleschKincaidScore);
        classifyService.classify(
            Messages.FK_METHOD_NAME,score.getFkScore());
        break;
      case "SMOG":
        calculateContext.setCalculateStrategy(smogScore);
        classifyService.classify(
            Messages.SMOG_METHOD_NAME, score.getSmogScore());
        break;
      case "CL":
        calculateContext.setCalculateStrategy(colemanScore);
        classifyService.classify(
            Messages.CL_METHOD_NAME,score.getClScore());
        break;
      case "ALL":
        printAvgAge(formattedString);
        break;
      default:
        displayService.printMsg(Messages.NO_METHOD_CHOSEN);
    }
  }

  private void printAvgAge(String text) {
    calculateContext.setCalculateStrategy(ariIndexScore);
    double ariAge =
        classifyService.classify(Messages.ARI_METHOD_NAME, calculateContext.calculateScore(text));
    calculateContext.setCalculateStrategy(fleschKincaidScore);
    double fkAge =
        classifyService.classify(Messages.FK_METHOD_NAME, calculateContext.calculateScore(text));
    calculateContext.setCalculateStrategy(smogScore);
    double smogAge =
        classifyService.classify(Messages.SMOG_METHOD_NAME, calculateContext.calculateScore(text));
    calculateContext.setCalculateStrategy(colemanScore);
    double clAge =
        classifyService.classify(Messages.CL_METHOD_NAME, calculateContext.calculateScore(text));
    double[] results = new double[] {ariAge, fkAge, smogAge, clAge};
    double avg = Arrays.stream(results).average().orElse(Double.NaN);
    System.out.println("This text should be understood in average by " + avg + " year olds");
  }

  private String getStringFromConsoleOrFile() {
    final String initialMsg = "Put 1 for console input. Put 2 for fileInput";
    final String consoleInputMsg = "Put text in";
    final String fileInputMsg = "Put input name in";
    while (true) {
      displayService.printMsg(initialMsg);
      String choice = userInputService.getInputFromUser();
      switch (choice) {
        case "1":
        case "console":
          displayService.printMsg(consoleInputMsg);
          return userInputService.getInputFromUser();
        case "2":
        case "input":
          displayService.printMsg(fileInputMsg);
          return fileReaderService.readFromFile(userInputService.getInputFromUser());
      }
    }
  }
}
