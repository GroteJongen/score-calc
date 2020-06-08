package com.company;

public class CalculateService {
    CountingService countingService;

    public CalculateService(CountingService countingService) {
        this.countingService = countingService;
    }

    public double calculateScore(String text) {
        if (text.isEmpty()) {
            return 0.0;
        }
        double characters = countingService.countCharactersInText(text);
        double words = countingService.countWordsInText(text);
        double sentences = countingService.countSentencesInText(text);
        return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
    }

    public  double fleshKincaidMethod(String text) {
        double words = countingService.countWordsInText(text);
        double sentences = countingService.countSentencesInText(text);
        double syllables = countingService.countSyllables(text);
        return 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
    }

    public  double smogMethod(String text, String[] worden) {
        double sentences = countingService.countSentencesInText(text);
        return 1.043 * Math.sqrt(countingService.countPolySyllables(worden) * (30 / sentences)) + 3.1291;
    }

    public  double colemanMethod(String text) {
        double characters = countingService.countCharactersInText(text);
        double words = countingService.countWordsInText(text);
        double sentences = countingService.countSentencesInText(text);
        double l = characters / words * 100;
        double s = sentences / words * 100;
        return (0.0588 * l) - 0.296 * s - 15.8;
    }

}
