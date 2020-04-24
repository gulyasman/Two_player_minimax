package com.company.twoplayer;

import java.util.Scanner;

public class PlayerVsPlayer {
    public static int[][] a = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static Scanner scanner = new Scanner(System.in);

    public static void play(){

        int player = 1,x,y;
        State state = new State(a,player);

        while (state.celState() != 1 && state.celState() != 2){
            state.writeState();
            System.out.println("Heurisztika: "+state.heuristics());
            System.out.println("Adja meg x,y koordinatakat: ");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;
            Operator operator = new Operator(x,y,state.getPlayer());

            state = operator.lerak(state);
        }
        System.out.println("Player "+state.getPlayer()+" nyert!");
    }
}
