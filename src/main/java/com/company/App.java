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

import static com.display.Messages.*;

@AllArgsConstructor
public class App {
  private DisplayService displayService;
  private FileReaderService fileReaderService;
  private FormatterService formatterService;
  private UserInputService userInputService;
  private ClassifyService classifyService;
  private AriIndexScore ariIndexScore;
  private ParameterService parameterService;
  private SmogScore smogScore;
  private FleschKincaidScore fleschKincaidScore;
  private ColemanScore colemanScore;
  private ScoreService scoreService;

  void runApp() {
    String formattedString =
        formatterService.formatText(Objects.requireNonNull(getStringFromConsoleOrFile()));
    displayService.printAllParametersOfText(
        parameterService.createParametersFromText(formattedString));
    Score score = scoreService.calculateScoresFromText(formattedString);
    displayService.printMsg(CHOICE_MSG);
    String method = userInputService.getInputFromUser();
    switch (method) {
      case "ARI":
        classifyService.classify(ARI_METHOD_NAME, score.getAriScore());
        break;
      case "FK":
        classifyService.classify(FK_METHOD_NAME, score.getFkScore());
        break;
      case "SMOG":
        classifyService.classify(SMOG_METHOD_NAME, score.getSmogScore());
        break;
      case "CL":
        classifyService.classify(CL_METHOD_NAME, score.getClScore());
        break;
      case "ALL":
        printAvgAge(score);
        break;
      default:
        displayService.printMsg(NO_METHOD_CHOSEN);
    }
  }

  private void printAvgAge(Score score) {
    double ariAge = classifyService.classify(ARI_METHOD_NAME, score.getAriScore()).getValue();
    double fkAge = classifyService.classify(FK_METHOD_NAME, score.getFkScore()).getValue();
    double smogAge = classifyService.classify(SMOG_METHOD_NAME, score.getSmogScore()).getValue();
    double clAge = classifyService.classify(CL_METHOD_NAME, score.getClScore()).getValue();
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
