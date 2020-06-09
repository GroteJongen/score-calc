package com.company;

import com.Calculators.CalculateService;
import com.Calculators.ClassifyService;
import com.counter.CountingService;
import com.display.DisplayService;
import com.input.FileReaderService;
import com.input.FormatterService;
import com.input.UserInputService;

public class Main {
    public static void main(String[] args) {

        CountingService countingService = new CountingService();
        CalculateService calculateService = new CalculateService(countingService);
        DisplayService displayService = new DisplayService(countingService);
        FileReaderService fileReaderService = new FileReaderService();
        FormatterService formatterService = new FormatterService();
        UserInputService userInputService = new UserInputService();
        ClassifyService classifyService = new ClassifyService();
        App app = new App(countingService, calculateService, displayService, fileReaderService, formatterService, userInputService, classifyService);
        app.runApp();
        
    }

}
