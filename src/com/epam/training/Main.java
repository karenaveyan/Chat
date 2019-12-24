package com.epam.training;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the number of chat members: ");
        Scanner n = new Scanner(System.in);
        final int num = n.nextInt();
        System.out.println();
        ArrayList<Member> m = new ArrayList<Member>();
        for (int i = 0; i < num; i++) {
            System.out.print("Please enter your name Member " + (i + 1) + ": ");
            Scanner s = new Scanner(System.in);
            m.add(new Member(s.nextLine()));
        }
        System.out.println();
        Random r = new Random(m.size());
        while (m.size() != 0) {
            int i = r.nextInt(m.size());
            m.get(i).action(m.get(i).inputAction());
            if (m.get(i).getAction() == 2) {
                m.remove(i);
            }
        }
        Member.printHistory();
    }
}