package biszczak.marek.score_calculator;

import biszczak.marek.score_calculator.calculators.ClassifyService;
import biszczak.marek.score_calculator.display.DisplayService;
import biszczak.marek.score_calculator.display.ParameterService;
import biszczak.marek.score_calculator.display.Parameters;
import biszczak.marek.score_calculator.input.FormatterService;
import biszczak.marek.score_calculator.input.UserInputService;
import lombok.AllArgsConstructor;

import java.text.DecimalFormat;

import static biszczak.marek.score_calculator.display.Messages.*;

@AllArgsConstructor
class App {
  private DisplayService displayService;
  private FormatterService formatterService;
  private UserInputService userInputService;
  private ClassifyService classifyService;
  private ParameterService parameterService;
  private ScoreService scoreService;
  private AvgViewService avgViewService;

  void runApp() {
    String formattedString = formatterService.formatText(userInputService.getInputFromUser());
    displayService.printAllParametersOfText(parameterService.createParametersFromText(formattedString));
    Score score = scoreService.calculateScoresFromText(formattedString);
    Parameters parameter = parameterService.createParametersFromText(formattedString);
    System.out.println(displayService.printAllParametersOfText(parameter));
    displayService.printMsg(CHOICE_MSG);
    String method = userInputService.getInputFromUser();
    switch (method) {
      case "ARI":
        printAriMsg(score);
        break;
      case "FK":
        printFkMsg(score);
        break;
      case "SMOG":
        printSmogMsg(score);
        break;
      case "CL":
        printColemanMsg(score);
        break;
      case "ALL":
        printAvgAge(score);
        break;
      default:
        displayService.printMsg(NO_METHOD_CHOSEN);
    }
  }

  private void printAvgAge(Score score) {
    AvgView avgView = avgViewService.createFromScore(score);
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    String msg =
        String.format(
            "This text should be understood in average by %s years old",
            decimalFormat.format(avgView.getAverage()));
    displayService.printMsg(msg);
  }

  private void printAriMsg(Score score) {
    System.out.println(
        RESULT_MSG
            + classifyService.classify(ARI_METHOD_NAME, score.getAriScore()).getValue()
            + YEARS_OLD_MSG);
  }

  private void printFkMsg(Score score) {
    System.out.println(
        RESULT_MSG
            + classifyService.classify(FK_METHOD_NAME, score.getFkScore()).getValue()
            + YEARS_OLD_MSG);
  }

  private void printSmogMsg(Score score) {
    System.out.println(
       RESULT_MSG +
            + classifyService.classify(SMOG_METHOD_NAME, score.getSmogScore()).getValue()
            + YEARS_OLD_MSG);
  }

  private void printColemanMsg(Score score) {
    System.out.println(
        RESULT_MSG
            + classifyService.classify(CL_METHOD_NAME, score.getClScore()).getValue()
            + YEARS_OLD_MSG);
  }
}
