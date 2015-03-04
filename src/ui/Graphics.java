package ui;

import algorithm.Algorithm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Provides support for graphical presentation of the execution of the Algorithm.
 */
public class Graphics {
    
    public static JFrame generateAndShowGraphic(Algorithm alg) {
        JFrame result = new JFrame();
        final BackgroundedPanel graphic = generateGraphic(alg);
        graphic.setBorder(BorderFactory.createEmptyBorder(5, 6, 2, 4));
        result.add(graphic);
        result.setTitle("Levenshtein - "+alg.getFirstWord()+"/"+alg.getSecondWord());
        result.setMinimumSize(new Dimension(80*alg.getFirstWord().length()+20, 80*alg.getSecondWord().length()));
        result.setLocationByPlatform(true);
        result.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        result.getContentPane().setBackground(Color.WHITE);
        result.setVisible(true);
        return result;
    }
    
    public static BackgroundedPanel generateGraphic(Algorithm alg) {
        if (alg.getArray() == null) {
            throw new IllegalArgumentException("Algorithm must be completed");
        }
        String first = alg.getFirstWord();
        String second = alg.getSecondWord();
        int[][] array = alg.getArray();
        
        BackgroundedPanel result = new BackgroundedPanel(new GridBagLayout());
        result.setRounded(true);
        result.setAlpha(0F);
        result.setBackground(Color.WHITE);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 0.7;
        constraints.insets = new Insets(1, 1, 0, 1);
        for (int i = 0; i < first.length(); i++) {
            constraints.gridx = i+1;
            result.add(generateLetterGraphic(first.charAt(i), true), constraints);
        }
        
        constraints.gridx = 0;
        constraints.weighty = 0.5;
        constraints.weightx = 0.7;
        constraints.insets = new Insets(1, 1, 1, 0);
        for (int i = 0; i < second.length(); i++) {
            constraints.gridy = i+1;
            result.add(generateLetterGraphic(second.charAt(i), false), constraints);
        }
        
        constraints.weighty = 0.5;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(0, 0, 0, 0);
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                constraints.gridx = i+1;
                constraints.gridy = j+1;
                result.add(generateNumberGraphic(array[i][j]), constraints);
            }
        }
        
        constraints.gridx = 0;
        constraints.gridy = second.length()+2;
        constraints.gridwidth = first.length()+1;
        constraints.weighty = 0.2;
        constraints.fill = GridBagConstraints.NONE;
        
        result.add(generateDistanceGraphic(alg), constraints);
        
        return result;
    }
    
    static BackgroundedPanel generateLetterGraphic(char letter, boolean isUpCorner) {
        BackgroundedPanel result = new BackgroundedPanel(1F, Color.BLUE.darker().darker(), null, true);
        if (isUpCorner) {
            result.setCornerFills(false, false, true, true);
        } else {
            result.setCornerFills(false, true, false, true);
        }
        result.setBorderLine(Color.BLACK);
        result.setLayout(new BorderLayout());
        
        JLabel label = new JLabel(letter+"");
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD + Font.ITALIC, 29));
        result.add(label);
        
        return result;
    }    
    
    static BackgroundedPanel generateNumberGraphic(int number) {
        BackgroundedPanel result = new BackgroundedPanel(1F, Color.CYAN.brighter().brighter(), null, false);
        result.setBorderLine(Color.BLACK);
        result.setLayout(new BorderLayout());
        
        JLabel label = new JLabel(number+"");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(null, Font.PLAIN, 27));
        result.add(label);
        
        return result;
    }
    
    static BackgroundedPanel generateDistanceGraphic(Algorithm alg) {
        BackgroundedPanel result = new BackgroundedPanel(0.2F, Color.YELLOW, null, true);
        result.setLayout(new BorderLayout());
        
        JLabel distance = new JLabel("Levenshtein Distance: "+alg.getDistance());
        distance.setFont(new Font(null, Font.BOLD, 18));
        distance.setBorder(BorderFactory.createEmptyBorder(3, 4, 3, 4));
        result.add(distance);
        
        return result;
    }
    
}