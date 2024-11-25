package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.Valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.Cliente;
/**
 *
 * @author otavi
 */
public class ValidateCliente {


    public Cliente validaCamposEntrada(String nome, String email, String cpfCnpj, String telefone) {
        Cliente cliente = new Cliente();

        // Valida o nome
        if (nome.isEmpty()) {
            throw new ImpreException("Error - Campo vazio: 'nome'.");
        }
        cliente.setNome(nome);

        // Valida o e-mail
        if (email.isEmpty()) {
            throw new ImpreException("Error - Campo vazio: 'email'.");
        }
        if (!validarEmail(email)) {
            throw new ImpreException("Error - E-mail inválido.");
        }
        cliente.setEmail(email);

        // Valida o CPF/CNPJ
        if (cpfCnpj.isEmpty()) {
            throw new ImpreException("Error - Campo vazio: 'cpfCnpj'.");
        } else {
            String cpfCnpjFormatado = validarCpfCnpj(cpfCnpj);
            if (cpfCnpjFormatado == null) {
                throw new ImpreException("Error - CPF ou CNPJ inválido.");
            }
            cliente.setCpf_cnpj(cpfCnpjFormatado);
        }

        // Valida o telefone
        if (telefone.isEmpty()) {
            throw new ImpreException("Error - Campo vazio: 'telefone'.");
        }
        if (!validarTelefone(telefone)) {
            throw new ImpreException("Error - Telefone inválido.");
        }
        cliente.setTelefone(telefone);

        return cliente;
    }


    public String validarCpfCnpj(String texto) {
        // Remove quaisquer caracteres que não sejam números
        String numeros = texto.replaceAll("[^0-9]", "");

        // Verifica se é CPF
        if (numeros.length() == 11) {
            if (isValidCPF(numeros)) {
                // Formatar CPF: XXX.XXX.XXX-XX
                return numeros.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            } else {
                return null; // CPF inválido
            }
        }
        // Verifica se é CNPJ
        else if (numeros.length() == 14) {
            if (isValidCNPJ(numeros)) {
                // Formatar CNPJ: XX.XXX.XXX/XXXX-XX
                return numeros.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
            } else {
                return null; // CNPJ inválido
            }
        } else {
            return null; // Não é CPF nem CNPJ válido
        }
    }


    public boolean validarEmail(String email) {
        // Regex para validar e-mail
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }


    public boolean validarTelefone(String telefone) {
        // Regex para validar telefone (com ou sem DDD)
        String telefoneRegex = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}$";
        return telefone.matches(telefoneRegex);
    }

    public boolean isValidCPF(String cpf) {
        // Implementação simplificada, ajuste conforme necessário
        if (cpf.matches("(\\d)\\1{10}")) return false; // CPF com números repetidos
        int[] pesoCPF = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        return verificarDigito(cpf, pesoCPF);
    }

   
    private boolean isValidCNPJ(String cnpj) {
        // Implementação simplificada, ajuste conforme necessário
        if (cnpj.matches("(\\d)\\1{13}")) return false; // CNPJ com números repetidos
        int[] pesoCNPJ1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesoCNPJ2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        return verificarDigito(cnpj.substring(0, 12), pesoCNPJ1) &&
               verificarDigito(cnpj, pesoCNPJ2);
    }

   
    private boolean verificarDigito(String documento, int[] peso) {
        int soma = 0;
        for (int i = 0; i < peso.length; i++) {
            soma += (documento.charAt(i) - '0') * peso[i];
        }
        int resto = soma % 11;
        int digito = (resto < 2) ? 0 : 11 - resto;
        return digito == (documento.charAt(peso.length) - '0');
    }
}
