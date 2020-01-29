package com.epam.training;

import java.util.Scanner;

public class Member {
    private String name;
    private Action action;

    public Member(String name) {
        this.name = name;
    }

    public Action inputAction() {
        while (true) {
            System.out.print(this.name + ", please write your action number(1 - Send message, 2 - Exit chat): ");
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            if (input == 1) {
                action = Action.WRITE;
                return action;
            }
            if (input == 2) {
                action = Action.EXIT;
                return action;
            }
        }
    }

    public Action getAction() {
        return action;
    }

    public void action() {
        if (action == Action.WRITE) {
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