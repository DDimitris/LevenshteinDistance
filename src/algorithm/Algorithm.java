/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author Dedousis Dimitris <dimitris.dedousis@gmail.com>
 */
public class Algorithm {

    private final String firstWord;
    private final String secondWord;
    private Integer optDistance;

    public Algorithm(String firstWord, String secondWord) {
        this.firstWord = firstWord.toLowerCase();
        this.secondWord = secondWord.toLowerCase();
    }

    public void editDistance() {
        String[] string1 = firstWord.split("");
        String[] string2 = secondWord.split("");
        int numberOfColumns = string1.length;
        int numberOfRows = string2.length;
        int[][] a = new int[numberOfColumns][numberOfRows];
        for (int i = 0; i < numberOfColumns; i++) {
            a[i][0] = i;
        }
        for (int j = 0; j < numberOfRows; j++) {
            a[0][j] = j;
        }
        for (int i = 1; i < numberOfColumns; i++) {
            for (int j = 1; j < numberOfRows; j++) {
                int insert = a[i - 1][j] + 1;
                int delete = a[i][j - 1] + 1;
                int replace = a[i - 1][j - 1] + getReplaceCost(string1[i], string2[j]);
                int min = Math.min(insert, Math.min(delete, replace));
                a[i][j] = min;
            }
        }
        optDistance = a[numberOfColumns - 1][numberOfRows - 1];
        System.out.println("distance(" + firstWord + ", " + secondWord + ") = " + optDistance);
    }

    private int getReplaceCost(String characterFromFirstString, String characterFromSecondString) {
        if (characterFromFirstString.equals(characterFromSecondString)) {
            return 0;
        } else {
            return 2;
        }
    }

}
