package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Validators {

    public static boolean validarCpfCnpj(String cpfCnpj) {
        cpfCnpj = cpfCnpj.replaceAll("\\D", "");
        if(cpfCnpj.length() == 11) {
            int[] digitos = cpfCnpj.chars().map(c -> c - '0').toArray();
            int dv1 = calcularDigitosCPF(digitos, 9);
            int dv2 = calcularDigitosCPF(digitos, 10);
            return dv1 == digitos[9] && dv2 == digitos[10];
        }
        if(cpfCnpj.length() == 14) {
            if (cpfCnpj.matches("(\\d)\\1{13}")) {
                return false;
            }
            try {
                // Calcula os dígitos verificadores
                int[] digits = cpfCnpj.chars().map(c -> c - '0').toArray();
                int dv1 = calcularDigitoVerificadorCnpj(digits, 12, new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});
                int dv2 = calcularDigitoVerificadorCnpj(digits, 13, new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});

                // Compara os dígitos calculados com os fornecidos no CNPJ
                return dv1 == digits[12] && dv2 == digits[13];
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean validarTelefone(String telefone) {
        String telefoneRegex = "^\\(\\d{2}\\) \\d \\d{4}-\\d{4}$";
        return telefone.matches(telefoneRegex) ;
    }

    public static boolean validarEmail(String email) {
        // Regex para validar e-mail
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }


    public static String apenasDigitos(String value){
        return value.replaceAll("[^0-9]", "");
    }

    public static String validarCampoString(String campo, String nome, int tamanhoMax, List<String> erros){
        if(Objects.isNull(campo) || campo.isEmpty()){
            erros.add(nome+" nulo ou vazio!");
            return "";
        }
        if(!campo.matches("^[a-zA-Z0-9]+$")){
            erros.add(nome+" não aceita caracteres especiais");
            return "";
        }
        if(campo.length() > tamanhoMax){
            erros.add(nome+" tamanho invalido max permitido: "+tamanhoMax+" caracteres");
        }
        return campo;
    }

    public static Boolean validarCamposBoleanos(String campo,String nome,List<String> erros){
        if(Objects.isNull(campo) || campo.isEmpty()){
            erros.add(nome+" nulo ou vazio!");
            return false;
        }
        return Boolean.parseBoolean(campo);
    }


    /**
     * Calcula um dígito verificador do CPF.
     *
     * @param digits Array de inteiros representando os dígitos do CPF.
     * @param length O número de dígitos a serem considerados no cálculo.
     * @return O dígito verificador calculado.
     */
    private static int calcularDigitosCPF(int[] digits, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += digits[i] * (length + 1 - i);
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
    /**
     * Calcula um dígito verificador do CNPJ.
     *
     * @param digits Array de inteiros representando os dígitos do CNPJ.
     * @param length O número de dígitos a serem considerados no cálculo.
     * @param weights Array de pesos utilizados no cálculo.
     * @return O dígito verificador calculado.
     */
    private static int calcularDigitoVerificadorCnpj(int[] digits, int length, int[] weights) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += digits[i] * weights[i];
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

}
