# Inverter Número — COBOL

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
cobol/
├── InverterNumero.cob     ← contém as duas versões do algoritmo em paragraphs distintos
└── README.md
```

As duas versões (4 dígitos e N dígitos) estão no mesmo arquivo, organizadas como
`PARAGRAPH`s separados dentro da `PROCEDURE DIVISION`, conforme a convenção COBOL.

---

## Como executar

### Linux / macOS — GnuCOBOL

Requerimento: GnuCOBOL 3.x (`cobc`).

```bash
# Instalar GnuCOBOL (se necessário)
sudo apt install gnucobol        # Debian / Ubuntu
brew install gnucobol            # macOS

# Compilar
cobc -x -free InverterNumero.cob -o InverterNumero

# Executar
./InverterNumero
```

### Windows — GnuCOBOL

```bash
# Com GnuCOBOL instalado via instalador oficial (https://gnucobol.sourceforge.io)
cobc -x -free InverterNumero.cob -o InverterNumero.exe
InverterNumero.exe
```

> A flag `-free` habilita o formato livre de código-fonte (sem margens fixas de coluna),
> que é o estilo usado neste arquivo.

---

## Lógica

**Versão 4 dígitos** (`VERSAO-4-DIGITOS`) — extrai cada posição via `DIVIDE ... GIVING ... REMAINDER`,
depois recombina na ordem inversa com `COMPUTE`. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** (`VERSAO-N-DIGITOS`) — loop `PERFORM UNTIL WS-TEMP-N = 0`:
extrai o dígito menos significativo via `FUNCTION MOD`, acumula, descarta o dígito
com `DIVIDE 10 INTO WS-TEMP-N GIVING WS-TEMP-N`. Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*