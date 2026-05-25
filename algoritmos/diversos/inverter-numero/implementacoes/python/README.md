# Inverter Número — Python

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
python/
├── inverter_numero.py     ← Python puro, sem dependências
├── flask/                 ← REST API com Flask
│   └── app.py
└── README.md
```

---

## Como executar

### Python puro

Requerimento: Python 3.8 ou superior.

```bash
python inverter_numero.py
```

Execução interativa via terminal — o programa solicita o número e exibe o resultado
para as duas versões (4 dígitos e N dígitos).

### Flask

Requerimento: Python 3.8+, pip.

```bash
cd flask

# Instalar dependência
pip install flask

# Executar
python app.py
```

Endpoints disponíveis:

```
GET http://localhost:5000/inverter/4digitos?numero=2548
GET http://localhost:5000/inverter/ndigitos?numero=123456789
```

Resposta (JSON):

```json
{ "original": 2548, "invertido": 8452 }
```

> **Boa prática:** use um ambiente virtual para isolar as dependências.
>
> ```bash
> python -m venv .venv
> source .venv/bin/activate      # Linux / macOS
> .venv\Scripts\activate         # Windows
> pip install flask
> python app.py
> ```

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via `//` (divisão inteira) e `%`,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while valor_temp > 0`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito
(`valor_temp // 10`). Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*