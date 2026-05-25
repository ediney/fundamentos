# Inverter Número — TypeScript

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
typescript/
├── inverterNumero.ts     ← TypeScript puro, sem framework
├── nestjs/               ← REST API com NestJS
│   └── src/
│       └── inverter.controller.ts
└── README.md
```

---

## Como executar

### TypeScript puro

Requerimento: Node.js 14+, TypeScript instalado.

```bash
# Execução direta (recomendado para desenvolvimento)
npx ts-node inverterNumero.ts

# Ou compilar e executar
npx tsc inverterNumero.ts
node inverterNumero.js
```

### NestJS

Requerimento: Node.js 16+.

```bash
cd nestjs
npm install @nestjs/common @nestjs/core @nestjs/platform-express reflect-metadata rxjs
npx nest start
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

> **Nota:** para um projeto NestJS completo, gere o scaffolding com
> `npx @nestjs/cli new nestjs` e copie o controller para `src/`.
> Registre `InverterController` no módulo raiz (`app.module.ts`).

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via `Math.trunc()` e `%` com tipagem
explícita (`number`), depois recombina na ordem inversa.
Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while (valorTemp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito
(`Math.trunc(valorTemp / 10)`). Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*