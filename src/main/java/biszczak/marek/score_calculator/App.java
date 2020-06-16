package biszczak.marek.score_calculator;

import biszczak.marek.score_calculator.calculators.ClassifyService;
import biszczak.marek.score_calculator.display.DisplayService;
import biszczak.marek.score_calculator.display.Messages;
import biszczak.marek.score_calculator.display.ParameterService;
import biszczak.marek.score_calculator.input.FormatterService;
import biszczak.marek.score_calculator.input.UserInputService;
import lombok.AllArgsConstructor;

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
    displayService.printMsg(Messages.CHOICE_MSG);
    String method = userInputService.getInputFromUser();
    switch (method) {
      case "ARI":
        classifyService.classify(Messages.ARI_METHOD_NAME, score.getAriScore());
        break;
      case "FK":
        classifyService.classify(Messages.FK_METHOD_NAME, score.getFkScore());
        break;
      case "SMOG":
        classifyService.classify(Messages.SMOG_METHOD_NAME, score.getSmogScore());
        break;
      case "CL":
        classifyService.classify(Messages.CL_METHOD_NAME, score.getClScore());
        break;
      case "ALL":
        printAvgAge(score);
        break;
      default:
        displayService.printMsg(Messages.NO_METHOD_CHOSEN);
    }
  }

  private void printAvgAge(Score score) {
    AvgView avgView = avgViewService.createFromScore(score);
    String msg = String.format("This text should be understood in average by %f years old", avgView.getAverage());
    displayService.printMsg(msg);
  }
}
