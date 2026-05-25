# Inverter Número — JavaScript

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
javascript/
├── inverterNumero.js     ← Node.js puro, sem dependências
├── express/              ← REST API com Express.js
│   └── server.js
└── README.md
```

---

## Como executar

### Node.js puro

Requerimento: Node.js 14 ou superior.

```bash
node inverterNumero.js
```

Execução interativa via terminal — o programa solicita o número e exibe o resultado.

### Express

Requerimento: Node.js 14+.

```bash
cd express
npm install express
node server.js
```

Endpoints disponíveis:

```
GET http://localhost:3000/inverter/4digitos?numero=2548
GET http://localhost:3000/inverter/ndigitos?numero=123456789
```

Resposta (JSON):

```json
{ "original": 2548, "invertido": 8452 }
```

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via `Math.trunc()` e `%`,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while (valorTemp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito
(`Math.trunc(valorTemp / 10)`). Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*