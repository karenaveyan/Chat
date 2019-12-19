package com.epam.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Member {
    private int action;
    private String name;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static String history = "";

    public Member(String name) {
        this.name = name;
    }

    public int inputAction() {
        Scanner s = new Scanner(System.in);
        while (action != 1 && action != 2) {
            System.out.print(name + ", please write your action number(1 - Send message, 2 - Exit chat): ");
            action = s.nextInt();
        }
        return action;
    }

    public void action(int action) {
        if (action == 1) {
            System.out.print("Type your message: ");
            Scanner t = new Scanner(System.in);
            String message = t.nextLine();
            System.out.println();
            LocalDateTime date = LocalDateTime.now();
            history += dtf.format(date) + " (date) " + name + ": " + message + "\n";
        } else {
            System.out.println("Ok, it's your choice.\n");
        }
    }

    public static void printHistory() {
        System.out.println("Chat history.\n"+history);
    }
}