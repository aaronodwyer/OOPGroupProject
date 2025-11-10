/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.SwingUtilities;
import ui.MainMenu;
/**
 *
 * @author Aaron
 */
public class App {
    public static void main(String [] args){
    SwingUtilities.invokeLater(() -> {
        new MainMenu().setVisible(true);
    });
}
}
