/*
- Descreva um algoritmo que leia 10 números inteiros e os coloque em um vetor de 10 posições do tipo inteiro.
 Escreva na ordem inversa em que foram lidos. Faça um método para ler e outro para escrever.
 */

import java.util.Scanner;

public class Uni6Exe01 {
    private Uni6Exe01() {
        Scanner teclado = new Scanner(System.in);

        // criei o vetor
        final int valorTamanho = 10;
        int valor[] = new int[valorTamanho];

        // ler vetor
        valorLer(valorTamanho, valor, teclado);

        // escrever vetor
        valorEscrever(valorTamanho, valor);

        teclado.close();
    }

    // Esse método é responsável por ler os 10 valores que o usuário vai digitar e
    // armazená-los no vetor.
    // O for percorre o vetor de 0 a 9, e a cada iteração pede ao usuário para
    // inserir um número, que é armazenado na posição correspondente do vetor
    // (valor[i]).
    // Se o usuário digita 5 como primeiro número, ele é armazenado em valor[0]. O
    // próximo número digitado é armazenado em valor[1], e assim por diante.
    private void valorLer(int valorTamanho, int valor[], Scanner teclado) {
        for (int i = 0; i < valorTamanho; i++) {
            System.out.print("Valor[" + i + "]: ");
            valor[i] = teclado.nextInt();
        }
    }

    // O for aqui começa no índice valorTamanho - 1 (ou seja, 9, que é o último
    // índice do vetor) e vai até 0.
    // Em cada iteração, o valor correspondente é impresso, mostrando os números na
    // ordem inversa de como foram lidos.

    private void valorEscrever(int valorTamanho, int valor[]) {
        for (int i = valorTamanho - 1; i >= 0; i--) {
            System.out.println("");
            System.out.println("Valor[" + i + "]: " + valor[i]);
        }
    }

    public static void main(String[] args) {
        new Uni6Exe01();
    }
}

// Armazenamento: O vetor valor[] armazena os 10 números na ordem em que foram
// lidos.
// Acesso Inverso: No método valorEscrever, o for acessa o vetor do último
// índice ao primeiro, imprimindo os valores em ordem inversa.