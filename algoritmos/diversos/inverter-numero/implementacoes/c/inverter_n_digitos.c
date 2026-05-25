// Ecl 3,1
#include <stdio.h>

int main() {
    int valor_inicial, valor_temp, digito, valor_invertido;

    printf("Entre com um número inteiro positivo: ");
    scanf("%d", &valor_inicial);

    valor_temp = valor_inicial;
    valor_invertido = 0;

    while (valor_temp > 0) {

        digito = valor_temp % 10;
        valor_invertido = (valor_invertido * 10) + digito;
        valor_temp = valor_temp / 10;
    }

    printf("O número %d invertido é %d\n", valor_inicial, valor_invertido);

    return 0;
}