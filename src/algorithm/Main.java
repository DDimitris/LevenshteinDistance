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
public class Main {
    public static void main(String[] args) {
        Algorithm a = new Algorithm("πεζοιται", "παιζετε");
        a.editDistance();
        ui.Graphics.generateAndShowGraphic(a);
    }
}
