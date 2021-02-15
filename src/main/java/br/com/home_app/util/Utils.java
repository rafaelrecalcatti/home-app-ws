package br.com.home_app.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class Utils {

    private static final Logger LOGGER = LogManager.getLogger();

    public static String tokenGenerator() {

        String id = "";
        String[] caracteres = {"3", "5", "4", "0", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "4", "p", "q", "r", "8", "t", "u", "v", "6", "7", "8", "9", "x", "w", "y", "z", "a", "1",
                "2", "3", "o", "5", "6", "7", "s", "p", "0", "1", "2"};

        int count = caracteres.length;

        for (int i = 0; i < 8; i++) {
            int pos = new Random().nextInt(count);
            id = id.concat(caracteres[pos]);
        }

        id = id.concat("-");

        for (int i = 0; i < 4; i++) {
            int pos = new Random().nextInt(count);
            id = id.concat(caracteres[pos]);
        }

        id = id.concat("-");

        for (int i = 0; i < 4; i++) {
            int pos = new Random().nextInt(count);
            id = id.concat(caracteres[pos]);
        }

        id = id.concat("-");

        for (int i = 0; i < 4; i++) {
            int pos = new Random().nextInt(count);
            id = id.concat(caracteres[pos]);
        }

        id = id.concat("-");

        for (int i = 0; i < 12; i++) {
            int pos = new Random().nextInt(count);
            id = id.concat(caracteres[pos]);
        }

        return id;
    }


}
