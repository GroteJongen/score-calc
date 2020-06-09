package com.display;

import com.counter.CountingService;

public class DisplayService {
    private CountingService countingService;

    public DisplayService(CountingService countingService) {
        this.countingService = countingService;
    }

    public void printAllParametersOfText(String text) {
        System.out.println("Words: " + countingService.countWordsInText(text));
        System.out.println("Sentences: " + countingService.countSentencesInText(text));
        System.out.println("Characters: " + countingService.countCharactersInText(text));
        System.out.println("Syllables: " + countingService.countSyllables(text));
        System.out.println("Polysyllables: " + countingService.countPolySyllables(text.split(" ")));
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
