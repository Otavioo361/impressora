package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Formatadores {
    public static String formatMoney(BigDecimal value) {
        if (Objects.isNull(value)){
            value = new BigDecimal("0.0");
        }
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormat.format(value);
    }
    public static String formatDate(LocalDate date) {
        if (Objects.isNull(date)){
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        if (Objects.isNull(dateTime)){
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
    public static String formatDateTimeDate(LocalDateTime dateTime) {
        if (Objects.isNull(dateTime)){
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(formatter);
    }
}
