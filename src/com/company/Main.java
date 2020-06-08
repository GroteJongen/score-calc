package com.company;

import java.util.Arrays;

public class Main {
    private static final String ARI_METHOD_NAME = "Automated Readability Index: ";
    private static final String FK_METHOD_NAME = "Flesch–Kincaid readability tests: ";
    private static final String SMOG_METHOD_NAME = "Simple Measure of Gobbledygook: ";
    private static final String CL_METHOD_NAME = "Coleman–Liau index: ";

    public static void main(String[] args) {
        CountingService countingService = new CountingService();
        CalculateService calculateService = new CalculateService(countingService);
        DisplayService displayService = new DisplayService(countingService);
        FileReaderService fileReaderService = new FileReaderService();
        FormatterService formatterService = new FormatterService();
        UserInputService userInputService = new UserInputService();
        ClassifyService classifyService = new ClassifyService();


        System.out.println("The text is: ");
        String formattedText = formatterService.formatText(userInputService.getInputFromUser());
        displayService.printAllParametersOfText(formattedText);

        double score = calculateService.calculateScore(formattedText);
        double fkScore = calculateService.fleshKincaidMethod(formattedText);
        double smogScore = calculateService.smogMethod(formattedText, formattedText.split(" "));
        double clScore = calculateService.colemanMethod(formattedText);

        String method = userInputService.getInputFromUser();
        switch (method) {
            case "ARI":
                classifyService.classify(ARI_METHOD_NAME, score);
                break;
            case "FK":
                classifyService.classify(FK_METHOD_NAME, fkScore);
                break;
            case "SMOG":
                classifyService.classify(SMOG_METHOD_NAME, smogScore);
                break;
            case "CL":
                classifyService.classify(CL_METHOD_NAME, clScore);
                break;
            case "ALL":
                double ariAge = classifyService.classify(ARI_METHOD_NAME, score);
                double fkAge = classifyService.classify(FK_METHOD_NAME, fkScore);
                double smogAge = classifyService.classify(SMOG_METHOD_NAME, smogScore);
                double clAge = classifyService.classify(CL_METHOD_NAME, clScore);
                double[] results = new double[]{ariAge, fkAge, smogAge, clAge};
                double avg = Arrays.stream(results).average().orElse(Double.NaN);
                System.out.println("This text should be understood in average by " + avg + " year olds");
        }
    }
}
