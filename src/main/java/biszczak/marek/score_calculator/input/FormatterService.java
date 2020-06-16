package biszczak.marek.score_calculator.input;

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

