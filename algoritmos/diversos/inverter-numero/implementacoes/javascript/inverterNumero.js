/**
 * Inverter Número — JavaScript puro (Node.js)
 * Baseado em: Medina & Fertig - "Algoritmos e Programação, Teoria e Prática", 2ª ed., p. 40
 *
 * Execute: node inverterNumero.js
 */

const readline = require("readline");

// Versão 1: exatamente 4 dígitos (fiel ao livro)
function inverterQuatroDigitos(valorInicial) {
    let valorTemp = valorInicial;

    const milhar  = Math.trunc(valorTemp / 1000);
    valorTemp     = valorTemp % 1000;

    const centena = Math.trunc(valorTemp / 100);
    valorTemp     = valorTemp % 100;

    const dezena  = Math.trunc(valorTemp / 10);
    const unidade = valorTemp % 10;

    return unidade * 1000
        + dezena  * 100
        + centena * 10
        + milhar;
}

// Versão 2: N dígitos
function inverterNDigitos(valorInicial) {
    let valorTemp      = valorInicial;
    let valorInvertido = 0;

    while (valorTemp > 0) {
        const digito   = valorTemp % 10;
        valorInvertido = (valorInvertido * 10) + digito;
        valorTemp      = Math.trunc(valorTemp / 10);
    }

    return valorInvertido;
}

// Interface interativa
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

function perguntar(msg) {
    return new Promise((resolve) => rl.question(msg, resolve));
}

async function main() {
    console.log("=== Versão 1: 4 dígitos ===");
    const entrada4 = await perguntar("Entre com um número de 4 dígitos: ");
    const num4 = parseInt(entrada4, 10);
    console.log(`O número ${num4} invertido é ${inverterQuatroDigitos(num4)}\n`);

    console.log("=== Versão 2: N dígitos ===");
    const entradaN = await perguntar("Entre com um número inteiro positivo: ");
    const numN = parseInt(entradaN, 10);
    console.log(`O número ${numN} invertido é ${inverterNDigitos(numN)}`);

    rl.close();
}

main();