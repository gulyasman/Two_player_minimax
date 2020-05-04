package com.company.twoplayer;

import java.util.Arrays;

public class State {

    private int[][] a = new int[11][11];
    private int player;

    public State() {
    }

    public State(int[][] a,int player) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                this.a[i][j] = a[i][j];
            }
        }
        this.player = player;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setAbyIndex(int i, int j, int value) {
        this.a[i][j] = value;
    }

    public void writeState() {
        System.out.println("Lepni jön: "+player);
        for (int[] i : a) {
            for (int j : i) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    /**
     * Ha sorban kigyűlik az 1-es
     *
     * @return 2
     */
    public int celState() {
        for (int i = 0; i < 11; i++) {
            if (a[i][0] == 1 && a[i][1] == 1 && a[i][2] == 1 && a[i][3] == 1 && a[i][4] == 1 &&
                    a[i][5] == 1 && a[i][6] == 1 && a[i][7] == 1 && a[i][8] == 1 && a[i][9] == 1 && a[i][10] == 1) {
                return 1;
            }
            if (a[0][i] == 2 && a[1][i] == 2 && a[2][i] == 2 && a[3][i] == 2 && a[4][i] == 2 &&
                    a[5][i] == 2 && a[6][i] == 2 && a[7][i] == 2 && a[8][i] == 2 && a[9][i] == 2 && a[10][i] == 2) {
                return 2;
            }
        }
        return 0;
    }

    /**
     * A támogatott játékos szempontjábol heurisztika becslés (1-es számú játékos)
     */
    public int heuristics() {
        int currentplayer1max = 0, currentplayer2max = 0, player1max = 0, player2max = 0;
        boolean is2inrow, is1incolumn;
        for (int i = 0; i < 11; i++) {

            is2inrow = true;
            is1incolumn = true;
            currentplayer1max = 0;
            currentplayer2max = 0;

            for (int j = 0; j < 11; j++) {
                if (a[i][j] == 1 && is2inrow) {
                    currentplayer1max++;
                }
                if (a[i][j] == 2) {
                    currentplayer1max = 0;
                    is2inrow = false;
                }
                if (a[j][i] == 2 && is1incolumn) {
                    currentplayer2max++;
                }
                if (a[j][i] == 1) {
                    currentplayer2max = 0;
                    is1incolumn = false;
                }
            }

            if (currentplayer1max > player1max) {
                player1max = currentplayer1max;
            }
            if (currentplayer2max > player2max) {
                player2max = currentplayer2max;
            }
        }
        return player1max - player2max;
    }
}
