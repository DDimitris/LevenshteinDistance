/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dedousis Dimitris <dimitris.dedousis@gmail.com>
 */
public class Algorithm {

    private final String firstWord;
    private final String secondWord;
    private Integer optDistance;
    private int[][] array;
    private int numberOfColumns;
    private int numberOfRows;
    private List<Integer> sequence;

    {
        sequence = new ArrayList<>();
    }

    public Algorithm(String firstWord, String secondWord) {
        this.firstWord = firstWord.toLowerCase();
        this.secondWord = secondWord.toLowerCase();
    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public int[][] getArray() {
        return array;
    }

    public Integer getDistance() {
        return optDistance;
    }
    
    public void editDistance() {
        String[] string1 = firstWord.split("");
        String[] string2 = secondWord.split("");
        numberOfColumns = string1.length;
        numberOfRows = string2.length;
        array = new int[numberOfColumns][numberOfRows];
        for (int i = 0; i < numberOfColumns; i++) {
            array[i][0] = i;
        }
        for (int j = 0; j < numberOfRows; j++) {
            array[0][j] = j;
        }
        for (int i = 1; i < numberOfColumns; i++) {
            for (int j = 1; j < numberOfRows; j++) {
                int insert = array[i - 1][j] + 1;
                int delete = array[i][j - 1] + 1;
                int replace = array[i - 1][j - 1] + getReplaceCost(string1[i], string2[j]);
                int min = Math.min(insert, Math.min(delete, replace));
                array[i][j] = min;
            }
        }
        printArray();
        optDistance = array[numberOfColumns - 1][numberOfRows - 1];
        System.out.println("distance(" + firstWord + ", " + secondWord + ") = " + optDistance);
        findTheSequence();
    }

    private int getReplaceCost(String characterFromFirstString, String characterFromSecondString) {
        if (characterFromFirstString.equals(characterFromSecondString)) {
            return 0;
        } else {
            return 2;
        }
    }

    private void findTheSequence() {
        for (int i = numberOfColumns - 1; i > 0;) {
            for (int j = numberOfRows - 1; j > 0;) {
                if (array[i][j - 1] <= array[i - 1][j] && array[i][j - 1] <= array[i - 1][j - 1]) {
                    sequence.add(array[i][j - 1]);
                    j = j - 1;
                } else if (array[i][j - 1] >= array[i - 1][j] && array[i - 1][j] <= array[i - 1][j - 1]) {
                    sequence.add(array[i - 1][j]);
                    i = i - 1;
                } else if (array[i][j - 1] >= array[i - 1][j - 1] && array[i - 1][j] >= array[i - 1][j - 1]) {
                    sequence.add(array[i - 1][j - 1]);
                    j = j - 1;
                    i = i - 1;
                }
            }
        }
        System.out.println();
        System.out.print("{  ");
        for (Integer l : sequence) {
            System.out.print(l + " ");
        }
        System.out.println(" }");
        System.out.println();
    }

    private void printArray() {
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
