package com.epam.training;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Member[] m = new Member[3];
        for (int i = 0; i < m.length; i++) {
            System.out.print("Please enter your name: ");
            Scanner s = new Scanner(System.in);
            m[i] = new Member(s.nextLine());
            m[i].action(m[i].inputAction());
        }
        Member.printHistory();
    }
}
