# Inverter Número — Java

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
java/
├── InverterNumero.java     ← Java puro, sem dependências
├── spring-boot/            ← projeto Spring Boot completo (REST API)
│   └── src/
│       └── main/
│           └── java/
│               └── com/exemplo/inverter/
│                   ├── InverterApplication.java
│                   └── InverterNumeroController.java
└── README.md
```

---

## Como executar

### Java puro

Requerimento: JDK 8 ou superior.

```bash
javac InverterNumero.java
java InverterNumero
```

### Spring Boot

Requerimento: JDK 17+, Maven.

1. Crie um projeto base em [https://start.spring.io](https://start.spring.io)
   com a dependência **Spring Web**.
2. Copie `InverterApplication.java` e `InverterNumeroController.java`
   para `src/main/java/com/exemplo/inverter/`.
3. Execute:

```bash
mvn spring-boot:run
```

Endpoints disponíveis:

```
GET http://localhost:8080/inverter/4digitos?numero=2548
GET http://localhost:8080/inverter/ndigitos?numero=123456789
```

Resposta (JSON):

```json
{ "original": 2548, "invertido": 8452 }
```

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via divisão e módulo por 1000, 100 e 10,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while (valorTemp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito (`/ 10`).
Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*