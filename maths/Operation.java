/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

/**
 *
 * @author Aaron
 */
public enum Operation {
    ADD("+"), SUB("-"),MUL("X"),DIV("/");
    private final String symbol;
    Operation(String s){
        this.symbol = s;
    }
    public String getSymbol(){
        return symbol;
    }
}
