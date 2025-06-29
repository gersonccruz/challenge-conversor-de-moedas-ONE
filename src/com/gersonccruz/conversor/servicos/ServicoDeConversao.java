package com.gersonccruz.conversor.servicos;

import com.gersonccruz.conversor.modelos.MoedasBase;
import com.gersonccruz.conversor.modelos.ResultadoConversao;
import com.google.gson.Gson;

import java.io.IOException;
/**
 * Classe de serviço responsável por buscar a taxa de conversão e os resultados
 * e transformá-las em um resultado amigável para o usuário.
 */
public class ServicoDeConversao {
    private final Gson gson = new Gson();
    private final ApiClient apiClient = new ApiClient();

    public ResultadoConversao converter(String moedaOrigem, String moedaDestino, double valor) throws IOException, InterruptedException {
        String jsonResposta = apiClient.getTaxaDeConversao(moedaOrigem, moedaDestino, valor);

        //Pega os dados do json e transforma e um Objeto.
        MoedasBase respostaApi = gson.fromJson(jsonResposta, MoedasBase.class);


        //retorna o resultado da conversão com todos os parâmetros organizados e de forma amigável.
        return new ResultadoConversao(respostaApi.base_code(), respostaApi.target_code(),
                valor, Double.parseDouble(respostaApi.conversion_rate()),
                Double.parseDouble(respostaApi.conversion_result()));
    }
}
