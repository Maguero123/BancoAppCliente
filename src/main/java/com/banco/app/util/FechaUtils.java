package com.banco.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaUtils {
    public static String ahora() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
