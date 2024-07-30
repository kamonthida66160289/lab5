/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;

/**
 *
 * @author informatics
 */
public class Board {

    private char[][] table = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int count = 0;
    private int row;
    private int col;

    public Board(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        if (Math.random() < 0.5) {
            currentPlayer = p1;
        } else {
            currentPlayer = p2;
        }

    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int setRowCol(int row, int col) {
        if (row > 2 || row < 0 || col > 2 || col < 0) {
            return -1;
        }
        if (table[row][col] == '-') {
            table[row][col] = currentPlayer.getSymbol();
            this.row = row;
            this.col = col;
            count++;
            return 1;
        } else {
            return 0;
        }
    }

    public void switchTurn() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }

    public void updateStat() {
        if (checkRow()) {
            if (currentPlayer == p1) {
                p1.incWinCount();
                p2.incLoseCount();
            } else if (currentPlayer == p2) {
                p2.incWinCount();
                p1.incLoseCount();
            }

        }
        if (checkCol()) {
            if (currentPlayer == p1) {
                p1.incWinCount();
                p2.incLoseCount();
            } else if (currentPlayer == p2) {
                p2.incWinCount();
                p1.incLoseCount();
            }
        }
        if (checkDiagonals()) {
            if (currentPlayer == p1) {
                p1.incWinCount();
                p2.incLoseCount();
            } else if (currentPlayer == p2) {
                p2.incWinCount();
                p1.incLoseCount();
            }
        }
        if (checkIsTie()) {
            p1.incTieCount();
            p2.incTieCount();
        }
    }

    public boolean isFinish() {
        if (checkRow()) {
            return true;
        }
        if (checkCol()) {
            return true;
        }
        if (checkDiagonals()) {
            return true;
        }
        if (checkIsTie()) {
            return true;
        }

        return false;
    }

    public boolean checkRow() {
        if ((table[row][0] == currentPlayer.getSymbol() && table[row][1] == currentPlayer.getSymbol() && table[row][2] == currentPlayer.getSymbol())) {
            return true;
        }
        return false;
    }

    public boolean checkCol() {
        if ((table[0][col] == currentPlayer.getSymbol() && table[1][col] == currentPlayer.getSymbol() && table[2][col] == currentPlayer.getSymbol())) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonals() {
        if ((table[0][0] == currentPlayer.getSymbol() && table[1][1] == currentPlayer.getSymbol() && table[2][2] == currentPlayer.getSymbol()) || (table[0][2] == currentPlayer.getSymbol() && table[1][1] == currentPlayer.getSymbol() && table[2][0] == currentPlayer.getSymbol())) {
            return true;
        }
        return false;
    }

    public boolean checkIsTie() {
        if (count == 9) {
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String toString() {
        return "Board{" + "table=" + table + ", p1=" + p1 + ", p2=" + p2 + '}';
    }

}


