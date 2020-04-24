package com.company.twoplayer;

import java.util.Scanner;

public class PlayerVsMinimax {
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
            Operator operator = new Operator();
            state.writeState();
            System.out.println(state.heuristics());
            if(state.getPlayer() == 1) {
                operator = Minimax.minimaxLepes(state, 3);
            }
            else if(state.getPlayer() == 2){
                System.out.println("Adja meg x,y koordinatakat: ");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
                operator = new Operator(x,y,state.getPlayer());
            }

            state = operator.lerak(state);
        }
        System.out.println("Player "+state.getPlayer()+" nyert!");
    }
}
