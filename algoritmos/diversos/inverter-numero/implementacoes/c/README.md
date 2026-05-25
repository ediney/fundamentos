# Inverter Número — C

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
c/
├── inverter_4digitos.c    ← versão do livro: extração explícita de cada posição
├── inverter_n_digitos.c   ← versão genérica: loop para qualquer quantidade de dígitos
└── README.md
```

> Os dois arquivos são mantidos separados intencionalmente: cada um representa
> uma solução distinta apresentada no livro, com lógicas diferentes.

---

## Como executar

### Linux / macOS — GCC

```bash
# Versão 4 dígitos
gcc -o inverter_4digitos inverter_4digitos.c
./inverter_4digitos

# Versão N dígitos
gcc -o inverter_n_digitos inverter_n_digitos.c
./inverter_n_digitos
```

### Windows — MinGW

```bash
# Versão 4 dígitos
gcc -o inverter_4digitos.exe inverter_4digitos.c
inverter_4digitos.exe

# Versão N dígitos
gcc -o inverter_n_digitos.exe inverter_n_digitos.c
inverter_n_digitos.exe
```

### Alternativa com Clang

```bash
clang -o inverter_4digitos inverter_4digitos.c
./inverter_4digitos

clang -o inverter_n_digitos inverter_n_digitos.c
./inverter_n_digitos
```

---

## Lógica

**`inverter_4digitos.c`** — extrai cada posição via divisão e módulo por 1000, 100 e 10,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**`inverter_n_digitos.c`** — loop `while (valor_temp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito (`/ 10`).
Funciona para qualquer número inteiro positivo.

---

*Ap 21,5*