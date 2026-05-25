// Ap 21,5
#include <stdio.h>

int main()
{
    int valor_inicial, valor_temp, milhar, centena, dezena, unidade, valor_invertido;

    printf("Entre com um numero: \n");
    scanf("%d", &valor_inicial);

    valor_temp = valor_inicial;
    
    milhar = valor_temp / 1000;
    valor_temp = valor_temp % 1000;
    centena = valor_temp / 100;
    valor_temp = valor_temp % 100;
    dezena = valor_temp / 10;
    valor_temp = valor_temp % 10;
    unidade = valor_temp;

    valor_invertido = unidade * 1000;
    valor_invertido = valor_invertido + (dezena * 100);
    valor_invertido = valor_invertido + (centena * 10);
    valor_invertido = valor_invertido + milhar;
    
    printf("O numero %d invertido é %d\n", valor_inicial, valor_invertido);

    return 0;
}