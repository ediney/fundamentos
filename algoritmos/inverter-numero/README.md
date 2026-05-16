# Inverter Número

## Contexto

No livro "Algoritmos e Programação, Teoria e Prática", 2a edição, de Marco Medina e Cristina Fertig, na página 40, em seu Capítulo 2, Fundamentos, tem uma seção chamada "2.6.2.1 Exercício 1 - Escrever invertido um número de quatro dígitos (exercício 5)". Em seguida é apresentado um código que atende ao que foi solicitado na página 38, onde pede-se: 

"5. Faça um algoritmo que leia um número de 4 dígitos e escreva-o invertido. Por exemplo, se o número lido for 2548, o resultado será 8452". 

Receber um número de quatro dígitos e retornar o valor invertido.

É importante observar que o código apresentado pelo livro, devidamente implementado e testado só possui a opção de informar 4 dígitos. Por esse motivo resolvemos implementar também um versão mais ampla, para n digitos, na sequência.

---

## Pseudocódigo

Algoritmo InverterNumero

Início

    Declare:
        valor_inicial, valor_temp
        milhar, centena, dezena, unidade
        valor_invertido : inteiro

    Escreva("Entre com um número:")
    Leia(valor_inicial)

    valor_temp ← valor_inicial

    milhar ← valor_temp DIV 1000
    valor_temp ← valor_temp MOD 1000

    centena ← valor_temp DIV 100
    valor_temp ← valor_temp MOD 100

    dezena ← valor_temp DIV 10
    valor_temp ← valor_temp MOD 10

    unidade ← valor_temp

    valor_invertido ← unidade * 1000
    valor_invertido ← valor_invertido + (dezena * 100)
    valor_invertido ← valor_invertido + (centena * 10)
    valor_invertido ← valor_invertido + milhar

    Escreva("O número ", valor_inicial,
             " invertido é ", valor_invertido)

FimAlgoritmo

---

Algoritmo InverterNumero_N_Digitos

Início

    Declare:
        valor_inicial, valor_temp, digito, valor_invertido : inteiro

    Escreva("Entre com um número inteiro positivo:")
    Leia(valor_inicial)

    valor_temp ← valor_inicial
    valor_invertido ← 0

    // O laço vai continuar rodando até que todos os dígitos 
    // do valor_temp tenham sido processados.
    Enquanto (valor_temp > 0) Faça
        
        // 1. Pega o último dígito do número atual
        digito ← valor_temp MOD 10
        
        // 2. "Abre espaço" no valor invertido multiplicando por 10 
        // e soma o dígito extraído
        valor_invertido ← (valor_invertido * 10) + digito
        
        // 3. Remove o último dígito do valor temporário
        valor_temp ← valor_temp DIV 10
        
    FimEnquanto

    Escreva("O número ", valor_inicial, " invertido é ", valor_invertido)

FimAlgoritmo

---

## Implementações

- C
- Java
- JavaScript
- TypeScript
- PHP
- Python
- C#
- COBOL

---
Pv 16:3