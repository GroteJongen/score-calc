package com.company;

import com.Calculators.*;
import com.display.DisplayService;
import com.display.ParameterService;
import com.gui.WelcomeScreen;
import com.input.FileReaderService;
import com.input.FormatterService;
import com.input.UserInputService;

public class Main {

  public static void main(String[] args) {

    DisplayService displayService = new DisplayService();
    FormatterService formatterService = new FormatterService();
    FileReaderService fileReaderService = new FileReaderService(formatterService);
    UserInputService userInputService = new UserInputService();
    ClassifyService classifyService = new ClassifyService();
    AriIndexScore ariIndexScore = new AriIndexScore();
    SmogScore smogScore = new SmogScore();
    ColemanScore colemanScore = new ColemanScore();
    FleschKincaidScore fleschKincaidScore = new FleschKincaidScore();
    CalculateContext calculateContext = new CalculateContext();
    ParameterService parameterService = new ParameterService();
    App app =
        new App(
            displayService,
            fileReaderService,
            formatterService,
            userInputService,
            classifyService,
            calculateContext,
            ariIndexScore,
            parameterService,
            smogScore,
            fleschKincaidScore,
            colemanScore);
    // app.runApp();
    WelcomeScreen welcomeScreen = new WelcomeScreen();
  }
}
