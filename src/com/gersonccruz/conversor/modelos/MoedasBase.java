package com.gersonccruz.conversor.modelos;

/** Modelo resposável por mapear os dados da API
 * para o programa.
 */

public record MoedasBase(String base_code, String target_code, String conversion_rate, String conversion_result) {
}
