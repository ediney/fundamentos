package com.example.inverter;

import org.springframework.web.bind.annotation.*;

/**
 * Inverter Número — Spring Boot REST API
 * Baseado em: Medina & Fertig - "Algoritmos e Programação, Teoria e Prática", 2ª ed., p. 40
 *
 * Endpoints:
 *   GET /inverter/4digitos?numero=2548   → { "original": 2548, "invertido": 8452 }
 *   GET /inverter/ndigitos?numero=12345  → { "original": 12345, "invertido": 54321 }
 */

@RestController
@RequestMapping("/inverter")
public class InverterNumeroController {

    // Versão 1: exatamente 4 dígitos (fiel ao livro)
    @GetMapping("/4digitos")
    public InverterResponse quatroDigitos(@RequestParam int numero) {
        int valorTemp = numero;

        int milhar  = valorTemp / 1000;
        valorTemp   = valorTemp % 1000;

        int centena = valorTemp / 100;
        valorTemp   = valorTemp % 100;

        int dezena  = valorTemp / 10;
        int unidade = valorTemp % 10;

        int invertido = unidade * 1000
                + dezena  * 100
                + centena * 10
                + milhar;

        return new InverterResponse(numero, invertido);
    }

    // Versão 2: N dígitos
    @GetMapping("/ndigitos")
    public InverterResponse nDigitos(@RequestParam long numero) {
        long valorTemp     = numero;
        long valorInvertido = 0;

        while (valorTemp != 0) {
            long digito    = valorTemp % 10;
            valorInvertido = (valorInvertido * 10) + digito;
            valorTemp      = valorTemp / 10;
        }

        return new InverterResponse(numero, valorInvertido);
    }

    // Record de resposta
    public record InverterResponse(long original, long invertido) {}
}
