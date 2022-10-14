package org.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        File folder = new File("D:\\CardVision\\imgs_marked");

        for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            LevensteinConverter converter = new LevensteinConverter();
            CardCutter cardCutter = new CardCutter();
            StringBuilder result = new StringBuilder("");
            int i = 0;
            for (BufferedImage card : cardCutter.getCards(fileEntry)) {
                if (i % 2 == 0) {
                    result.append(converter.getSymbol(converter.getBinaryString(card, 25, 30)));
                } else {
                    result.append(converter.getSymbol(converter.getBinaryString(card, 34, 32)));
                }
                i++;
            }
            String defaultName = fileEntry.getName().substring(0, fileEntry.getName().length() - 4);
            if (defaultName.equals(result.toString())) {
                System.out.print("+ ");
            } else {
                System.out.print("- ");
            }
            System.out.println(fileEntry.getName() + " - " + result);
        }
    }
}