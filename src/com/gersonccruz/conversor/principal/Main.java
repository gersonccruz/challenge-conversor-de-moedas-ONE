package com.gersonccruz.conversor.principal;

import com.gersonccruz.conversor.modelos.ConversorDeMoedas;

public class Main {
    public static void main(String[] args) {
        ConversorDeMoedas moeda = new ConversorDeMoedas();
        moeda.usdParaBrl(100);
    }
}