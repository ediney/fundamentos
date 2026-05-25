# Inverter Número — PHP

Baseado em: Medina & Fertig — *Algoritmos e Programação, Teoria e Prática*, 2ª ed., p. 40

---

## Estrutura

```
php/
├── inverterNumero.php           ← PHP puro, funciona via CLI e navegador
├── laravel/                     ← REST API com Laravel
│   └── app/
│       └── Http/
│           └── Controllers/
│               └── InverterNumeroController.php
└── README.md
```

---

## Como executar

### PHP puro — CLI

Requerimento: PHP 8.0 ou superior.

```bash
php inverterNumero.php
```

Execução interativa via terminal — o programa solicita o número e exibe o resultado
para as duas versões (4 dígitos e N dígitos).

### PHP puro — Web (navegador)

Coloque `inverterNumero.php` em um servidor Apache, Nginx ou use o servidor embutido:

```bash
php -S localhost:8080
```

Acesse no navegador:

```
# Versão 4 dígitos
http://localhost:8080/inverterNumero.php?numero=2548&versao=4

# Versão N dígitos
http://localhost:8080/inverterNumero.php?numero=123456789&versao=n
```

Resposta (JSON):

```json
{ "original": 2548, "invertido": 8452 }
```

### Laravel

Requerimento: PHP 8.1+, Composer.

1. Crie um projeto Laravel: `composer create-project laravel/laravel laravel`
2. Copie `InverterNumeroController.php` para `app/Http/Controllers/`.
3. Adicione as rotas em `routes/api.php`:

```php
use App\Http\Controllers\InverterNumeroController;

Route::get('/inverter/4digitos', [InverterNumeroController::class, 'quatroDigitos']);
Route::get('/inverter/ndigitos',  [InverterNumeroController::class, 'nDigitos']);
```

4. Execute:

```bash
cd laravel
php artisan serve
```

Endpoints disponíveis:

```
GET http://localhost:8000/api/inverter/4digitos?numero=2548
GET http://localhost:8000/api/inverter/ndigitos?numero=123456789
```

Resposta (JSON):

```json
{ "original": 2548, "invertido": 8452 }
```

---

## Lógica

**Versão 4 dígitos** — extrai cada posição via `intdiv()` e `%`,
depois recombina na ordem inversa. Aceita apenas números de exatamente 4 dígitos.

**Versão N dígitos** — loop `while ($valorTemp > 0)`: extrai o dígito menos
significativo (`% 10`), acumula (`$invertido * 10 + $digito`), descarta o dígito
(`intdiv($valorTemp, 10)`). Funciona para qualquer número inteiro positivo.

---

*Pv 16:3*