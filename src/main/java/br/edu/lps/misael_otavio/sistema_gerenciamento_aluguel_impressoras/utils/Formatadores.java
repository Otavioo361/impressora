package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Formatadores {

    public static String formatTelefone(String telefone) {
        return String.format("(%s) %s %s-%s",telefone.substring(0,2),telefone.charAt(3),telefone.substring(4,7),telefone.substring(7));
    }

    public static String formataCpfCnpj(String cpfCnpj) {
        if(cpfCnpj.length() == 11) {
            return String.format("%s.%s.%s-%s",cpfCnpj.substring(0,3),cpfCnpj.substring(3,6),cpfCnpj.substring(6,9),cpfCnpj.substring(9));
        }
        return String.format("%s.%s.%s/%s-%s",
                cpfCnpj.substring(0, 2),
                cpfCnpj.substring(2, 5),
                cpfCnpj.substring(5, 8),
                cpfCnpj.substring(8, 12),
                cpfCnpj.substring(12));
    }
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
