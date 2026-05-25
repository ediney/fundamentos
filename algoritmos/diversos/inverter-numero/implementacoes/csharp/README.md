# Inverter Número — C#

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
csharp/
├── console/              ← aplicação de console, sem framework web
│   └── InverterNumero.cs
├── aspnet/               ← REST API com ASP.NET Core (Minimal API)
│   └── Program.cs
└── README.md
```

> Ambas as versões usam estrutura de projeto `.csproj`, por isso cada uma
> fica em sua própria subpasta.

---

## Como executar

### Console

Requerimento: .NET SDK 6.0 ou superior.

```bash
cd console

# Criar projeto (apenas na primeira vez)
dotnet new console -n InverterNumero
# Substitua o Program.cs gerado por InverterNumero.cs

dotnet run
```

Alternativa com compilador legado (Mono):

```bash
csc InverterNumero.cs
mono InverterNumero.exe
```

### ASP.NET Core — Minimal API

Requerimento: .NET SDK 6.0 ou superior.

```bash
cd aspnet

# Criar projeto (apenas na primeira vez)
dotnet new web -n InverterNumeroApi
# Substitua o Program.cs gerado pelo arquivo fornecido

dotnet run
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

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via `/` (divisão inteira) e `%`,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while (valorTemp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`invertido * 10 + digito`), descarta o dígito
(`valorTemp / 10`). Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*