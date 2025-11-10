/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Aaron
 */
public class Randomiser {

    private static final Random R = new Random();

    public static int nextInt(int min, int max) {
        return min + R.nextInt(max - min + 1);
    }

    public static <T> T pick(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }
        return items.get(R.nextInt(items.size()));
    }
}
