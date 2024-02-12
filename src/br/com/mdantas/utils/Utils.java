package br.com.mdantas.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    private static NumberFormat formattingValues = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double value) {
        return formattingValues.format(value);
    }
}
