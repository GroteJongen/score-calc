package com.company;

import java.util.Scanner;

public class UserInputService {

    public String getInputFromUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
