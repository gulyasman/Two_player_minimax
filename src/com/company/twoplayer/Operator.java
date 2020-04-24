package com.company.twoplayer;

public class Operator {
    private int i, j;
    private int player;

    public Operator(){

    }

    public Operator(int i, int j, int player) {
        this.i = i;
        this.j = j;
        this.player = player;
    }

    public boolean alkalmazhato(State state) {
        return state.getA()[i][j] == 0 && state.getPlayer() == player;
    }

    public State lerak(State state) {
        State resultState = new State(state.getA(),player);

        resultState.setAbyIndex(i, j, player);
        if(player == 1){
            resultState.setPlayer(2);
        }else{
            resultState.setPlayer(1);
        }

        return resultState;

    }

    @Override
    public String toString() {
        return "Operator{" +
                "i=" + i +
                ", j=" + j +
                ", player=" + player +
                '}';
    }
}
