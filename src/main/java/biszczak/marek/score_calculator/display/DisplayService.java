package biszczak.marek.score_calculator.display;

public class DisplayService {
  public String printAllParametersOfText(Parameters parameters) {
    String words = " Words: " + parameters.getWordsCount() + "|";
    String sentences = " Sentences: " + parameters.getSentencesCount() + "|";
    String characters = " Characters: " + parameters.getCharactersCount() + "|";
    String syllables = " Syllables: " + parameters.getSyllablesCount() + "|";
    String polySyllables =
        " Polysyllables: " + parameters.getPolySyllableCount() + "|";

    return words + sentences + characters + syllables + polySyllables;
  }
  public void printMsg(String msg) {
    System.out.printf(msg + "\n");
  }
}
