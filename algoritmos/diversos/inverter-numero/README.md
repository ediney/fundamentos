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

    Enquanto (valor_temp > 0) Faça
        
        digito ← valor_temp MOD 10
        
        valor_invertido ← (valor_invertido * 10) + digito
        
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

## Como executar cada implementação
 
### C — puro (GCC)
```bash
# Compilar e executar (Linux / macOS)
gcc -o inverterNumero inverterNumero.c
./inverterNumero
 
# Windows (MinGW)
gcc -o inverterNumero.exe inverterNumero.c
inverterNumero.exe
 
# Alternativa com Clang
clang -o inverterNumero inverterNumero.c
./inverterNumero
```
 
---
 
### Java — puro
```bash
javac InverterNumero.java
java InverterNumero
```
 
### Java — Spring Boot
```bash
# Crie um projeto Spring Boot via https://start.spring.io
# Copie os arquivos para src/main/java/com/exemplo/inverter/
mvn spring-boot:run
# GET http://localhost:8080/inverter/4digitos?numero=2548
# GET http://localhost:8080/inverter/ndigitos?numero=123456789
```
 
### JavaScript — puro
```bash
node inverterNumero.js
```
 
### JavaScript — Express
```bash
npm install express
node server.js
# GET http://localhost:3000/inverter/4digitos?numero=2548
```
 
### TypeScript — puro
```bash
npx ts-node inverterNumero.ts
```
 
### TypeScript — NestJS
```bash
npm install @nestjs/common @nestjs/core @nestjs/platform-express
npx nest start
# GET http://localhost:3000/inverter/4digitos?numero=2548
```
 
### PHP — puro (CLI)
```bash
php inverterNumero.php
```
 
### PHP — puro (Web)
```
inverterNumero.php?numero=2548&versao=4
inverterNumero.php?numero=123456789&versao=n
```
 
### PHP — Laravel
```bash
# Adicione as rotas em routes/api.php (ver comentário no arquivo)
php artisan serve
# GET http://localhost:8000/api/inverter/4digitos?numero=2548
```
 
### Python — puro
```bash
python inverter_numero.py
```
 
### Python — Flask
```bash
pip install flask
python app.py
# GET http://localhost:5000/inverter/4digitos?numero=2548
```
 
### C# — puro
```bash
dotnet run
# ou: csc InverterNumero.cs && mono InverterNumero.exe
```
 
### C# — ASP.NET Core
```bash
dotnet new web -n InverterNumeroApi
# Substitua Program.cs pelo arquivo fornecido
dotnet run
# GET http://localhost:5000/inverter/4digitos?numero=2548
```
 
### COBOL
```bash
cobc -x -free InverterNumero.cob -o InverterNumero
./InverterNumero
```
 
---

## Lógica dos dois algoritmos
 
**Versão 4 dígitos** (fiel ao livro): extrai cada posição via divisão e módulo por 1000, 100, 10, depois recombina na ordem inversa.
 
**Versão N dígitos**: loop `enquanto > 0` — extrai o dígito menos significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito (`// 10`).

---

*Pv 16:3*