package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

public class Validators {

    public static boolean validarCpfCnpj(String cpfCnpj) {
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
        // Regex para validar telefone (com ou sem DDD)
        String telefoneRegex = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}$";
        return telefone.matches(telefoneRegex);
    }

    public static boolean validarEmail(String email) {
        // Regex para validar e-mail
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
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
