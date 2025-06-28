package com.gersonccruz.conversor.modelos;

import com.google.gson.Gson;
import java.io.IOException;


public class ConversorDeMoedas {
    private double taxaDeConversao;
    private String deMoeda;
    private String paraMoedas;
    private double valorConvertido;

    public ConversorDeMoedas() {
    }

    ApiClient apiClient = new ApiClient();
    Gson gson = new Gson();

    public void usdParaBrl(double valor){
        try {
            String json;
            json = apiClient.getTaxaDeConversao("USD", "BRL", valor);
            MoedasBase moeda = gson.fromJson(json, MoedasBase.class);
            ConversorDeMoedas moedaConvertida = new ConversorDeMoedas(moeda);
            System.out.println(moedaConvertida);

        } catch (IOException | InterruptedException e) {
            System.out.println("O programa não conseguiu converter as moedas");
        }
    }


    public ConversorDeMoedas(MoedasBase moedasBase) {
        this.deMoeda = moedasBase.base_code();
        this.paraMoedas = moedasBase.target_code();
        this.taxaDeConversao = Double.parseDouble(moedasBase.conversion_rate());
        this.valorConvertido = Double.parseDouble(moedasBase.conversion_result());
    }

    @Override
    public String toString() {
        return "com.gersonccruz.conversor.modelos.ConversorDeMoedas{" +
                "taxaDeConversao=" + taxaDeConversao +
                ", deMoeda='" + deMoeda + '\'' +
                ", paraMoedas='" + paraMoedas + '\'' +
                ", valorConvertido=" + valorConvertido +
                '}';
    }
}
