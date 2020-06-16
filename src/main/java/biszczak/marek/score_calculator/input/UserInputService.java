package biszczak.marek.score_calculator.input;

import java.util.Scanner;

public class UserInputService {

    public String getInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
