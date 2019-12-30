package com.epam.training;

import java.util.Scanner;

public class Member {
    private String name;
    private int action;

    public Member(String name) {
        this.name = name;
    }

    public int inputAction() {
        action = 0;
        while (action != 1 && action != 2) {
            System.out.print(this.name + ", please write your action number(1 - Send message, 2 - Exit chat): ");
            Scanner s = new Scanner(System.in);
            action = s.nextInt();
        }
        return action;
    }

    public int getAction() {
        return action;
    }

    public void action(int action) {
        if (action == 1) {
            System.out.print("Type your message: ");
            Scanner t = new Scanner(System.in);
            String message = t.nextLine();
            System.out.println();
            Chat.updateHistory(name, message);
        } else {
            System.out.println("Ok, it's your choice.\n");
        }
    }
}