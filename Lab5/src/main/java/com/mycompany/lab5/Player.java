/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;

/**
 *
 * @author informatics
 */
public class Player {

    private char symbol;
    private int winCount = 0;
    private int loseCount = 0;
    private int tieCount = 0;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWinCount() {
        return winCount;
    }

    public void incWinCount() {
        this.winCount++;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void incLoseCount() {
        this.loseCount++;
    }

    public int getTieCount() {
        return tieCount;
    }

    public void incTieCount() {
        this.tieCount++;
    }

    @Override
    public String toString() {
        return "Player{" + "symbol=" + symbol + ", winCount=" + winCount + ", loseCount=" + loseCount + ", tieCount=" + tieCount + '}';
    }

}


