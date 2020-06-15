package com.display;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
//MODEL
class Parameters {
    private final int wordsCount;
    private final int syllablesCount;
    private final int polySyllableCount;
    private final int sentencesCount;
    private final int charactersCount;



}
