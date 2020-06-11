package com.company;

import com.Calculators.CalculateService;
import com.Calculators.ClassifyService;
import com.counter.CountingService;
import com.display.DisplayService;
import com.display.Messages;
import com.gui.WelcomeScreen;
import com.input.FileReaderService;
import com.input.FormatterService;
import com.input.UserInputService;

import java.util.Arrays;
import java.util.Objects;

public class App {
    private CalculateService calculateService;
    private DisplayService displayService;
    private FileReaderService fileReaderService;
    private FormatterService formatterService;
    private UserInputService userInputService;
    private ClassifyService classifyService;

    public App(CountingService countingService, CalculateService calculateService,
               DisplayService displayService, FileReaderService fileReaderService,
               FormatterService formatterService, UserInputService userInputService,
               ClassifyService classifyService) {
        this.calculateService = calculateService;
        this.displayService = displayService;
        this.fileReaderService = fileReaderService;
        this.formatterService = formatterService;
        this.userInputService = userInputService;
        this.classifyService = classifyService;
    }

    public void runApp() {
        String formattedString = formatterService.formatText(Objects.requireNonNull(getStringFromConsoleOrFile()));
        displayService.printAllParametersOfText(formattedString);
        displayService.printMsg(Messages.CHOICE_MSG);
        String method = userInputService.getInputFromUser();
        switch (method) {
            case "ARI":
                classifyService.classify(Messages.ARI_METHOD_NAME, calculateService.calculateScore(formattedString));
                break;
            case "FK":
                classifyService.classify(Messages.FK_METHOD_NAME, calculateService.fleshKincaidMethod(formattedString));
                break;
            case "SMOG":
                classifyService.classify(Messages.SMOG_METHOD_NAME, calculateService.smogMethod(formattedString, formattedString.split(" ")));
                break;
            case "CL":
                classifyService.classify(Messages.CL_METHOD_NAME, calculateService.colemanMethod(formattedString));
                break;
            case "ALL":
                printAllNecessaryParameters(formattedString);
                break;
            default:
                displayService.printMsg(Messages.NO_METHOD_CHOSEN);
        }
    }

    private void printAllNecessaryParameters(String text) {
        double ariAge = classifyService.classify(Messages.ARI_METHOD_NAME, calculateService.calculateScore(text));
        double fkAge = classifyService.classify(Messages.FK_METHOD_NAME, calculateService.fleshKincaidMethod(text));
        double smogAge = classifyService.classify(Messages.SMOG_METHOD_NAME, calculateService.smogMethod(text, text.split(" ")));
        double clAge = classifyService.classify(Messages.CL_METHOD_NAME, calculateService.calculateScore(text));
        double[] results = new double[]{ariAge, fkAge, smogAge, clAge};
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
