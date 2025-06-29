package com.gersonccruz.conversor.modelos;

/**Record que serve para mostrar ao usuário o resultado da conversao
 * de forma amigável e simples.
 * */

public record ResultadoConversao(
        String moedaOrigem,
        String moedaDestino,
        double valorOriginal,
        double taxaDeConversao,
        double valorConvertido
) {

    @Override
    public String toString() {
        return  """
                ------------------------------
                Valor Original: %.2f [%s]
                Taxa De Conversão: %.2f
                Valor Convertido: %.2f [%s]
                ------------------------------
                """.formatted(this.valorOriginal, this.moedaOrigem,
                this.taxaDeConversao, this.valorConvertido,
                this.moedaDestino);
    }
}
