package ru.trandefil.sc.service;

import java.util.Scanner;

public class TerminalService {

    private Scanner scanner;

    public TerminalService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

}
