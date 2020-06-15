package com.company;

import com.Calculators.*;
import com.counter.CountingService;
import com.display.DisplayService;
import com.gui.WelcomeScreen;
import com.input.FileReaderService;
import com.input.FormatterService;
import com.input.UserInputService;

public class Main {

  public static void main(String[] args) {

    CountingService countingService = new CountingService();
    DisplayService displayService = new DisplayService(countingService);
    FormatterService formatterService = new FormatterService();
    FileReaderService fileReaderService = new FileReaderService(formatterService);
    UserInputService userInputService = new UserInputService();
    ClassifyService classifyService = new ClassifyService();
    AriIndexScore ariIndexScore = new AriIndexScore();
    SmogScore smogScore = new SmogScore();
    ColemanScore colemanScore = new ColemanScore();
    FleschKincaidScore fleschKincaidScore = new FleschKincaidScore();
    CalculateContext calculateContext = new CalculateContext();
    App app =
        new App(
            displayService,
            fileReaderService,
            formatterService,
            userInputService,
            classifyService,
            calculateContext,
            ariIndexScore,
            smogScore,
            fleschKincaidScore,
            colemanScore);
     //app.runApp();
     WelcomeScreen welcomeScreen = new WelcomeScreen();
  }
}
