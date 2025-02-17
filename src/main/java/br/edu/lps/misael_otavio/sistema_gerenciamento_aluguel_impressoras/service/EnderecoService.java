package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class EnderecoService {

    public static JSONObject consultarCEP(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            BufferedReader reader = getBufferedReader(url);
            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }

            reader.close();
            return new JSONObject(resposta.toString());

        } catch (Exception e) {

            return null;
        }
    }

    private static BufferedReader getBufferedReader(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Erro ao consultar o CEP: " + connection.getResponseCode());
        }

        return new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
    }

}


