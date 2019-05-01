package com.lays.sampleactivemq;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Utils {

    private static final Locale mLocale = new Locale("in", "ID");

    public static String asCurrency(BigDecimal amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(mLocale);
        String moneyString = formatter.format(amount);
        if (moneyString.endsWith(",00")) {
            int centsIndex = moneyString.lastIndexOf(",00");
            moneyString = moneyString.substring(0, centsIndex);
        }
        return moneyString;
    }

    public static String asCount(BigDecimal number) {
        NumberFormat formatter = NumberFormat.getNumberInstance(mLocale);
        return formatter.format(number);
    }

    public static String asPercentage(Double percentage) {
        NumberFormat formatter = NumberFormat.getPercentInstance(mLocale);
        formatter.setRoundingMode(RoundingMode.UP);
        formatter.setMaximumFractionDigits(3);
        return formatter.format(percentage.doubleValue());
    }

    public static String asReadableDatetime(Long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy h:mm:ss a");
        return dateFormat.format(new Timestamp(timestamp).getTime());
    }
}
