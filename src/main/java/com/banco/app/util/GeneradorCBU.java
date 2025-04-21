package com.banco.app.util;

import java.util.Random;

public class GeneradorCBU {
    public static String generar() {
        Random r = new Random();
        StringBuilder cbu = new StringBuilder();
        for (int i = 0; i < 22; i++) {
            cbu.append(r.nextInt(10));
        }
        return cbu.toString();
    }
}
