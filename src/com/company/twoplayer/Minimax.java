package com.company.twoplayer;

import java.util.ArrayList;
import java.util.List;

public class Minimax {

    public static List<Operator> operators = new ArrayList<>();

    static{
        for(int i = 0; i < 10; i ++){
            for (int j = 0; j < 10; j ++){
                operators.add(new Operator(i,j,1));
                operators.add(new Operator(i,j,2));
            }
        }
    }

    public static int minimaxErtek(State state,int melyseg){

        if(state.celState() == 1 || state.celState() == 2 || melyseg == 0){
            return state.heuristics();
        }

        else if(state.getPlayer() == 1){
            int max = -1111;
            for(Operator operator : operators){
                if(operator.alkalmazhato(state)){
                    State newState = operator.lerak(state);
                    int v = minimaxErtek(newState,melyseg-1);
                    if(v > max){
                        max = v;
                    }
                }
            }
            return max;
        }
        else {
            int min = 1111;
            for(Operator operator : operators){
                if(operator.alkalmazhato(state)){
                    State newState = operator.lerak(state);
                    int v = minimaxErtek(newState,melyseg-1);
                    if(v < min){
                        min = v;
                    }
                }
            }
            return min;
        }
    }

    public static Operator minimaxLepes(State state,int korlat){

        int max = -1111;
        Operator resultOperator = new Operator();

        for(Operator operator:operators){
            if(operator.alkalmazhato(state)){
                State newState = operator.lerak(state);
                int v = minimaxErtek(newState,korlat-1);
                if(v > max){
                    max = v;
                    resultOperator = operator;
                }
            }
        }

        return resultOperator;
    }
}
