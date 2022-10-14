package org.example;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class LevensteinConverter {

    private Map<String, String> symbolMap = new HashMap<>();
    {
        symbolMap.put("2", "                                       ******                     **********                  ************                *****   ******              *****      ****                **       ****                         ****                         ****                         ****                        *****                        ****                        ****                       *****                       *****                       *****                       *****                       *****                      *****                       *****                        ***************              ***************              ****************                                     ");
        symbolMap.put("3", "                                   *************                *************                **************                        ****                        ****                        ****                        ****                         ***                         ***                         ****                         *******                      ********                          ****                          ****                         ****                          ***                         ****               **        ***               *****     ****                ************                  **********                     *******                                          ");
        symbolMap.put("4", "                                             ***                          ***                         ****                        *****                       ******                      *** ***                     **** ***                     ***  ***                    ***   ***                   ***    ***                  ***     ***                 ***      ***                ****      ***               ****       ***               ******************           ******************           ******************                      ***                          ***                          ***                          ***                          ***                                       ");
        symbolMap.put("5", "                                   *************                *************                *************                ****                         ***                          ***                          ***                          ***                          *** *****                   ************                 *************                 ****   ******                         ****                          ****                         ****                         ****                         ****              ***       ****              ******    *****               *************                 ***********                    ********                                          ");
        symbolMap.put("6", "                                       ********                    ***********                 ************                *****    ****               *****       *                ****                        ****                         ****                         ****  ******                 **************               ***************              ******    ******             *****       ****             ****        ****             ****         ***             ****         ***             ****        ****              ****       ****              *****     ****                *************                 ***********                    *******                                         ");
        symbolMap.put("7", "                                   **************               **************               **************                          ***                         ****                         ***                         ****                         ***                         ***                          ***                         ***                         ****                         ***                         ****                         ***                         ****                         ***                         ****                         ***                         ****                         ***                         ****                                               ");
        symbolMap.put("8", "                                      *******                    ***********                 *************                ****     *****              ****       ****              ****       ****              ****       ****              ****       ****               ****     ****                 ************                  *********                   ***********                 ******  ******              ****       ****              ***         ****            ****         ****            ****         ****             ****        ****             *****     *****               **************                ************                   ********                                         ");
        symbolMap.put("9", "                                       ******                     **********                  ************                *****     ****               ***        ****              ***         ***             ****         ***             ****         ***              ***         ***              ***        *****             ****      ******              **************                ********* ***                  *****   ***                          ***                          ***                         ***                *        ****                ***     ****                *************                 **********                     *******                                          ");
        symbolMap.put("10", "                                  ***         *****         ******       *********     ********     ************     *******     ****     ****        ***    ****       ****       ***   ****         ***       ***   ***          ****      ***   ***           ***      ***   ***           ***      ***  ****           ***      ***  ****           ***      ***  ****           ***      ***  ****           ***      ***  ****           ***      ***   ***           ***      ***   ***          ****      ***   ****         ***       ***    ****       ****       ***    *****     ****        ***     ************         ***      **********          ***        ******                                    ");
        symbolMap.put("J", "                                           ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                         ****                **      ****                *****   *****                ************                  **********                     *******                                            ");
        symbolMap.put("Q", "                                          *******                    ***********                 **************             ******     ******            ****         ****           ****           ****         ****             ****        ***              ****        ***               ***        ***               ***       ****               ****      ****               ****       ***               ***        ***         **    ***        ***        ***** ****        ****        *********         ****        *******          *****        ******           ******     *******            ******************             ***********  ***               *******     *                                ");
        symbolMap.put("K", "                                   ***           ****           ***          ****            ***         ****             ***        ****              ***       ****               ***      ****                ***     ****                 ***    ****                  ***   ****                   ***  ****                    ***  *****                   ***********                  ******  ***                  *****   ****                 ****     ****                ***       ****               ***        ***               ***        ****              ***         ****             ***          ****            ***          ****            ***           ****                                  ");
        symbolMap.put("A", "                                                                    ***                         *****                        *****                       ******                       *** ***                      **  ***                     ***   ***                    ***   ***                   ***    ****                  ***     ***                 ***      ****                ***       ***                **        ***               ***************              ***************             *****************            ***           ***           ***            ****          ***             ***         ****             ***         ***               ***                          *         ");
        //трефы
        symbolMap.put("c", "          **********                     ***********                   *************                  *************                 **************                 **************                 **************                 **************                  *************                  ************                    ***********               *********************         ************************      **************************    ***************************   *****************************  *****************************  *****************************  *****************************  *****************************  *****************************   ***************************     *********** ** ***********      *********  ** **********        ******   ***   ******                   ***                           *****                         *******                       *********                     ***********                                                                                                       ");
        //бубны
        symbolMap.put("d", "             ****                          ******                        ********                      **********                    ************                  **************                ****************              ******************            *******************            ********************          **********************        ************************      **************************    ****************************   ***************************     *************************       ************************        **********************          ********************            ******************              ****************               ***************                 *************                   ***********                     **********                      ********                        ******                          ****                            **                                                                                                                                           ");
        //пики
        symbolMap.put("s", "              **                            ****                          ******                        ********                      ***********                   ************                  ***************               *****************             *******************           *********************         ***********************       *************************     **************************     ***************************   ****************************   *****************************  *****************************  *****************************  *****************************  *****************************  *****************************  *************** ************    *********** **  ***********     *********  **   *********        *****    **    ******                   ***                            ***                           *****                        ********                     ************                                                                                                       ");
        //черви
        symbolMap.put("h", "                                                                                                                                 *******       ******          *********    **********       ***********  ************     ************* *************   ****************************   ****************************   *****************************  *****************************  *****************************  ****************************   ****************************    ***************************    **************************      *************************      ************************        **********************          ********************            ******************               ***************                 *************                   ***********                     *********                       *******                         ****                            **                                                                                                                                           ");
    }

    public StringBuilder getBinaryString(BufferedImage symbol, int height, int width) {
        StringBuilder binaryString = new StringBuilder();
        for (short y = 1; y < height; y++) {
            for (short x = 1; x < width; x++) {
                int rgb = symbol.getRGB(x, y);
                binaryString.append(rgb == -1 ? " " : "*");
            }
        }
        return binaryString;
    }

    public String getSymbol(StringBuilder binaryString) {
        int min = 1000000;
        String findSymbol = "";
        for (Map.Entry<String, String> entry : symbolMap.entrySet()) {
            int levenshtein = levenshtein(binaryString.toString(), entry.getValue());
            if (levenshtein < min) {
                min = levenshtein;
                findSymbol = entry.getKey();
            }
        }
        return findSymbol;
    }

    private int levenshtein(String targetStr, String sourceStr) {
        int m = targetStr.length(), n = sourceStr.length();
        int[][] delta = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            delta[i][0] = i;
        for (int j = 1; j <= n; j++)
            delta[0][j] = j;
        for (int j = 1; j <= n; j++)
            for (int i = 1; i <= m; i++) {
                if (targetStr.charAt(i - 1) == sourceStr.charAt(j - 1))
                    delta[i][j] = delta[i - 1][j - 1];
                else
                    delta[i][j] = Math.min(delta[i - 1][j] + 1,
                            Math.min(delta[i][j - 1] + 1, delta[i - 1][j - 1] + 1));
            }
        return delta[m][n];
    }
}