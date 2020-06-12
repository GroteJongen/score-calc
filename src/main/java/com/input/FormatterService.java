package com.input;

public class FormatterService {
    public String formatText(String text) {
        return text
                .replace(":", "")
                .replace("!", ".")
                .replace("?", ".")
                .replace("\n", "")
                .replace("\t", "")
                .trim();
    }
}
