package com.display;

import static com.counter.CountingService.*;

public class ParameterService {

    public Parameters createParametersFromText(String text){
       return new Parameters.ParametersBuilder()
               .charactersCount(countCharactersInText(text))
               .polySyllableCount(countPolySyllables(text))
               .wordsCount(countWordsInText(text))
               .syllablesCount(countSyllables(text))
               .sentencesCount(countSentencesInText(text))
               .build();
    }
}
