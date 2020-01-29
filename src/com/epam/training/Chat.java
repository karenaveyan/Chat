package com.epam.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static String history = "";

    public static void createChat() {
        System.out.print("Enter the count of chat members: ");
        Scanner inCount = new Scanner(System.in);
        int n = inCount.nextInt();
        System.out.println();

        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Please enter your name Member " + (i + 1) + ": ");
            Scanner inName = new Scanner(System.in);
            members[i] = new Member(inName.nextLine());
        }
        System.out.println();

        ArrayList<Member> activeMembers = new ArrayList<Member>();
        for (int i = 0; i < n; i++) {
            activeMembers.add(members[i]);
        }

        Random r = new Random(members.length);
        while (activeMembers.size() != 0) {
            int i = r.nextInt(activeMembers.size());
            Member current = activeMembers.get(i);
            current.inputAction();
            current.action();
            if (current.getAction() == Action.EXIT) {
                activeMembers.remove(i);
            }
        }
    }

    public static void updateHistory(String name, String message) {
        LocalDateTime date = LocalDateTime.now();
        history += dtf.format(date) + " (date) " + name + ": " + message + "\n";
    }

    public static void printHistory() {
        if (history.equals("")) {
            System.out.println("Chat history.\nThe chat is empty...");
        } else {
            System.out.println("Chat history.\n" + history);
        }
    }
}
