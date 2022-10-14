package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CardCutter {
    private int height = 25;
    private int width = 30;
    private int offsetTop = -590;
    private int offsetLeft = -146;
    private int countCards = 3;
    private int distanceBetweenCards = 72;
    private int whiteColor = -1;
    private int grayColor = -8882056;

    public ArrayList<BufferedImage> getCards(File input) {
        BufferedImage image;
        try {
            image = ImageIO.read(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setCountCards(image);

        ArrayList<BufferedImage> symbolList = new ArrayList<>();
        for (int i = 0; i < countCards; i++) {
            switchGrayToWhiteColor(image, height, width, offsetTop * -1, offsetLeft * -1 + distanceBetweenCards * i);
            BufferedImage symbol = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D symbolGraphics = symbol.createGraphics();
            symbolGraphics.drawImage(image, offsetLeft - distanceBetweenCards * i, offsetTop, null);
            symbolList.add(symbol);

            switchGrayToWhiteColor(image, height + 9, width + 2, offsetTop * -1 + 45, offsetLeft * -1 + 22 + distanceBetweenCards * i);
            BufferedImage suit = new BufferedImage(width + 2, height + 9, BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D suitGraphics = suit.createGraphics();
            suitGraphics.drawImage(image, offsetLeft - 22 - distanceBetweenCards * i, offsetTop - 45, null);
            symbolList.add(suit);
        }
        return symbolList;
    }

    private void setCountCards(BufferedImage image) {
        if (whiteColor == image.getRGB(150 + distanceBetweenCards * 3, 590) || (grayColor == image.getRGB(150 + distanceBetweenCards * 3, 590))) countCards++;
        if (whiteColor == image.getRGB(150 + distanceBetweenCards * 4, 590) || (grayColor == image.getRGB(150 + distanceBetweenCards * 4, 590))) countCards++;
    }

    private void switchGrayToWhiteColor(BufferedImage image, int height, int width, int offsetTop, int offsetLeft) {
        if (image.getRGB(offsetTop, offsetLeft) != whiteColor) {
            for (int x = offsetLeft; x < offsetLeft + width; x++) {
                for (int y = offsetTop; y < offsetTop + height; y++) {
                    if (image.getRGB(x, y) == grayColor) image.setRGB(x, y, whiteColor);
                }
            }
        }
    }
}
