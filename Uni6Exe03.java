/*
  Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real. 
  Em seguida, modifique o vetor de modo que os valores das posições ímpares sejam aumentados em 5% e os das posições 
  pares sejam aumentados em 2%. Imprima o vetor resultante. Faça um método para ler os valores, outro para ajustar os 
  valores dentro do vetor e outro para escrever os valores atualizados do vetor.
 */

import java.util.Scanner;

public class Uni6Exe03 {
    private Uni6Exe03() {
        Scanner teclado = new Scanner(System.in);

        double vetValores[] = new double[12]; // vetor com 12 valores reais
        vetorLer(vetValores, teclado); // leitura dos valores
        vetorAjustar(vetValores); // ajuste dos valores conforme o enunciado
        vetorEscrever(vetValores); // exibição dos valores ajustados

        teclado.close();
    }

    // Lê os 12 valores reais a partir do teclado e os armazena no vetor vetValores.
    // Esse método utiliza um loop for para iterar 12 vezes (tamanho do vetor). Em
    // cada iteração, ele lê um valor e o armazena na posição i do vetor vetValores.
    private void vetorLer(double vetValores[], Scanner teclado) {
        for (int i = 0; i < vetValores.length; i++) {
            System.out.print("vetor[" + i + "]: ");
            vetValores[i] = teclado.nextDouble();
        }
    }

    // Ajusta os valores no vetor de acordo com suas posições:
    // Se a posição i é par (i % 2 == 0), o valor naquela posição é multiplicado por
    // 1.02, o que representa um aumento de 2%.
    // Se a posição i é ímpar, o valor é multiplicado por 1.05, aumentando-o em 5%.
    // Esse método utiliza um loop for que percorre o vetor vetValores e faz o
    // ajuste em cada posição conforme a regra.

    private void vetorAjustar(double vetValores[]) {
        for (int i = 0; i < vetValores.length; i++) {
            if (i % 2 == 0) {
                vetValores[i] *= 1.02; // aumento de 2% para posições pares
            } else {
                vetValores[i] *= 1.05; // aumento de 5% para posições ímpares
            }
        }
    }

    // Esse método imprime cada valor do vetor vetValores com os ajustes já
    // aplicados.
    // Utiliza um loop for para iterar pelo vetor e exibir cada valor na tela.

    private void vetorEscrever(double vetValores[]) {
        for (int i = 0; i < vetValores.length; i++) {
            System.out.println("vetor[" + i + "]: " + vetValores[i]);
        }
    }

    public static void main(String[] args) {
        new Uni6Exe03();
    }
}
